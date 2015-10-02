package entities.training.oneToOneBi;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: B
 *
 */
@Entity

public class B implements Serializable {

	
	private Integer idB;
	private static final long serialVersionUID = 1L;
	
	private A a;

	public B() {
		super();
	}   
	@Id    
	public Integer getIdB() {
		return this.idB;
	}

	public void setIdB(Integer idB) {
		this.idB = idB;
	}
	@OneToOne
	public A getA() {
		return a;
	}
	public void setA(A a) {
		this.a = a;
	}
   
}
