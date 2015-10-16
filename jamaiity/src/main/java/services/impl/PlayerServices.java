package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.PlayerServicesLocal;
import services.interfaces.PlayerServicesRemote;
import entities.Player;
import entities.Team;

/**
 * Session Bean implementation class PlayerServices
 */
@Stateless
public class PlayerServices implements PlayerServicesRemote,
		PlayerServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PlayerServices() {
	}

	@Override
	public Boolean addPlayer(Player player) {
		Boolean b = false;
		try {
			entityManager.persist(player);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deletePlayerById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findPlayerById(id));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updatePlayer(Player player) {
		Boolean b = false;
		try {
			entityManager.merge(player);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Player findPlayerById(Integer id) {
		return entityManager.find(Player.class, id);
	}

	@Override
	public Boolean deletePlayer(Player player) {
		Boolean b = false;
		try {
			player = findPlayerById(player.getId());
			entityManager.remove(player);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean assignTeamToPlayer(Player newPlayer, Integer teamId) {
		Boolean b = false;
		try {
			Team team = entityManager.find(Team.class, teamId);
			newPlayer.setTeam(team);
			entityManager.merge(newPlayer);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public void initDb() {
		Team team = new Team();
		team.setId(1);
		team.setName("mentalité");

		entityManager.merge(team);

	}

	@Override
	public Boolean assignPlayerToTeam(Player newPlayer, Integer teamId) {
		Boolean b = false;
		try {
			Team team = entityManager.find(Team.class, teamId);
			List<Player> players = findAllPlayersByTeamId(teamId);
			players.add(newPlayer);
			team.linkPlayersToThisTeam(players);
			entityManager.merge(team);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> findAllPlayersByTeamId(Integer teamId) {
		String jpql = "select p from Player p where p.team.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", teamId);
		return query.getResultList();
	}
}
