package tech.getarray.employeemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "image_model")
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




//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_employee", nullable = true)
//	private Employee employee;
//
//
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_employee_permis", nullable = true)
//	private Employee employeePermis;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

//	@Column(name = "picByte", length = 1000)
//	private byte[] picByte;
	@Column(name = "picByte")
	private String picByte;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicByte() {
		return picByte;
	}

	public void setPicByte(String picByte) {
		this.picByte = picByte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public Employee getEmployeePermis() {
//		return employeePermis;
//	}
//
//	public void setEmployeePermis(Employee employeePermis) {
//		this.employeePermis = employeePermis;
//	}
}
