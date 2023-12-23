package net.javaguides.sms.Employee;

import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.misc.NotNull;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.javaguides.sms.Exception.ResourceNotFoundException;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getAllEmps")
	public  List<EmployeeEntity>  getAllEmployees(){
 		return employeeService.getAllEmp();
	}
	
	 
	@GetMapping("/getEmp/{Id}")
	public ResponseEntity<EmployeeEntity> getEmpById(@Valid @PathVariable("Id")Integer Id){
		Optional<EmployeeEntity> entity = employeeService.getEmpById(Id);
		if(entity == null) {
			throw new ResourceNotFoundException("Employee not found with id = " + Id );
		}
		if(entity.isPresent()) {
			return new ResponseEntity< >(entity.get(),HttpStatus.OK);
		}else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
 	}
	
	@PostMapping("/saveEmp")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) throws BadRequestException {
		if(employeeEntity.getFirstName() == null || employeeEntity.getLastName() == null ||
				employeeEntity.getDesignation() == null || employeeEntity.getCity() == null ) {
			throw new BadRequestException("Invalid Request . All field of First name, Last Name, Designation and City is required.");
		}
		EmployeeEntity emp = employeeService.saveEmp(employeeEntity);
		return new ResponseEntity<>( "Employee created successfully", HttpStatus.CREATED);
	}
	
	@PostMapping("/saveEmps")
	public ResponseEntity<List<EmployeeEntity>> saveEmployees(@Valid @RequestBody List<EmployeeEntity> emps){
		List<EmployeeEntity> employees = employeeService.saveEmps(emps);
		return new ResponseEntity< >(employees,HttpStatus.CREATED);
	}
	
	// update emp by Id
	@PutMapping("/updateEmp/{Id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@Valid @PathVariable("Id")int Id, @RequestBody EmployeeEntity employeeEntity){
		EmployeeEntity emp = employeeService.updateEmp(Id, employeeEntity);
		return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
	}
 	
    // get employee by first name
	@GetMapping("/employeeName")
	public ResponseEntity<EmployeeEntity> findEmpByFirstName(@Valid @RequestParam String firstName){
		Optional<EmployeeEntity> emp = employeeService.findEmpByFirstName(firstName);
		return emp.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
   
	}
	
	@PatchMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeEntity> updateEmp(@Valid @PathVariable int id, @RequestBody EmployeeEntity employeeEntity){
		Optional<EmployeeEntity> emp = employeeService.getEmpById(id);
		emp.get().setEmployeeId(employeeEntity.getEmployeeId());
		emp.get().setFirstName(employeeEntity.getFirstName());
		emp.get().setLastName(employeeEntity.getLastName());
		emp.get().setCity(employeeEntity.getCity());
		emp.get().setDesignation(employeeEntity.getDesignation());
		
		EmployeeEntity saveEmp = employeeService.saveEmp(emp.get());
		
		return new ResponseEntity<>(saveEmp,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable("id") int id ){
		employeeService.delete(id);
		return new ResponseEntity< >("Employee of Id " + id + " deleted.",HttpStatus.NO_CONTENT);
	}
	
	 
 }
