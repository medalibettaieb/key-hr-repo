package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Player;
import services.interfaces.PlayerServicesRemote;

public class TestDeletePlayer {
	static Context context;
	static PlayerServicesRemote proxy;

	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (PlayerServicesRemote) context
				.lookup("/jamaiity/PlayerServices!services.interfaces.PlayerServicesRemote");

		Player player=proxy.findPlayerById(1);
		System.out.println(proxy.deletePlayer(player));

	}

}