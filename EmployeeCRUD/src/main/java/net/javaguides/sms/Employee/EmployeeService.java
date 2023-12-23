package net.javaguides.sms.Employee;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

 
@Service
public class EmployeeService {

 	private final EmployeeRepository employeeRepository;
 	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
 	}
	
	public List<EmployeeEntity> getAllEmp( ){
		return employeeRepository.findAll( );
	}
	
	public Optional<EmployeeEntity> getEmpById( int  Id) {
		Optional<EmployeeEntity> emp = employeeRepository.findById( Id);
		return emp;
	}
	 
	public EmployeeEntity saveEmp(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}
	
	public List<EmployeeEntity> saveEmps(List<EmployeeEntity> employeeEntities){
		return employeeRepository.saveAll(employeeEntities);
	}
	
	public EmployeeEntity updateEmp(int Id ,EmployeeEntity employeeEntity ) {
		Optional<EmployeeEntity> existingEmp = employeeRepository.findById(Id);
		
		if(existingEmp.isPresent()) {
			EmployeeEntity extEmpPresent = existingEmp.get();
			extEmpPresent.setEmployeeId(employeeEntity.getEmployeeId());
			extEmpPresent.setFirstName(employeeEntity.getFirstName());
			extEmpPresent.setLastName(employeeEntity.getLastName());
			extEmpPresent.setCity(employeeEntity.getCity());
			
			return employeeRepository.save(extEmpPresent);
		}else {
             return null;
        }
	}
	public Optional<EmployeeEntity> findEmpByFirstName(String firstName){
		return employeeRepository.findByFirstName(firstName);
	}
	
	public void delete(int id) {
		Optional<EmployeeEntity> emp = getEmpById(id);
		if(emp.isPresent()) {
			employeeRepository.deleteById(id);
			System.out.println("Employee with Id : " + id + " is deleted successfully...");
		}else {
			System.out.println("Employee with Id : " + id + " is not found");
		}
	}
	
	 
//	// save emp with student
//	public EmployeeEntity saveEmpWithStudent(EmployeeEntity employeeEntity) {
//		StudentEntity student = employeeEntity.getStudentEntity();
//		
//		studentRepository.save(student);
//		employeeEntity.setStudentEntity(student);
//		return employeeRepository.save(employeeEntity);
//	}
}
