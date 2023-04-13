package practice.jpa.data.employee.dto;

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
   private java.util.Date entDate;
   private String entYn;
   private java.util.Date hireDate;
   
   private DepartmentDTO department;
   
   
}