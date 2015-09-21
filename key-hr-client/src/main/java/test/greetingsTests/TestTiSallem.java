package test.greetingsTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.IGreetingsRemote;

public class TestTiSallem {
	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			String jndiName = "/key-hr/Greetings!services.interfaces.IGreetingsRemote";
			IGreetingsRemote proxy = (IGreetingsRemote) context
					.lookup(jndiName);

			System.out.println(proxy.tiSallem("hany"));

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
