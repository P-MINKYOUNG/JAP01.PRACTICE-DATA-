package practice.jpa.data.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "EMP_ID")
	private String empId;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_NO")
	private String empNo;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "JOB_CODE")
	private String jobCode;
	@Column(name = "SAL_LEVEL")
	private String salLevel;
	@Column(name = "SALARY")
	private int salary;
	@Column(name = "BONUS")
	private Double bonus;
	@Column(name = "MANAGER_ID")
	private String managerId;
	@Temporal(TemporalType.DATE)
	@Column(name = "ENT_DATE")
	private java.util.Date entDate;
	@Column(name = "ENT_YN")
	private String entYn;
	@Temporal(TemporalType.DATE)
	@Column(name = "HIRE_DATE")
	private java.util.Date hireDate;

	@JoinColumn(name = "DEPT_CODE")
	@ManyToOne
	private Department department;

	public Employee() {
	}

	public Employee(String empId, String empName, String empNo, String email, String phone, String jobCode,
			String salLevel, int salary, Double bonus, String managerId, Date entDate, String entYn, Date hireDate,
			Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.entDate = entDate;
		this.entYn = entYn;
		this.hireDate = hireDate;
		this.department = department;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public java.util.Date getEntDate() {
		return entDate;
	}

	public void setEntDate(java.util.Date entDate) {
		this.entDate = entDate;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	public java.util.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", jobCode=" + jobCode + ", salLevel=" + salLevel + ", salary=" + salary
				+ ", bonus=" + bonus + ", managerId=" + managerId + ", entDate=" + entDate + ", entYn=" + entYn
				+ ", hireDate=" + hireDate + ", department=" + department + "]";
	}

}