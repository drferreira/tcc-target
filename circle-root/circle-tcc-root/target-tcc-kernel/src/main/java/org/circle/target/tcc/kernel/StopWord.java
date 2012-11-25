package org.circle.target.tcc.kernel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StopWord implements Serializable {

	private static final long serialVersionUID = 7771568754526235469L;

	@Id
	@Column(name="id_stopWord")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idStopWord;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Word stopWord;
	
	@OneToOne
	private TypeStopWord typeStopWord;
	
	public StopWord() {
	}
	
	public StopWord(Word stopWord) {
		this.stopWord = stopWord;
	}

	public Long getIdStopWord() {
		return idStopWord;
	}

	public void setIdStopWord(Long idStopWord) {
		this.idStopWord = idStopWord;
	}

	public Word getStopWord() {
		return stopWord;
	}

	public void setStopWord(Word stopWord) {
		this.stopWord = stopWord;
	}

	public TypeStopWord getTypeStopWord() {
		return typeStopWord;
	}

	public void setTypeStopWord(TypeStopWord typeStopWord) {
		this.typeStopWord = typeStopWord;
	}
}
