package practice.jpa.data.employee.dto;

import lombok.Data;

@Data
public class SalGradeDTO {
	
	private String salLevel;
	private Integer minSal;
	private Integer maxSal;

}
