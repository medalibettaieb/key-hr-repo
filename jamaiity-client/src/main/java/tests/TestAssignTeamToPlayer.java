package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.PlayerServicesRemote;
import entities.Player;

public class TestAssignTeamToPlayer {
	static Context context;
	static PlayerServicesRemote proxy;

	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (PlayerServicesRemote) context
				.lookup("/jamaiity/PlayerServices!services.interfaces.PlayerServicesRemote");

		Player player = new Player();
		player.setId(1);
		player.setName("foulen");

		System.out.println(proxy.assignTeamToPlayer(player, 1));

	}

}