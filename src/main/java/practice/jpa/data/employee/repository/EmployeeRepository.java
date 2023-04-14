package practice.jpa.data.employee.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import practice.jpa.data.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	/* 전달받은 날짜보다 후에 입사한 사람 조회 */
	Page<Employee> findByHireDateGreaterThan(Date date, Pageable pageable);

}
