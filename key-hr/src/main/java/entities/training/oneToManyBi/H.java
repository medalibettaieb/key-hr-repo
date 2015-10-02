package entities.training.oneToManyBi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: H
 *
 */
@Entity
public class H implements Serializable {

	private Integer idH;
	private static final long serialVersionUID = 1L;

	private G g;

	public H() {
		super();
	}

	@Id
	public Integer getIdH() {
		return this.idH;
	}

	public void setIdH(Integer idH) {
		this.idH = idH;
	}

	@ManyToOne
	public G getG() {
		return g;
	}

	public void setG(G g) {
		this.g = g;
	}

}
