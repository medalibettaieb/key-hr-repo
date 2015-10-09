package entities;

import entities.User;
import java.io.Serializable;
import java.lang.Double;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee extends User implements Serializable {

	
	private Double experience;
	private static final long serialVersionUID = 1L;

	public Employee() {
		super();
	}   
	public Double getExperience() {
		return this.experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}
   
}
