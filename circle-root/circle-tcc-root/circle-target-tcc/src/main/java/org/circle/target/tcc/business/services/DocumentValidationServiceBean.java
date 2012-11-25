package org.circle.target.tcc.business.services;

import java.io.IOException;

import javax.ejb.Stateless;

import org.circle.target.tcc.business.exceptions.EmptyInputStreamException;
import org.circle.target.tcc.business.exceptions.FileOversizedException;
import org.circle.target.tcc.kernel.Document;
import org.circle.target.tcc.text.enuns.DocumentFormat;
import org.circle.target.tcc.text.exceptions.ExtensionEmptyException;
import org.circle.target.tcc.text.exceptions.ExtensionNotMappedException;
import org.circle.target.tcc.text.util.FileUtil;
import org.primefaces.model.UploadedFile;

public @Stateless
class DocumentValidationServiceBean implements DocumentValidationService {
	private Integer sizeLimitBytes = 4194304;
	
	@Override
	public void checkDocument(Document document) throws IOException, EmptyInputStreamException, FileOversizedException, ExtensionNotMappedException, ExtensionEmptyException{
		
		emptyFile(document);
		documentFormat(document.getUploadedFile());
		limitSize(document);
	}
	
	@Override
	public int emptyFile(Document document) throws IOException, EmptyInputStreamException {
		int size = document.getSize();

		if (size != 0) {
			return size;

		} else {
			throw new EmptyInputStreamException();
		}
	}

	@Override
	public DocumentFormat documentFormat(UploadedFile uploadedFile) throws ExtensionNotMappedException, ExtensionEmptyException {
		FileUtil fileUtil = new FileUtil();

		return fileUtil.getExtension(uploadedFile);

	}

	@Override
	public void limitSize(Document document) throws FileOversizedException, IOException, EmptyInputStreamException {
		Integer size = document.getSize();

		if (size < sizeLimitBytes) {

		} else {
			throw new FileOversizedException();
		}
	}
}
