package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.PlayerServicesRemote;
import entities.Player;

public class TestPlayerServices {
	static Context context;
	static PlayerServicesRemote proxy;

	public static void main(String[] args) throws NamingException {
		context = new InitialContext();
		proxy = (PlayerServicesRemote) context
				.lookup("/jamaiity/PlayerServices!services.interfaces.PlayerServicesRemote");

		//testAddPlayer();
		//testUpdatePlayer();
		//testDeletePlayer();
		//testFindPlayerById();
	}

	public static void testAddPlayer() {
		Player player = new Player();
		player.setId(1);
		player.setName("P1");
		proxy.addPlayer(player);
	}

	public static void testUpdatePlayer() {
		Player playerFound = proxy.findPlayerById(1);
		playerFound.setName("new");
		proxy.updatePlayer(playerFound);

	}

	public static void testDeletePlayer() {
		proxy.deletePlayerById(1);

	}

	public static void testFindPlayerById() {
		System.out.println(proxy.findPlayerById(1).getName());

	}

}
