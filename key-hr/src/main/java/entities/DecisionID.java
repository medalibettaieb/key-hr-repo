package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DecisionID implements Serializable {
	private Integer idUser;
	private Integer idLeave;

	public DecisionID() {
		// TODO Auto-generated constructor stub
	}

	public DecisionID(Integer idUser, Integer idLeave) {
		super();
		this.idUser = idUser;
		this.idLeave = idLeave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLeave == null) ? 0 : idLeave.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DecisionID other = (DecisionID) obj;
		if (idLeave == null) {
			if (other.idLeave != null)
				return false;
		} else if (!idLeave.equals(other.idLeave))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdLeave() {
		return idLeave;
	}

	public void setIdLeave(Integer idLeave) {
		this.idLeave = idLeave;
	}

}
