package tests.leavesManagement;

import java.util.Date;

import locator.ServiceLocator;
import services.interfaces.LeavesMnagementRemote;
import entities.Leave;

public class CopyOfTestServiceOneOld {

	public static void main(String[] args) {
		String jndiName = "/key-hr/LeavesMnagement!services.interfaces.LeavesMnagementRemote";
		LeavesMnagementRemote proxy = (LeavesMnagementRemote) ServiceLocator
				.getInstance().getProxy(jndiName);
		Leave leave = new Leave("sickness", new Date(), 5D);

		proxy.requestLeave(leave, 1);
	}

}
