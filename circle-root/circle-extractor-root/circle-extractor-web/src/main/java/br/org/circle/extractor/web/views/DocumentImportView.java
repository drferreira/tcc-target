package br.org.circle.extractor.web.views;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.org.circle.extractor.business.exceptions.ExtensionEmptyException;
import br.org.circle.extractor.business.exceptions.ExtensionNotMappedException;
import br.org.circle.extractor.business.exceptions.FileNameAlreadyExistsException;
import br.org.circle.extractor.business.exceptions.InvalidInputStreamException;
import br.org.circle.extractor.business.factorys.DocumentFactory;
import br.org.circle.extractor.business.services.DocumentService;
import br.org.circle.extractor.business.util.FakeUserUtil;
import br.org.circle.extractor.business.util.FileUtil;
import br.org.circle.extractor.web.events.DocumentUploadSuccessEvent;
import br.org.circle.extractor.web.events.ExceptionMessageEvent;
import br.org.circle.extractor.web.qualifiers.ExceptionMessages;
import br.org.circle.extractor.web.qualifiers.FinishingUpload;

@Named
@ViewScoped
public class DocumentImportView extends View {

	private static final long serialVersionUID = 1L;
	@Inject
	private DocumentFactory documentFactory;
	@Inject
	private DocumentService documentServiceBean;
	@Inject
	private FakeUserUtil fakeUserUtil;
	@Inject
	private FileUtil fileUtil;
	@Inject
	@FinishingUpload
	private Event<DocumentUploadSuccessEvent> eventUploadSuccess;
	@Inject
	@ExceptionMessages
	private Event<ExceptionMessageEvent> eventExceptionMessage;

	/**
	 * Responsible for performing the method steps after construction Managed
	 */
	@PostConstruct
	public void setUp() {
		documentFactory.setFileUtil(fileUtil);
	}

	/**
	 * Method responsible for to upload a file. Receives as parameter the event
	 * started in the screen and from it extracts the UploadFile that is used by
	 * Service responsible for creating the document. Receives as a parameter
	 * also injected the event that terminates the process, this process has a
	 * success message on the screen.
	 * 
	 * @param fileUploadEvent
	 * @throws ExtensionEmptyException
	 * @throws ExtensionNotMappedException
	 * @throws InvalidInputStreamException
	 * @throws FileNameAlreadyExistsException
	 */
	public void uploadFile(FileUploadEvent fileUploadEvent) {
		try {
			UploadedFile uploadedFile = fileUploadEvent.getFile();
			documentServiceBean.saveNewDocument(documentFactory.createDocument(uploadedFile, fakeUserUtil.getFakeUser()), uploadedFile);
			eventUploadSuccess.fire(new DocumentUploadSuccessEvent());

		} catch (FileNameAlreadyExistsException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));

		} catch (InvalidInputStreamException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));

		} catch (ExtensionNotMappedException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));

		} catch (ExtensionEmptyException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));
		}
	}
}
