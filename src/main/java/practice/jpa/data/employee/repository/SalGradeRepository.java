package practice.jpa.data.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import practice.jpa.data.employee.entity.SalGrade;

public interface SalGradeRepository extends JpaRepository<SalGrade, String>{

}
