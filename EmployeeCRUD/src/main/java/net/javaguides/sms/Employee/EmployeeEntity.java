package net.javaguides.sms.Employee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.javaguides.sms.Department.DepartmentMaster;
  
 
@Entity
@Table(name="tbl_employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int id;
	
//	@Pattern(regexp = "[\\d]{5}", message = "Number must be 5 digits")
	@Column(name="employee_Id")
	private Long employeeId;
	 
	@NotBlank(message = "First name is required")
	@Size(max = 255, message = "First name cannot  exceed {15} characters")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Last name is required")
	@Size(max = 255, message = "Last name cannot  exceed {15} characters")
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="designation")
	private String designation;
	
	@NotNull
	@Column(name="salary")
	private Float salary;
	
	@Column(name="city")
	private String city;
	
	@Column(name = "creation_date_time")
	@CreationTimestamp
	private LocalDateTime creationDateTime;
	
	@OneToMany(mappedBy = "employeeEntity",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<DepartmentMaster> depeartmentMaster = new ArrayList<>();

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(int id, Long employeeId, String firstName, String lastName, String designation, Float salary,
			String city, LocalDateTime creationDateTime) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
		this.creationDateTime = creationDateTime;
	}

	public EmployeeEntity(int id, Long employeeId, String firstName, String lastName, String designation, Float salary,
			String city, LocalDateTime creationDateTime, List<DepartmentMaster> depeartmentMaster) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
		this.creationDateTime = creationDateTime;
		this.depeartmentMaster = depeartmentMaster;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public List<DepartmentMaster> getDepeartmentMaster() {
		return depeartmentMaster;
	}

	public void setDepeartmentMaster(List<DepartmentMaster> depeartmentMaster) {
		this.depeartmentMaster = depeartmentMaster;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", designation=" + designation + ", salary=" + salary + ", city=" + city
				+ ", creationDateTime=" + creationDateTime + ", depeartmentMaster=" + depeartmentMaster + "]";
	}

	 
 
}
