package training.services.impl;

import javax.ejb.Stateless;

import training.services.interfaces.CalculatorRemote;

/**
 * Session Bean implementation class Calculator
 */
@Stateless
public class Calculator implements CalculatorRemote {

	/**
	 * Default constructor.
	 */
	public Calculator() {
	}

	@Override
	public int sum(int x, int y) {
		return x + y;
	}

}
