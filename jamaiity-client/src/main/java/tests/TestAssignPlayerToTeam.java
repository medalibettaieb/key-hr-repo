package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.PlayerServicesRemote;
import entities.Player;

public class TestAssignPlayerToTeam {
	static Context context;
	static PlayerServicesRemote proxy;

	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (PlayerServicesRemote) context
				.lookup("/jamaiity/PlayerServices!services.interfaces.PlayerServicesRemote");

		Player newPlayer = new Player();
		newPlayer.setId(1);
		newPlayer.setName("foulen");

		System.out.println(proxy.assignPlayerToTeam(newPlayer, 1));

	}

}