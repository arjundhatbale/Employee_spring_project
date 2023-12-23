package net.javaguides.sms.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	Optional<EmployeeEntity> findByFirstName(String firstName);
 }
