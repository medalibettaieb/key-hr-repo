package tests.training;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.entities.Team;
import training.services.interfaces.ParticipationServicesRemote;

public class TestFindTeamsByPlayerId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ParticipationServicesRemote proxy = (ParticipationServicesRemote) context
				.lookup("/key-hr/ParticipationServices!training.services.interfaces.ParticipationServicesRemote");

		List<Team> teams = proxy.findTeamsByPlayerId(1);

		for (Team t : teams) {
			System.out.println(t.getColor());
		}

	}

}
