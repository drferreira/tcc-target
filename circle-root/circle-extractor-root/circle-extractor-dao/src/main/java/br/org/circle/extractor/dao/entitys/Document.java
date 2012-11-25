package br.org.circle.extractor.dao.entitys;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.org.circle.extractor.dao.enuns.DocumentFormat;

@Entity(name="document")
public class Document implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_document")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idDocument;
	
	@ManyToOne
	@JoinColumn(name="id_owner", nullable=false)
	private Owner owner;
	
	@ManyToOne
	@JoinColumn(name="id_project", nullable=false)
	private Project project;
	
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
	
	@OneToMany
	@JoinColumn(name="id_extraction")
	private Collection<Extraction> extraction;
	
	
	public Collection<Extraction> getExtraction() {
		return extraction;
	}

	public void setExtraction(Collection<Extraction> extraction) {
		this.extraction = extraction;
	}

	public DocumentFormat getDocumentFormat() {
		return documentFormat;
	}

	public void setDocumentFormat(DocumentFormat documentFormat) {
		this.documentFormat = documentFormat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
