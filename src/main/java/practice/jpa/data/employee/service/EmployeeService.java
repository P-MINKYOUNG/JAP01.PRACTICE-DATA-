package practice.jpa.data.employee.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import practice.jpa.data.employee.dto.DepartmentDTO;
import practice.jpa.data.employee.dto.EmployeeDTO;
import practice.jpa.data.employee.dto.JobDTO;
import practice.jpa.data.employee.dto.SalGradeDTO;
import practice.jpa.data.employee.entity.Department;
import practice.jpa.data.employee.entity.Employee;
import practice.jpa.data.employee.entity.Job;
import practice.jpa.data.employee.entity.SalGrade;
import practice.jpa.data.employee.repository.DepartmentRepository;
import practice.jpa.data.employee.repository.EmployeeRepository;
import practice.jpa.data.employee.repository.JobRepository;
import practice.jpa.data.employee.repository.SalGradeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final JobRepository jobRepository;
	private final SalGradeRepository salGradeRepository;
	private final ModelMapper modelMapper;

	public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, JobRepository jobRepository, SalGradeRepository salGradeRepository,
			ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.jobRepository = jobRepository;
		this.salGradeRepository = salGradeRepository;
		this.modelMapper = modelMapper;
	}

	/* 모든 사원 목록 조회 */
	public Page<EmployeeDTO> findAllEmployee(Pageable pageable) {

		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
				pageable.getPageSize(), Sort.by("empId").ascending());

		Page<Employee> employeeList = employeeRepository.findAll(pageable);

		return employeeList.map(row -> modelMapper.map(row, EmployeeDTO.class));
	}

	/* 사원 이름으로 조회 */
	public List<EmployeeDTO> searchName() {

		List<Employee> employeeList = employeeRepository.findAll();

		return employeeList.stream().map(row -> modelMapper.map(row, EmployeeDTO.class)).collect(Collectors.toList());
	}

	public EmployeeDTO searchEmployeeByName(EmployeeDTO findName) {

		Employee employee = employeeRepository.findById(findName.getEmpId()).orElseThrow(IllegalArgumentException::new);

		return modelMapper.map(employee, EmployeeDTO.class);
	}

	/* 입사일 비교(QueryMethod) */
	public List<EmployeeDTO> searchByDate(Date date) {

		List<Employee> employeeList = employeeRepository.findByHireDateGreaterThan(date, Sort.by("empId").ascending());

		return employeeList.stream().map(row -> modelMapper.map(row, EmployeeDTO.class)).collect(Collectors.toList());
	}
	
	/* 저장을 위한 목록 조회 */
	public List<DepartmentDTO> selectDepartment() {
		
		List<Department> departmentList = departmentRepository.findAll();
		
		return departmentList.stream().map(row -> modelMapper.map(row, DepartmentDTO.class)).collect(Collectors.toList());
	}

	public List<JobDTO> selectJob() {
		
		List<Job> jobList = jobRepository.findAll();
		
		return jobList.stream().map(row -> modelMapper.map(row, JobDTO.class)).collect(Collectors.toList());
	}

	public List<SalGradeDTO> selectSalGrade() {
		
		List<SalGrade> salGradeList = salGradeRepository.findAll();
		
		return salGradeList.stream().map(row -> modelMapper.map(row, SalGradeDTO.class)).collect(Collectors.toList());
	}

	/* 저장 */
	public void registEmployee(EmployeeDTO employee) {
		
		employeeRepository.save(modelMapper.map(employee, Employee.class));
		
	}

}
