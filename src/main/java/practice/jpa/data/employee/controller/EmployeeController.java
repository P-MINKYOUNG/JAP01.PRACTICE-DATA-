package practice.jpa.data.employee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import practice.jpa.data.common.Pagenation;
import practice.jpa.data.common.PagingButtonInfo;
import practice.jpa.data.employee.dto.DepartmentDTO;
import practice.jpa.data.employee.dto.EmployeeDTO;
import practice.jpa.data.employee.dto.JobDTO;
import practice.jpa.data.employee.dto.SalGradeDTO;
import practice.jpa.data.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/* 전체 사원 목록 조회 */
	@GetMapping("/list")
	public String findAllEmployee(@PageableDefault Pageable pageable, Model model) {

		Page<EmployeeDTO> employeeList = employeeService.findAllEmployee(pageable);

		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(employeeList);

		model.addAttribute("paging", paging);
		model.addAttribute("employeeList", employeeList);

		return "employee/list";
	}

	/* 사원 이름으로 목록 조회 */
	@GetMapping(value = "/name", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<EmployeeDTO> searchName() {
		return employeeService.searchName();
	}

	@GetMapping("/search")
	public void searchPage() {
	}

	@PostMapping("/search")
	public String searchEmployeeByName(EmployeeDTO findName, Model model) {

		EmployeeDTO employee = employeeService.searchEmployeeByName(findName);

		model.addAttribute("employee", employee);

		return "employee/one";
	}

	/* XX년도 이후 입사자 */
	@GetMapping("/date")
	public void searchbyDatePage() {
	}

	@GetMapping("/hireDate")
	public String searchByDate(String hireDate, Model model) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(hireDate);

		List<EmployeeDTO> employeeList = employeeService.searchByDate(date);

		model.addAttribute("employeeList", employeeList);

		return "employee/list2";
	}
	
	/* 새로운 직원 등록 */
	@GetMapping("/regist")
	public void registPage() {}
	
	/* 선택을 위한 값 받아오기 */
	@GetMapping(value="/department", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<DepartmentDTO> selectDepartment(){
		return employeeService.selectDepartment();
	}
	
	@GetMapping(value="/job", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<JobDTO> selectJob(){
		return employeeService.selectJob();
	}
	
	@GetMapping(value="/salGrade", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<SalGradeDTO> selectSalGrade(){
		return employeeService.selectSalGrade();
	}
	
	/* 새로운 사원 등록 */
	@PostMapping("/regist")
	public String registEmployee(EmployeeDTO employee) {
		
		employeeService.registEmployee(employee);
		
		return "redirect:/";
	}
	
	/* 사원 삭제 */
	@GetMapping("/delete")
	public void deletePage() {}
	
	@PostMapping("/delete")
	public String deleteEmployee(EmployeeDTO employee) {
		
		employeeService.deleteEmployee(employee);
		
		return "redirect:/";
		
	}
}
