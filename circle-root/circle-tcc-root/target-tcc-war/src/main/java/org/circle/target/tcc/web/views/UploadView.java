package org.circle.target.tcc.web.views;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.tcc.business.exceptions.EmptyInputStreamException;
import org.circle.target.tcc.business.exceptions.FileOversizedException;
import org.circle.target.tcc.business.services.DocumentValidationService;
import org.circle.target.tcc.kernel.Document;
import org.circle.target.tcc.text.exceptions.ExtensionEmptyException;
import org.circle.target.tcc.text.exceptions.ExtensionNotMappedException;
import org.circle.target.tcc.web.views.utils.FacesContextUtil;
import org.primefaces.model.UploadedFile;

@Named
@ConversationScoped
public class UploadView implements Serializable {

	private static final long serialVersionUID = -38249302258926739L;
	private static final String NAV_GO_FIRST_PAGE_EXTRACTION = "NAV_GO_FIRST_PAGE_EXTRACTION";
	private static final String NAV_ERROR_STREAM = "NAV_ERROR_STREAM";
	private static final String SUMARY_EMPTY_STREAM = "Document Empty";
	private static final String DETAIL_EMPTY_STREAM = "Please select document not empty";
	private static final String SUMARY_FILE_OVERSIZE = "Document Oversize";
	private static final String DETAIL_FILE_OVERSIZE = "Your document is higher than the allowed size";
	private static final String SUMARY_EXT_NOT_MAPPED = "Extension does not accept";
	private static final String DETAIL_EXT_NOT_MAPPED = "The extent of the selected file is not allowed";
	private static final String SUMARY_EXT_EMPTY = "Extension empty";
	private static final String DETAIL_EXT_EMPTY = "Your document needs an extension";
	private static final String SUMARY_ERROR_IO = "Error of read";
	private static final String DETAIL_ERROR_IO = "Occurred an error durante the read of file";
	private static final String ID_COMPONENT_MESSAGE = "messages";

	private UploadedFile uploadedFile;
	private Document document;

	@EJB
	DocumentValidationService documentValidationService;
	@Inject
	Conversation conversation;

	@PostConstruct
	public void init() {
		conversation.begin();
	}

	public String generateExtraction() {
		try {
			document = new Document(uploadedFile);
			documentValidationService.checkDocument(document);

			return NAV_GO_FIRST_PAGE_EXTRACTION;

		} catch (EmptyInputStreamException e) {
			FacesContextUtil.sendMessageToContext(FacesMessage.SEVERITY_WARN,
					SUMARY_EMPTY_STREAM, DETAIL_EMPTY_STREAM,
					ID_COMPONENT_MESSAGE);
			return NAV_ERROR_STREAM;

		} catch (FileOversizedException e) {
			FacesContextUtil.sendMessageToContext(FacesMessage.SEVERITY_WARN,
					SUMARY_FILE_OVERSIZE, DETAIL_FILE_OVERSIZE,
					ID_COMPONENT_MESSAGE);
			return NAV_ERROR_STREAM;

		} catch (ExtensionNotMappedException e) {
			FacesContextUtil.sendMessageToContext(FacesMessage.SEVERITY_WARN,
					SUMARY_EXT_NOT_MAPPED, DETAIL_EXT_NOT_MAPPED,
					ID_COMPONENT_MESSAGE);
			return NAV_ERROR_STREAM;

		} catch (ExtensionEmptyException e) {
			FacesContextUtil.sendMessageToContext(FacesMessage.SEVERITY_WARN,
					SUMARY_EXT_EMPTY, DETAIL_EXT_EMPTY, ID_COMPONENT_MESSAGE);
			return NAV_ERROR_STREAM;

		} catch (IOException e) {
			FacesContextUtil.sendMessageToContext(FacesMessage.SEVERITY_ERROR,
					SUMARY_ERROR_IO, DETAIL_ERROR_IO, ID_COMPONENT_MESSAGE);
			return NAV_ERROR_STREAM;
		}
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
