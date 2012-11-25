package org.circle.target.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonalData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_personalData")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idpersonalData;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_birthday")
	private Long dateOfBirthday;
	
	@OneToOne
	private TargetUser targetUser;

	public Long getIdpersonalData() {
		return idpersonalData;
	}

	public void setIdpersonalData(Long idpersonalData) {
		this.idpersonalData = idpersonalData;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(Long dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public TargetUser getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(TargetUser targetUser) {
		this.targetUser = targetUser;
	}
}
