package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.DecisionState;
import entities.Leave;
import entities.RhManager;

@Remote
public interface LeavesMnagementRemote {
	Boolean requestLeaveUpdated(Leave leave, Integer employeeId);

	Boolean makeDecision(Leave leave, Integer rhManagerID, DecisionState state);

	List<Leave> findAllLeavesRequestedByEmployeeId(Integer employeeId);

	List<RhManager> findAllDecisionMakersByLeaveId(Integer leaveId);

	List<RhManager> findAllRhManagerThatApproveLeave(Integer leaveId);

	Leave findLeaveById(Integer leaveId);

}
