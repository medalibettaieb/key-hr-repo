package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.EmployeeServicesRemote;
import entities.Employee;

public class TestFindAllEmployees {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/key-hr/EmployeeServices!services.interfaces.EmployeeServicesRemote";
		EmployeeServicesRemote proxy = (EmployeeServicesRemote) context
				.lookup(jndiName);

		List<Employee> employees = proxy.findAllEmployees();

		System.out.println(employees.size());
		for (Employee e : employees) {
			System.out.println(e.getName());
		}
	}

}
