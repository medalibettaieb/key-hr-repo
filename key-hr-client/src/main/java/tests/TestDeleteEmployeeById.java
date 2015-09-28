package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.EmployeeServicesRemote;

public class TestDeleteEmployeeById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/key-hr/EmployeeServices!services.interfaces.EmployeeServicesRemote";
		EmployeeServicesRemote proxy = (EmployeeServicesRemote) context
				.lookup(jndiName);

		System.out.println(proxy.deleteEmployeeById(2));
	}

}
