package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="T_USER")
public class User implements Serializable {

	private Integer id;
	private String name;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;

	private List<Leave> leavesRequested;
	private List<Decision> decisions;

	public User() {
	}

	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user")
	public List<Leave> getLeavesRequested() {
		return leavesRequested;
	}

	public void setLeavesRequested(List<Leave> leavesRequested) {
		this.leavesRequested = leavesRequested;
	}

	@OneToMany(mappedBy = "user")
	public List<Decision> getDecisions() {
		return decisions;
	}

	public void setDecisions(List<Decision> decisions) {
		this.decisions = decisions;
	}

}
