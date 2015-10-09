package entities;

import entities.User;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RhManager
 *
 */
@Entity

public class RhManager extends User implements Serializable {

	
	private String position;
	private static final long serialVersionUID = 1L;

	public RhManager() {
		super();
	}   
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
   
}
