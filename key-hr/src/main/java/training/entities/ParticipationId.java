package training.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ParticipationId implements Serializable {
	private Integer idPlayer;
	private Integer idTeam;
	private Date dateOfTheSignature;

	public ParticipationId() {
	}

	

	public ParticipationId(Integer idPlayer, Integer idTeam,
			Date dateOfTheSignature) {
		super();
		this.idPlayer = idPlayer;
		this.idTeam = idTeam;
		this.dateOfTheSignature = dateOfTheSignature;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPlayer == null) ? 0 : idPlayer.hashCode());
		result = prime * result + ((idTeam == null) ? 0 : idTeam.hashCode());
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
		ParticipationId other = (ParticipationId) obj;
		if (idPlayer == null) {
			if (other.idPlayer != null)
				return false;
		} else if (!idPlayer.equals(other.idPlayer))
			return false;
		if (idTeam == null) {
			if (other.idTeam != null)
				return false;
		} else if (!idTeam.equals(other.idTeam))
			return false;
		return true;
	}

	public Integer getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
	}

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public Date getDateOfTheSignature() {
		return dateOfTheSignature;
	}

	public void setDateOfTheSignature(Date dateOfTheSignature) {
		this.dateOfTheSignature = dateOfTheSignature;
	}

}
