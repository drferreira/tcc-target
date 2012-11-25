package br.org.circle.extractor.dao.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="circle_user")
public class CircleUser implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idUser;
	
	@Column(name="key_user")
	private String keyUser;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getKeyUser() {
		return keyUser;
	}

	public void setKeyUser(String keyUser) {
		this.keyUser = keyUser;
	}
}
