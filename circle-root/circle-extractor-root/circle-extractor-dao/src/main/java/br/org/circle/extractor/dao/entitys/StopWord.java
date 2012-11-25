package br.org.circle.extractor.dao.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.org.circle.extractor.dao.enuns.StopwordType;

@Entity(name="stopword")
public class StopWord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_stopword")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idStopword;
	
	@Column(name="value", nullable=false)
	private String value;
	
	@Column(name="simplification", nullable=false)
	private String simplification;
	
	@Column(name="root", nullable=false)
	private String root;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type", nullable=false)
	private StopwordType stopwordType;

	public Long getIdStopword() {
		return idStopword;
	}

	public void setIdStopword(Long idStopword) {
		this.idStopword = idStopword;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSimplification() {
		return simplification;
	}

	public void setSimplification(String simplification) {
		this.simplification = simplification;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public StopwordType getStopwordType() {
		return stopwordType;
	}

	public void setStopwordType(StopwordType stopwordType) {
		this.stopwordType = stopwordType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
	
}
