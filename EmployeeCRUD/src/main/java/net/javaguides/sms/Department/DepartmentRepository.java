package net.javaguides.sms.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
public interface DepartmentRepository extends JpaRepository<DepartmentMaster, Integer>{

}
