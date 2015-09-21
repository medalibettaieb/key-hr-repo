package edu.app.client.simple;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.CalculatorServiceRemote;

public class App {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		String jndiName = "/key-hr/CalculatorService!services.interfaces.CalculatorServiceRemote";
		CalculatorServiceRemote proxy = (CalculatorServiceRemote) context
				.lookup(jndiName);
		int z = proxy.sum(10, 14);
		System.out.println(z);
	}

}
