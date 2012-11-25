package org.circle.target.web.views;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.business.exceptions.ProjecDataNotFoundException;
import org.circle.target.business.services.ProjectService;
import org.circle.target.business.services.SearchCompoundsService;
import org.circle.target.business.services.SearchErroGeneric;
import org.circle.target.web.events.ExceptionMessageEvent;
import org.circle.target.web.qualifiers.ExceptionMessages;

@Named
@ViewScoped
public class HomeView implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB private SearchCompoundsService compoundsService;
	@Inject	@ExceptionMessages private Event<ExceptionMessageEvent> eventExceptionMessage;
	@EJB private ProjectService projectService;
	private final static String SEARCH_PERFOMED = "SEARCH_PERFOMED";
	private final static String SEARCH_ERROR = "SEARCH_ERRO";
	private final static String GO_UPLOAD_FILE_PAGE = "GO_UPLOAD_FILE";
	private final static String ERROR_UPLOAD_FILE = "ERROR_UPLOAD_FILE";
	private final static String GO_NEW_PROJECT_PAGE = "GO_NEW_PROJECT_PAGE";
	
	
	/**
	 * <b>NÂO IMPLEMENTADO</b>
	 * 
	 * @param value
	 * @return
	 */
	public String setSearch(String value) {
		try {
			compoundsService.searchComposed(value);
			
			return SEARCH_PERFOMED;
		} catch (SearchErroGeneric e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
			
			return SEARCH_ERROR;
		}
	}
	
	public String extractorMoreInformation() {
		return "NOT_IMPLEMENT";
	}
	
	public String projectMoreInformation(){
		return "NOT_IMPLEMENT";
	}

	public String listAllDocs() {
		return "NOT_IMPLEMENT";
	}

	public String generateExtraction() {
		return "NOT_IMPLEMENT";
	}
	
	public String createNewProject(){
		return GO_NEW_PROJECT_PAGE;
	}
	
	public String uploadFile(){
		try {
			projectService.serchMyProjects();
			return GO_UPLOAD_FILE_PAGE;
			
		} catch (ProjecDataNotFoundException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
			return ERROR_UPLOAD_FILE;
		}
	}
}
