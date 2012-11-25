package org.circle.target.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_project")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idProject;
	
	@OneToOne
	private TargetUser ownerProject;
	
	@ManyToMany
	private List<TargetUser> targetUsers;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Document> documents;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private ProfileProject profileProject; 
	
	public Long getIdProject() {
		return idProject;
	}

	public void setIdProject(Long idProject) {
		this.idProject = idProject;
	}

	public List<TargetUser> getTargetUsers() {
		return targetUsers;
	}

	public void setTargetUsers(List<TargetUser> targetUsers) {
		this.targetUsers = targetUsers;
	}

	public ProfileProject getProfileProject() {
		return profileProject;
	}

	public void setProfileProject(ProfileProject profileProject) {
		this.profileProject = profileProject;
	}

	public TargetUser getOwnerProject() {
		return ownerProject;
	}

	public void setOwnerProject(TargetUser ownerProject) {
		this.ownerProject = ownerProject;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
}
