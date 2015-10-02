package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.DepartmentServicesRemote;

public class TestAssignEmployeeToDepartmentSlaveSide {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DepartmentServicesRemote departmentServicesRemote = (DepartmentServicesRemote) context
				.lookup("/key-hr/DepartmentServices!services.interfaces.DepartmentServicesRemote");

		System.out.println(departmentServicesRemote.assignEmployeeToDepartment(
				3, 1));
	}
}
