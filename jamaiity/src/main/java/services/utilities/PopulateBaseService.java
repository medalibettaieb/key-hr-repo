package services.utilities;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PopulateBaseService
 */
@Stateless
public class PopulateBaseService implements PopulateBaseServiceRemote,
		PopulateBaseServiceLocal {

	@EJB
	private PopulateDb populateDb;

	/**
	 * Default constructor.
	 */
	public PopulateBaseService() {
		// TODO Auto-generated constructor stub
	}

}
