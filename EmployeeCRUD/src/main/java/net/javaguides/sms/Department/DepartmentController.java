package net.javaguides.sms.Department;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dpt")
public class DepartmentController {

	private final DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/saveDpt")
	public ResponseEntity<DepartmentMaster> saveDepartment(@Valid @RequestBody DepartmentMaster departmentMaster){
		DepartmentMaster dpm = departmentService.saveDpt(departmentMaster);
		return new ResponseEntity< >(dpm,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllDpt")
	public ResponseEntity<List<DepartmentMaster>> getAllDepartment( ){
		
		try {
			List<DepartmentMaster> departments = departmentService.getallDpt()	;
			
			return new ResponseEntity< >(departments,HttpStatus.ACCEPTED);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity< >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
  	}
	
	@GetMapping("/dptGet/{dpt_id}")
	public ResponseEntity<DepartmentMaster> getDepartmentById(@Valid @PathVariable("dpt_id") int dpt_id){
		Optional<DepartmentMaster> dpt = departmentService.findDptById(dpt_id);
		
		if(dpt.isPresent()) {
			return new ResponseEntity< >(dpt.get(),HttpStatus.ACCEPTED);
		}else {
			System.err.println("The Department of Id : " + dpt_id + " is not found...");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
