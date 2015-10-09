package training.services.interfaces;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface IdentificationServicesRemote {
	User login(String login, String password);

	void addUser(User user);
}
