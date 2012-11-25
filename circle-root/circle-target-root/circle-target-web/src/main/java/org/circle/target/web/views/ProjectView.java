package org.circle.target.web.views;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.circle.target.business.services.ProjectService;
import org.circle.target.dao.entities.Project;

@Named
@ViewScoped
public class ProjectView implements Serializable{

	private static final long serialVersionUID = 1L;
	@EJB
	private ProjectService projectService;
	
	public List<Project> getListMyProjects(){
		return projectService.getListMyProjects();
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
