package tech.getarray.employeemanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.getarray.employeemanager.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
