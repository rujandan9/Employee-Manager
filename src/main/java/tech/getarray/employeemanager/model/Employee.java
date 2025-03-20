package tech.getarray.employeemanager.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="employees")
@Getter
@Setter
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String name;
    private String prenume;
    private String functie;
    private Integer salariu;
    private Date varsta;
    @Column(name="data_angajarii")
    private LocalDate dataAngajarii;
    private String telefon;
    private String observatii;
}
