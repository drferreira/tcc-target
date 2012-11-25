package org.circle.target.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProfileProject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_profile_project")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idProfileProject;

	@Column(name="name_project", nullable=false)
	private String nameProject;
	
	@Column(name="description_project", nullable=false)
	private String description;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public Long getIdProfileProject() {
		return idProfileProject;
	}

	public void setIdProfileProject(Long idProfileProject) {
		this.idProfileProject = idProfileProject;
	}
}
