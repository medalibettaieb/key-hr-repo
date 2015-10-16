package delegate;

import locator.ServiceLocator;
import services.interfaces.LeavesMnagementRemote;
import entities.Leave;

public class LeavesManagementDelegate {
	public static final String jndiName = "/key-hr/LeavesMnagement!services.interfaces.LeavesMnagementRemote";

	public static LeavesMnagementRemote getProxy() {
		return (LeavesMnagementRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void doRequestLeave(Leave leave, Integer employeeId) {
		getProxy().requestLeaveUpdated(leave, employeeId);
	}
}
