package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.LeavesMnagementLocal;
import services.interfaces.LeavesMnagementRemote;
import entities.Decision;
import entities.DecisionState;
import entities.Employee;
import entities.Leave;
import entities.RhManager;
import entities.User;

/**
 * Session Bean implementation class LeavesMnagement
 */
@Stateless
public class LeavesMnagement implements LeavesMnagementRemote,
		LeavesMnagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public LeavesMnagement() {
	}

	@Override
	public Boolean requestLeaveUpdated(Leave leave, Integer employeeId) {
		Boolean b = false;

		try {
			Employee employeeFound = entityManager.find(Employee.class,
					employeeId);
			leave.setUser(employeeFound);
			entityManager.merge(leave);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean makeDecision(Leave leave, Integer rhManagerID,
			DecisionState state) {
		Boolean b = false;

		try {
			RhManager manager = (RhManager) entityManager.find(User.class,
					rhManagerID);
			Decision decision = new Decision(new Date(), state, manager, leave);
			entityManager.merge(decision);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Leave> findAllLeavesRequestedByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RhManager> findAllDecisionMakersByLeaveId(Integer leaveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RhManager> findAllRhManagerThatApproveLeave(Integer leaveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Leave findLeaveById(Integer leaveId) {
		return entityManager.find(Leave.class, leaveId);
	}

}
