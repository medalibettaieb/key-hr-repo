package tests.training;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.services.interfaces.IdentificationServicesRemote;
import entities.Employee;
import entities.User;

public class TestLogin {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		IdentificationServicesRemote proxy = (IdentificationServicesRemote) context
				.lookup("/key-hr/IdentificationServices!training.services.interfaces.IdentificationServicesRemote");

		User user = proxy.login("", "");
		if (user instanceof Employee) {
			System.out.println("emchi ya " + user.getName()
					+ " rak mak ella employee");
		} else {
			System.out.println("mar7be mar7be sidi " + user.getName());
		}
	}
}
