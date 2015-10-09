package training.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import training.entities.Player;
import training.entities.Team;

@Remote
public interface ParticipationServicesRemote {
	Boolean signContract(Player player, Team team, Double duration);

	List<Team> findTeamsByPlayerId(Integer idPlayer);
}
