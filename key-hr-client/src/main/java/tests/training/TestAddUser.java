package tests.training;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.services.interfaces.IdentificationServicesRemote;
import entities.Employee;
import entities.RhManager;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		IdentificationServicesRemote proxy = (IdentificationServicesRemote) context
				.lookup("/key-hr/IdentificationServices!training.services.interfaces.IdentificationServicesRemote");

		Employee employee = new Employee();
		employee.setId(1);
		employee.setLogin("e");
		employee.setPassword("e");

		RhManager manager = new RhManager();
		manager.setId(2);
		manager.setLogin("m");
		manager.setPassword("m");

		proxy.addUser(manager);
		proxy.addUser(employee);
	}
}
