package training.services.impl;

import javax.ejb.Stateless;

import training.services.interfaces.CalculatorServiceRemote;

@Stateless
public class CalculatorService implements CalculatorServiceRemote {

	public CalculatorService() {
	}

	public int sum(int x, int y) {
		return x + y;
	}

}
