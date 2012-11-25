package org.circle.target.web.views;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.business.exceptions.ProjectNameInUse;
import org.circle.target.business.factorys.ProfileFactory;
import org.circle.target.business.factorys.ProjectFactory;
import org.circle.target.business.services.AuthenticationService;
import org.circle.target.business.services.ProjectService;
import org.circle.target.dao.entities.ProfileProject;
import org.circle.target.dao.entities.TargetUser;
import org.circle.target.web.events.ExceptionMessageEvent;
import org.circle.target.web.qualifiers.ExceptionMessages;

@Named
@ConversationScoped
public class ProjectCreationView implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String CREATION_OK = "CREATION_OK";
	private static final String CREATION_FAILED = "CREATION_FAILED";
	private static final String CANCEL = "CANCEL_GO_HOME";

	private String descriptionProject;
	private String nameProject;
	private ProfileFactory profileFactory;
	private ProjectFactory projectFactory;

	@EJB private ProjectService projectService;
	@EJB private AuthenticationService authenticationService;
	@Inject	@ExceptionMessages private Event<ExceptionMessageEvent> eventExceptionMessage;

	
	public String createNewProject() {
		TargetUser targetUser = authenticationService.getUserLogged();

		profileFactory = new ProfileFactory();
		projectFactory = new ProjectFactory();

		ProfileProject profileProject = profileFactory.createProfileForProject(nameProject, descriptionProject);

		try {
			projectService.createNewProject(projectFactory.createNewProject(targetUser, profileProject));
			return CREATION_OK;

		} catch (ProjectNameInUse e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
			return CREATION_FAILED;
		}
	}

	public String cancel() {
		return CANCEL;
	}

	public String getDescriptionProject() {
		return descriptionProject;
	}

	public void setDescriptionProject(String descriptionProject) {
		this.descriptionProject = descriptionProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}
}
