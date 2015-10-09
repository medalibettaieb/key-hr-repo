package training.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import training.services.interfaces.IdentificationServicesRemote;
import entities.User;

/**
 * Session Bean implementation class IdentificationServices
 */
@Stateless
public class IdentificationServices implements IdentificationServicesRemote {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public IdentificationServices() {
	}

	@Override
	public User login(String login, String password) {
		String jpql = "select u from User u where u.login=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		User userLoggedIn = null;
		userLoggedIn = (User) query.getSingleResult();
		return userLoggedIn;
	}

	@Override
	public void addUser(User user) {
		entityManager.merge(user);

	}

}
