package org.circle.target.web.views;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.business.exceptions.ProjecDataNotFoundException;
import org.circle.target.business.services.AuthenticationService;
import org.circle.target.business.services.ProjectService;
import org.circle.target.dao.entities.PersonalData;
import org.circle.target.dao.entities.TargetUser;
import org.circle.target.web.events.ExceptionMessageEvent;
import org.circle.target.web.qualifiers.ExceptionMessages;

@Named
@ViewScoped
public class HeaderView implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String PROJECTS_GO = "PROJECTS_GO";
	private static final String PROJECTS_ERROR = "PROJECTS_ERROR";
	private static final String FRIENDS_GO = "FRIENDS_GO";
	private static final String PROFILE_GO = "PROFILE_GO";
	private static final String LOGOUT = "LOGOUT";
	private static final String HOME = "HOME";
	
	@EJB private AuthenticationService authenticationService;
	@EJB private ProjectService projectService;
	@Inject	@ExceptionMessages	private Event<ExceptionMessageEvent> eventExceptionMessage;
	
	public String projects(){
		try {
			projectService.serchMyProjects();
			
			return PROJECTS_GO;
		} catch (ProjecDataNotFoundException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
			
			return PROJECTS_ERROR;
		}
	}
	
	public String getNameUserLogged(){
		TargetUser userLogged = authenticationService.getUserLogged();
		PersonalData personalData = userLogged.getPersonalData();
		String firstName = personalData.getFirstName();
		
		return firstName;
	}
	
	public String friends(){
		return FRIENDS_GO;
	}
	
	public String profile(){
		return PROFILE_GO;
	}
	
	public String logout(){
		return LOGOUT;
	}
	
	public String home(){
		return HOME;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
