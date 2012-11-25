package org.circle.target.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.circle.target.dao.enuns.DocumentFormat;


@Entity
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_document")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idDocument;
	
	@Column(name="name_file", nullable=false)
	private String nameFile;
	
	@Column(name="address_file", nullable=false)
	private String addressFile;
	
	@Column(name="size_file", nullable=false)
	private Long sizeFile;
	
	@Column(name="import_date", nullable=false)
	private Long importDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type_format", nullable=false)
	private DocumentFormat documentFormat;
	
	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public String getAddressFile() {
		return addressFile;
	}

	public void setAddressFile(String addressFile) {
		this.addressFile = addressFile;
	}

	public Long getSizeFile() {
		return sizeFile;
	}

	public void setSizeFile(Long sizeFile) {
		this.sizeFile = sizeFile;
	}

	public Long getImportDate() {
		return importDate;
	}

	public void setImportDate(Long importDate) {
		this.importDate = importDate;
	}

	public DocumentFormat getDocumentFormat() {
		return documentFormat;
	}

	public void setDocumentFormat(DocumentFormat documentFormat) {
		this.documentFormat = documentFormat;
	}
}
