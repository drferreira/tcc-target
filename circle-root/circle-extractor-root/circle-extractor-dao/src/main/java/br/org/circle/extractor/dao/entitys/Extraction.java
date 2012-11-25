package br.org.circle.extractor.dao.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="extraction")
public class Extraction implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_extraction")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idExtraction; 
	
	@ManyToOne
	@JoinColumn(name="id_document", nullable=false)
	private Document document;
	
	@Column(name="create_date", nullable=false)
	private Long createDate;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getIdExtraction() {
		return idExtraction;
	}

	public void setIdExtraction(Long idExtraction) {
		this.idExtraction = idExtraction;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	
	
	
}
