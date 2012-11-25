package org.circle.target.tcc.kernel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeStopWord implements Serializable {

	private static final long serialVersionUID = -3673277978348859872L;

	@Id
	@Column(name="id_typeStopWord")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idTypeStopWord;
	
	@Column(name = "type_name", nullable = false)
	private String typeName;

	public Long getIdTypeStopWord() {
		return idTypeStopWord;
	}

	public void setIdTypeStopWord(Long idTypeStopWord) {
		this.idTypeStopWord = idTypeStopWord;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
