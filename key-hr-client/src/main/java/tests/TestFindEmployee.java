package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.EmployeeServicesRemote;
import entities.Employee;

public class TestFindEmployee {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/key-hr/EmployeeServices!services.interfaces.EmployeeServicesRemote";
		EmployeeServicesRemote proxy = (EmployeeServicesRemote) context
				.lookup(jndiName);

		Employee employee = proxy.findEmployeeById(3);
		System.out.println(employee);
	}

}
