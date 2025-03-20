package tech.getarray.employeemanager.DTO;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Data
public class EmployeeDTO {

    private Integer id;
    private String name;
    private String prenume;
    private String functie;
    private Integer salariu;
    private Date varsta;
    private LocalDate dataAngajarii;
    private String telefon;
    private String observatii;
}
