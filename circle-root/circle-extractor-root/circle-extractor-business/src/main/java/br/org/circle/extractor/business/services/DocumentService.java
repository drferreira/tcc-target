package br.org.circle.extractor.business.services;

import javax.ejb.Local;

import org.primefaces.model.UploadedFile;

import br.org.circle.extractor.business.exceptions.FileNameAlreadyExistsException;
import br.org.circle.extractor.business.exceptions.InvalidInputStreamException;
import br.org.circle.extractor.dao.entitys.Document;

/**
 * Interface for Service DocumentServiceBean
 * 
 * @author tectuba
 * 
 */
@Local
public interface DocumentService {

	public void saveNewDocument(Document document, UploadedFile uploadedFile) throws FileNameAlreadyExistsException, InvalidInputStreamException;
	public void checkIsValidInputStream(UploadedFile uploadedFile) throws InvalidInputStreamException;
}
