package tests.leavesManagement;

import java.util.Date;

import delegate.LeavesManagementDelegate;
import entities.Leave;

public class TestRaquestLeavePatternsUse {

	public static void main(String[] args) {
		Leave leave = new Leave("sickness", new Date(), 5D);

		LeavesManagementDelegate.doRequestLeave(leave, 1);

	}
}
