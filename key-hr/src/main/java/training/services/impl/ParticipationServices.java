package training.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
