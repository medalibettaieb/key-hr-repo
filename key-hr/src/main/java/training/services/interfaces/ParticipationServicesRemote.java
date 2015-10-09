package training.services.interfaces;

import javax.ejb.Remote;

import training.entities.Player;
import training.entities.Team;

@Remote
public interface ParticipationServicesRemote {
	Boolean signContract(Player player, Team team, Double duration);
}
