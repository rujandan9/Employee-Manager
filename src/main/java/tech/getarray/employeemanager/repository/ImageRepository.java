package tech.getarray.employeemanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarray.employeemanager.model.Employee;
import tech.getarray.employeemanager.model.ImageModel;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);

	ImageModel findByEmployeeAndImageType(Employee employee, String typeImagine);


//	public ImageModel findByEmployee(Employee employee); // buletin
//	public ImageModel findByEmployeePermis(Employee employee); // permis
}
