package practice.jpa.data.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practice.jpa.data.employee.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{

}
