package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Decision
 *
 */
@Entity
@Table(name = "T_DECISION")
public class Decision implements Serializable {
	private DecisionID decisionID;
	private Date dateOfDecision;
	private DecisionState decisionState;
	private static final long serialVersionUID = 1L;

	private User user;
	private Leave leave;

	public Decision() {
		super();
	}

	public Decision(Date dateOfDecision, DecisionState decisionState,
			User user, Leave leave) {
		this.decisionID = new DecisionID(user.getId(), leave.getId());
		this.dateOfDecision = dateOfDecision;
		this.decisionState = decisionState;
		this.user = user;
		this.leave = leave;
	}

	public Date getDateOfDecision() {
		return this.dateOfDecision;
	}

	public void setDateOfDecision(Date dateOfDecision) {
		this.dateOfDecision = dateOfDecision;
	}

	public DecisionState getDecisionState() {
		return decisionState;
	}

	public void setDecisionState(DecisionState decisionState) {
		this.decisionState = decisionState;
	}

	@EmbeddedId
	public DecisionID getDecisionID() {
		return decisionID;
	}

	public void setDecisionID(DecisionID decisionID) {
		this.decisionID = decisionID;
	}

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idLeave", referencedColumnName = "id", updatable = false, insertable = false)
	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

}
