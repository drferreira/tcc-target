package br.org.circle.extractor.dao.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.org.circle.extractor.dao.enuns.StopwordStatus;

@Entity(name="extaction_stopword")
public class ExtractionAndStopword implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idExtractionAndStopword")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idExtractionAndStopword;

	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private StopwordStatus stopwordStatus;
	
	@OneToOne
	@JoinColumn(name="id_extraction", nullable=false)
	private Extraction extraction;
	
	@OneToOne
	@JoinColumn(name="id_stopword", nullable=false)
	private StopWord stopWord;
	
	public Long getIdExtractionAndStopword() {
		return idExtractionAndStopword;
	}

	public void setIdExtractionAndStopword(Long idExtractionAndStopword) {
		this.idExtractionAndStopword = idExtractionAndStopword;
	}
	
	public StopwordStatus getStopwordStatus() {
		return stopwordStatus;
	}

	public void setStopwordStatus(StopwordStatus stopwordStatus) {
		this.stopwordStatus = stopwordStatus;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Extraction getExtraction() {
		return extraction;
	}

	public void setExtraction(Extraction extraction) {
		this.extraction = extraction;
	}

	public StopWord getStopWord() {
		return stopWord;
	}

	public void setStopWord(StopWord stopWord) {
		this.stopWord = stopWord;
	}

	
}
