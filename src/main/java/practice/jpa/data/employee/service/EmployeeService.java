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

import practice.jpa.data.employee.dto.EmployeeDTO;
import practice.jpa.data.employee.entity.Employee;
import practice.jpa.data.employee.repository.DepartmentRepository;
import practice.jpa.data.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ModelMapper modelMapper;

	public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
			ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
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

	public List<EmployeeDTO> searchByDate(Date date) {

		List<Employee> employeeList = employeeRepository.findByHireDateGreaterThan(date, Sort.by("empId").ascending());

		return employeeList.stream().map(row -> modelMapper.map(row, EmployeeDTO.class)).collect(Collectors.toList());
	}

}
