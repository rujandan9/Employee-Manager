package tech.getarray.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="employees")
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
    private Date dataAngajarii;
    private String telefon;
    private String observatii;

//    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER, optional = false)
//    private Permis permis;
//
//    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER, optional = false)
//    private ImageModel image;

//    @OneToOne(mappedBy = "employees", fetch = FetchType.EAGER)
//    @JoinColumn(name = "id", nullable = false)
//    private ImageModel permis;




    public Employee() {
    }


    public Employee(String name, String prenume, String functie, Integer salariu, Date varsta, Date dataAngajarii, String telefon, String observatii) {
        this.name = name;
        this.prenume = prenume;
        this.functie = functie;
        this.salariu = salariu;
        this.varsta = varsta;
        this.dataAngajarii = dataAngajarii;
        this.telefon = telefon;
        this.observatii = observatii;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Integer getId() {
        return id;
    }


    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setSalariu(Integer salariu) {
        this.salariu = salariu;
    }

    public Date getVarsta() {
        return varsta;
    }

    public void setVarsta(Date varsta) {
        this.varsta = varsta;
    }

    public Date getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Date dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
//
//    public Permis getPermis() {
//        return permis;
//    }
//
//    public void setPermis(Permis permis) {
//        this.permis = permis;
//    }
//
//    public ImageModel getImage() {
//        return image;
//    }
//
//    public void setImage(ImageModel image) {
//        this.image = image;
//    }
}
