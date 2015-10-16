package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.PlayerServicesRemote;

public class TestInitDb {
	static Context context;
	static PlayerServicesRemote proxy;

	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (PlayerServicesRemote) context
				.lookup("/jamaiity/PlayerServices!services.interfaces.PlayerServicesRemote");
		proxy.initDb();

	}

}