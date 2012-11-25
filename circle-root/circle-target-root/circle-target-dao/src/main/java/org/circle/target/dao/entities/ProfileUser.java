package org.circle.target.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfileUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_profile_user")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idProfileUser;

	public Long getIdProfileUser() {
		return idProfileUser;
	}

	public void setIdProfileUser(Long idProfileUser) {
		this.idProfileUser = idProfileUser;
	}

}
