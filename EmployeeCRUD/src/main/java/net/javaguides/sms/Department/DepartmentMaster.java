package net.javaguides.sms.Department;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import net.javaguides.sms.Employee.EmployeeEntity;

@Entity
@Table(name="tbl_Department")
public class DepartmentMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dpt_id;
	
	@Column(name="dep_name")
	private String dptName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	@JsonManagedReference
	private EmployeeEntity employeeEntity;

	public DepartmentMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentMaster(int dpt_id, String dptName, EmployeeEntity employeeEntity) {
		super();
		this.dpt_id = dpt_id;
		this.dptName = dptName;
		this.employeeEntity = employeeEntity;
	}

	public int getDpt_id() {
		return dpt_id;
	}

	public void setDpt_id(int dpt_id) {
		this.dpt_id = dpt_id;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DepartmentMaster [dpt_id=" + dpt_id + ", dptName=" + dptName + ", employeeEntity=" + employeeEntity
				+ "]";
	}
	
	
	
}
