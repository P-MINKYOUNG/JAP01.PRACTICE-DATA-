package practice.jpa.data.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SAL_GRADE")
public class SalGrade {
	
	@Id
	@Column(name="SAL_LEVEL")
	private String salLevel;
	@Column(name="MIN_SAL")
	private Integer minSal;
	@Column(name="MAX_SAL")
	private Integer masSal;

	public SalGrade() {}

	public SalGrade(String salLevel, Integer minSal, Integer masSal) {
		super();
		this.salLevel = salLevel;
		this.minSal = minSal;
		this.masSal = masSal;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public Integer getMinSal() {
		return minSal;
	}

	public void setMinSal(Integer minSal) {
		this.minSal = minSal;
	}

	public Integer getMasSal() {
		return masSal;
	}

	public void setMasSal(Integer masSal) {
		this.masSal = masSal;
	}

	@Override
	public String toString() {
		return "SalGrade [salLevel=" + salLevel + ", minSal=" + minSal + ", masSal=" + masSal + "]";
	}
	
	
}
