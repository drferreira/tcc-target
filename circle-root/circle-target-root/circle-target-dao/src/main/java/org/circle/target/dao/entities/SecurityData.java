package org.circle.target.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SecurityData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_securitydata")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idSecurityData;
	
	@OneToOne
	private TargetUser targetUser;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "dateCreated", nullable = false)
	private Long dateCreated;

	public Long getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Long dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getIdSecurityData() {
		return idSecurityData;
	}

	public void setIdSecurityData(Long idSecurityData) {
		this.idSecurityData = idSecurityData;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TargetUser getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(TargetUser targetUser) {
		this.targetUser = targetUser;
	}
}
