package tech.getarray.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarray.employeemanager.model.Employee;
import tech.getarray.employeemanager.model.ImageModel;
import tech.getarray.employeemanager.repository.EmployeeRepository;
import tech.getarray.employeemanager.repository.ImageRepository;

import java.util.Optional;

@RequestMapping("/rest")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/employee")
    public Iterable<Employee> getEventList(){
        System.out.println("A fost ceruta lista de Employee");

        return this.employeeRepository.findAll();
    }

    @GetMapping("/employee/imagine/{idEmployee}/{tipImagine}")
    public ImageModel getImagineForEmployee(@PathVariable("idEmployee") int idEmployee, @PathVariable("tipImagine") String tipImagine){
        Employee employee = this.employeeRepository.findById(idEmployee).get();
        ImageModel imaginea = this.imageRepository.findByEmployeeAndImageType(employee, tipImagine);
        return imaginea;
    }



    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    @PutMapping("/employee/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Integer id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setPrenume(newEmployee.getPrenume());
                    employee.setDataAngajarii(newEmployee.getDataAngajarii());
                    employee.setFunctie(newEmployee.getFunctie());
                    employee.setSalariu(newEmployee.getSalariu());
                    employee.setVarsta(newEmployee.getVarsta());
                    employee.setTelefon(newEmployee.getTelefon());
                    employee.setObservatii(newEmployee.getObservatii());


                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable("id") Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
