package tech.getarray.employeemanager.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "image_model")
@Getter
@Setter
public class ImageModel {

	public ImageModel() {
		super();
	}

	public ImageModel(String name, String type, String picByte) {
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	@Column(name="image_type")
	private String imageType;


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Lob
	@Column(name = "picByte", columnDefinition = "BLOB")
	private String picByte;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;

}
