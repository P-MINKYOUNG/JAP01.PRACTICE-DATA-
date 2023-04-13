package practice.jpa.data.employee.dto;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeDTO {
   
   private String empId;
   private String empName;
   private String empNo;
   private String email;
   private String phone;
   private String jobCode;
   private String salLevel;
   private int salary;
   private Double bonus;
   private String managerId;
   @DateTimeFormat(pattern = "yyyy-MM-dd")   
   private java.util.Date entDate;
   private String entYn;
   @DateTimeFormat(pattern = "yyyy-MM-dd")  
   private java.util.Date hireDate;
   private String deptId;
   
   private DepartmentDTO department;
   private JobDTO job;
   private SalGradeDTO salGrade;
   
   
}