package tech.getarray.employeemanager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "permis")
public class Permis {

    public Permis() {
        super();
    }

    public Permis(String name, String type, String picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "picByte")
    private String picByte;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
