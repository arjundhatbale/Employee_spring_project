package net.javaguides.sms.Department;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	private final DepartmentRepository  departmentRepository;
	
	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	public DepartmentMaster saveDpt(DepartmentMaster departmentMaster) {
		return departmentRepository.save(departmentMaster);
	}
	
	// get All Department
	public List<DepartmentMaster> getallDpt() {
		return departmentRepository.findAll();
	}
	
	public Optional<DepartmentMaster> findDptById(int  dpt_id){
		 Optional<DepartmentMaster> dpt = departmentRepository.findById(dpt_id);
		 return dpt;
	}
}
