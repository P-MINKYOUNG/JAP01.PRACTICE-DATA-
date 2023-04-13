package practice.jpa.data.employee.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;

import practice.jpa.data.employee.entity.Job;

public interface JobRepository extends JpaRepository<Job, String>{

}
