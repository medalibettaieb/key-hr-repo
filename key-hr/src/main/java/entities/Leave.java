package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Leave
 *
 */
@Entity
@Table(name="T_LEAVE")
public class Leave implements Serializable {

	private Integer id;
	private String description;
	private Date dateOfTheLeave;
	private Double duration;
	private static final long serialVersionUID = 1L;

	private User user;
	private List<Decision> decisions;

	public Leave() {
		super();
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfTheLeave() {
		return this.dateOfTheLeave;
	}

	public void setDateOfTheLeave(Date dateOfTheLeave) {
		this.dateOfTheLeave = dateOfTheLeave;
	}

	public Double getDuration() {
		return this.duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(mappedBy = "leave")
	public List<Decision> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<Decision> decisions) {
		this.decisions = decisions;
	}

}
