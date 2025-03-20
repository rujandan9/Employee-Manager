package tech.getarray.employeemanager.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.getarray.employeemanager.model.Employee;
import tech.getarray.employeemanager.model.ImageModel;
import tech.getarray.employeemanager.repository.EmployeeRepository;
import tech.getarray.employeemanager.repository.ImageRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "image")
public class ImageUploadController {


	private final ImageRepository imageRepository;
	private final EmployeeRepository employeeRepository;

	@PostMapping("/upload/{imageType}/{idAngajat}")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file,
								   @PathVariable("imageType") String imageType,
								   @PathVariable("idAngajat") int idAngajat) throws IOException {

		log.info("Original Image Byte Size - " + file.getBytes().length);

		Employee employee = this.employeeRepository.findById(idAngajat).get();
		StringBuilder sb = new StringBuilder();
		sb.append("data:image/png;base64,");
		sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(file.getBytes(), false)));
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				sb.toString());
		img.setImageType(imageType);
		img.setEmployee(employee);
		imageRepository.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	void deleteImage(@PathVariable("id") Long id) {
		log.info("STERGE POZA ID: " + id);
		this.imageRepository.deleteById(id);
	}

	@GetMapping("/getAllImages")
	public Iterable<ImageModel> getAll(){
		log.info("A fost ceruta lista de imagini");

		return this.imageRepository.findAll();
	}
	@GetMapping(path = { "/get/{imageName}" })
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
				retrievedImage.get().getPicByte());
		return img;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressZLib(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		log.info("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressZLib(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}
