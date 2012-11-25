package br.org.circle.extractor.dao.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="owner")
public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_owner")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idOwner;
	
	@Column(name="key_user", nullable=false)
	private String keyUser;
	
	public String getKeyUser() {
		return keyUser;
	}

	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
	}
		
}
