package edu.app.client.simple;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.services.interfaces.CalculatorRemote;

public class A {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CalculatorRemote proxy = (CalculatorRemote) context
				.lookup("/key-hr/Calculator!services.interfaces.CalculatorRemote");

		System.out.println(proxy.sum(1, 2));
	}

}
