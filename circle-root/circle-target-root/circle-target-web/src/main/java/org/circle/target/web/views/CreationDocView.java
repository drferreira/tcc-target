package org.circle.target.web.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.business.exceptions.ExtensionEmptyException;
import org.circle.target.business.exceptions.ExtensionNotMappedException;
import org.circle.target.business.exceptions.FileNameAlreadyExistsException;
import org.circle.target.business.exceptions.InvalidInputStreamException;
import org.circle.target.business.factorys.DocumentFactory;
import org.circle.target.business.services.DocumentService;
import org.circle.target.business.services.ProjectService;
import org.circle.target.business.util.DateUtil;
import org.circle.target.business.util.FileUtil;
import org.circle.target.dao.entities.Document;
import org.circle.target.dao.entities.Project;
import org.circle.target.web.events.ExceptionMessageEvent;
import org.circle.target.web.qualifiers.ExceptionMessages;
import org.primefaces.model.UploadedFile;

@Named
@ConversationScoped
public class CreationDocView implements Serializable {

	private static final long serialVersionUID = -29563825223921589L;
	private static final String SAVE_DOC_OK = "SAVE_DOC_OK";
	private static final String SAVE_OK_GO_EXTRACTION = "SAVE_OK_GO_EXTRACTION";
	private static final String SAVE_DOC_FAIL = "SAVE_DOC_FAIL";

	private Project projectSelect;
	private UploadedFile uploadedFile;
	private Document document;
	private List<Project> myProjects;

	@Inject
	@ExceptionMessages
	private Event<ExceptionMessageEvent> eventExceptionMessage;
	@EJB
	private ProjectService projectService;
	@EJB
	private DocumentService documentService;
	
	@PostConstruct
	public void posConstructor(){
		myProjects = getListMyProjects();
	}

	/**
	 * Method responsible for fetching the list of projects of my property to
	 * build the dropdown to select and link to the document.
	 * 
	 * @return
	 */
	public List<Project> getListMyProjects() {
		return projectService.getListMyProjects();
	}

	public String saveNewDoc() {
		try {
			documentService.saveNewDocument(projectSelect, document, uploadedFile);

			return SAVE_DOC_OK;
		} catch (FileNameAlreadyExistsException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
			return SAVE_DOC_FAIL;

		} catch (InvalidInputStreamException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
			return SAVE_DOC_FAIL;
		}
	}

	/**
	 * Method responsible for building an object of type Document. Need
	 * UploadFile that the <b>object is not null</b>.
	 */
	public void buildNewDoc() {
		try {
			DocumentFactory documentFactory = new DocumentFactory(new FileUtil());
			document = documentFactory.createDocument(uploadedFile);

		} catch (ExtensionNotMappedException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));

		} catch (ExtensionEmptyException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
		}
	}

	public String saveDocAndGeneration() {
		return SAVE_OK_GO_EXTRACTION;
	}

	public String getSizeFile() {
		Long sizeFile = document.getSizeFile();
		return sizeFile.toString();
	}

	public String getImportDate() {
		Long dateLong = document.getImportDate();
		return DateUtil.getStringDate(dateLong);
	}
	
	public boolean isRenderedSizeFile(){
		return isNotNullDocument();
	}
	
	public boolean isRenderedImportDate(){
		return isNotNullDocument();
	}
	
	public boolean isRenderedEditionName(){
		return isNotNullDocument();
	}
	
	
	public boolean isNotNullDocument(){
		if (document != null) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Method responsible for canceling the upload operation of the document.
	 */
	public void cancel() {
	}
	
	public List<Project> getMyProjects() {
		return myProjects;
	}

	public void setMyProjects(List<Project> projects) {
		this.myProjects = projects;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public Project getProjectSelect() {
		return projectSelect;
	}

	public void setProjectSelect(Project projectSelect) {
		this.projectSelect = projectSelect;
	}
}
