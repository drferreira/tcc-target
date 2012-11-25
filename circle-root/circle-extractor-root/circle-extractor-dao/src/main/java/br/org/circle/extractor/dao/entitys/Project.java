package br.org.circle.extractor.dao.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="project")
public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_project")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idProject;
	
	@Column(name="key_project", nullable=false)
	private String keyProject;
	
}
