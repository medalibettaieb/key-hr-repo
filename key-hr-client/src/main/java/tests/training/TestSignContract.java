package tests.training;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.entities.Player;
import training.entities.Team;
import training.services.interfaces.ParticipationServicesRemote;

public class TestSignContract {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ParticipationServicesRemote proxy = (ParticipationServicesRemote) context
				.lookup("/key-hr/ParticipationServices!training.services.interfaces.ParticipationServicesRemote");

		Player player = new Player();
		player.setId(1);
		player.setName("houssem");

		Team team = new Team();
		team.setId(1);
		team.setColor("hamra ka7la");

		System.out.println(proxy.signContract(player, team, 2D));

	}

}
