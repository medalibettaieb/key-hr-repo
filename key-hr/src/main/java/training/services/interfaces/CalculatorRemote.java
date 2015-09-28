package training.services.interfaces;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {
	int sum(int x, int y);
}
