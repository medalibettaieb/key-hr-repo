package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.DepartmentServicesRemote;
import entities.Department;

public class TestAssignEmployeeToNewDepartment {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		DepartmentServicesRemote departmentServicesRemote = (DepartmentServicesRemote) context
				.lookup("/key-hr/DepartmentServices!services.interfaces.DepartmentServicesRemote");

		Department department = new Department();
		department.setId(2);
		department.setName("chimi");

		System.out.println(departmentServicesRemote
				.assignEmployeeToNewDepartment(3, department));
	}
}
