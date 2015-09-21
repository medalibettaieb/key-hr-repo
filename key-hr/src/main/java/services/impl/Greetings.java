package services.impl;

import javax.ejb.Stateless;

import services.interfaces.IGreetingsLocal;
import services.interfaces.IGreetingsRemote;

@Stateless
public class Greetings implements IGreetingsRemote, IGreetingsLocal {

	@Override
	public String tiSallem(String name) {
		return "ahla ya " + name;
	}

}
