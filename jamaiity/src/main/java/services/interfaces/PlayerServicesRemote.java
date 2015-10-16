package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Player;

@Remote
public interface PlayerServicesRemote {
	Boolean addPlayer(Player player);

	Boolean deletePlayerById(Integer id);

	Boolean updatePlayer(Player player);

	Player findPlayerById(Integer id);

	Boolean deletePlayer(Player player);

	Boolean assignTeamToPlayer(Player newPlayer, Integer teamId);

	void initDb();

	Boolean assignPlayerToTeam(Player newPlayer, Integer teamId);

	List<Player> findAllPlayersByTeamId(Integer teamId);
}
