package br.org.circle.extractor.business.services.beans;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.primefaces.model.UploadedFile;

import br.org.circle.extractor.business.exceptions.FileNameAlreadyExistsException;
import br.org.circle.extractor.business.exceptions.InvalidInputStreamException;
import br.org.circle.extractor.business.services.DocumentService;
import br.org.circle.extractor.business.services.Service;
import br.org.circle.extractor.dao.daos.DocumentDao;
import br.org.circle.extractor.dao.daos.FileDao;
import br.org.circle.extractor.dao.entitys.Document;

/**
 * Service responsible for managing information related to documents of a User.
 * 
 * @author tectuba
 * 
 */
@Stateless
public class DocumentServiceBean extends Service implements DocumentService {

	private static final long serialVersionUID = 1L;
	@Inject
	private DocumentDao documentDao;
	@Inject
	private FileDao fileDao;

	/**
	 * Service responsible for saving a new document. Checks for other documents
	 * with the same name, if there are triggers the exception
	 * FileNameAlreadyExistsException. If the input stream is invalid
	 * InvalidInputStreamException throws the exception. It depends on the
	 * object DocumentDao. Receives as a parameter created by the Document
	 * Factory and FileUploadEvent, which will be responsible for provide the
	 * InputStream to write files.
	 * 
	 * @throws InvalidInputStreamException
	 * @throws FileNameAlreadyExistsException
	 */
	public void saveNewDocument(Document document, UploadedFile uploadedFile) throws FileNameAlreadyExistsException, InvalidInputStreamException {
		checkIsValidInputStream(uploadedFile);
		if (documentDao.exist(document.getNameFile())) {
			throw new FileNameAlreadyExistsException();
		} else {
			try {
				documentDao.saveDocumentInformations(document);
				fileDao.saveFile(document, uploadedFile);
			} catch (IOException e) {
				documentDao.remove(document);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method responsible for checking whether a given InputString is valid. If
	 * it is invalid by IO exception or null, will raise the exception
	 * InvalidInputStreamException
	 * 
	 * @param uploadedFile
	 * @throws InvalidInputStreamException
	 */
	public void checkIsValidInputStream(UploadedFile uploadedFile) throws InvalidInputStreamException {
		try {
			if (uploadedFile.getInputstream() == null) {
				throw new InvalidInputStreamException();
			}
		} catch (IOException e) {
			throw new InvalidInputStreamException();
		}

	}
}
