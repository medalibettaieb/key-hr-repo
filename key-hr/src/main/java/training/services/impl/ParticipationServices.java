package training.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import training.entities.Participation;
import training.entities.Player;
import training.entities.Team;
import training.services.interfaces.ParticipationServicesRemote;

/**
 * Session Bean implementation class ParticipationServices
 */
@Stateless
public class ParticipationServices implements ParticipationServicesRemote {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ParticipationServices() {
	}

	@Override
	public Boolean signContract(Player player, Team team, Double duration) {
		Boolean b = false;
		try {
			Participation participation = new Participation(duration, player,
					team);
			entityManager.merge(participation);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Team> findTeamsByPlayerId(Integer idPlayer) {
		String jpql = "select t from Team t join t.participations ts where ts.player.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", idPlayer);
		return query.getResultList();
	}

}
