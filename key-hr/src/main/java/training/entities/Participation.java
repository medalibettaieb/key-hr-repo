package training.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Participation
 *
 */
@Entity
public class Participation implements Serializable {

	private ParticipationId participationId;
	private Double duration;
	private static final long serialVersionUID = 1L;

	private Player player;
	private Team team;

	public Participation() {
		super();
	}

	public Participation(Double duration, Player player, Team team) {
		this.participationId = new ParticipationId(player.getId(),
				team.getId(), new Date());
		this.duration = duration;
		this.player = player;
		this.team = team;
	}

	public Double getDuration() {
		return this.duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@EmbeddedId
	public ParticipationId getParticipationId() {
		return participationId;
	}

	public void setParticipationId(ParticipationId participationId) {
		this.participationId = participationId;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idPlayer", referencedColumnName = "id", insertable = false, updatable = false)
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idTeam", referencedColumnName = "id", insertable = false, updatable = false)
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
