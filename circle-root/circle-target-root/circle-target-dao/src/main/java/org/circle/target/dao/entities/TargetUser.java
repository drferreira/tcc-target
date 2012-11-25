package org.circle.target.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TargetUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idUser;
	
	@OneToMany
	private List<Friendship> friends;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Document> documents;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SecurityData securityData;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProfileUser profileUser;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PersonalData personalData;
	
	public Long getIdUser() {
		return idUser;
	}
	
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public List<Friendship> getFriends() {
		return friends;
	}

	public void setFriends(List<Friendship> friends) {
		this.friends = friends;
	}

	public SecurityData getSecurityData() {
		return securityData;
	}

	public void setSecurityData(SecurityData securityData) {
		this.securityData = securityData;
	}

	public ProfileUser getProfileUser() {
		return profileUser;
	}

	public void setProfileUser(ProfileUser profileUser) {
		this.profileUser = profileUser;
	}

	public PersonalData getPersonalData() {
		return personalData;
	}

	public void setPersonalData(PersonalData personalData) {
		this.personalData = personalData;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
}
