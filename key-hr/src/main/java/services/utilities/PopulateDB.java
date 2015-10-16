package services.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Employee;

/**
 * Session Bean implementation class PopulateDB
 */
@Singleton
@LocalBean
@Startup
public class PopulateDB {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PopulateDB() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		Employee employee = new Employee();
		employee.setExperience(5D);
		employee.setName("foulen");
		employee.setLogin("f");
		employee.setPassword("f");

		entityManager.merge(employee);

	}

}
