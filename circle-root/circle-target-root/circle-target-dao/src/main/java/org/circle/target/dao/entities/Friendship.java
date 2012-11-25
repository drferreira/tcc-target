package org.circle.target.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Friendship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_friendship")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idFriendship;
	
	@OneToOne
	private TargetUser owner;
	
	@OneToOne
	private TargetUser friend;
	
	@Column(name = "date_friendship")
	private Long dateFriendship;

	public Long getIdFriendship() {
		return idFriendship;
	}

	public void setIdFriendship(Long idFriendship) {
		this.idFriendship = idFriendship;
	}

	public TargetUser getOwner() {
		return owner;
	}

	public void setOwner(TargetUser owner) {
		this.owner = owner;
	}

	public TargetUser getFriend() {
		return friend;
	}

	public void setFriend(TargetUser friend) {
		this.friend = friend;
	}

	public Long getDateFriendship() {
		return dateFriendship;
	}

	public void setDateFriendship(Long dateFriendship) {
		this.dateFriendship = dateFriendship;
	}
}
