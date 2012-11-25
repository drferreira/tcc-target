package br.org.circle.extractor.business.factorys;

import java.io.Serializable;

import org.primefaces.model.UploadedFile;

import br.org.circle.extractor.business.exceptions.ExtensionEmptyException;
import br.org.circle.extractor.business.exceptions.ExtensionNotMappedException;
import br.org.circle.extractor.business.util.DateUtil;
import br.org.circle.extractor.business.util.FileUtil;
import br.org.circle.extractor.dao.entitys.Document;
import br.org.circle.extractor.dao.entitys.Owner;

public class DocumentFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	private FileUtil fileUtil;
	public static final String ADDRESS_BASE_FILE = "jboss.server.log.dir";
		
	public DocumentFactory(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}
	
	/**
	 * Constructor for testing
	 */
	public DocumentFactory() {
	}

	/**
	 * Method responsible for creating an object of type Document from patterns
	 * pre-defined by the function. Receives as parameter the event captured
	 * upload the file and the owner of it. It takes as base address for the
	 * persistence file "/".
	 * 
	 * @param fileUploadEvent
	 * @param owner
	 * @return
	 * @throws ExtensionEmptyException
	 * @throws ExtensionNotMappedException
	 */
	public Document createDocument(UploadedFile uploadedFile, Owner owner)
			throws ExtensionNotMappedException, ExtensionEmptyException {
		Document document = new Document();

		document.setAddressFile(System.getProperty(ADDRESS_BASE_FILE));
		document.setDocumentFormat(fileUtil.getExtension(uploadedFile));
		document.setImportDate(DateUtil.getCurrentDate());
		document.setNameFile(uploadedFile.getFileName());
		document.setOwner(owner);
		document.setSizeFile(uploadedFile.getSize());

		return document;
	}

	public FileUtil getFileUtil() {
		return fileUtil;
	}

	public void setFileUtil(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

}
