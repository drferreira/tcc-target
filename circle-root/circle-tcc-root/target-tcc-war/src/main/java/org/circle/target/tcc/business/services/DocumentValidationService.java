package org.circle.target.tcc.business.services;

import java.io.IOException;

import javax.ejb.Local;

import org.circle.target.tcc.business.exceptions.EmptyInputStreamException;
import org.circle.target.tcc.business.exceptions.FileOversizedException;
import org.circle.target.tcc.kernel.Document;
import org.circle.target.tcc.text.enuns.DocumentFormat;
import org.circle.target.tcc.text.exceptions.ExtensionEmptyException;
import org.circle.target.tcc.text.exceptions.ExtensionNotMappedException;
import org.primefaces.model.UploadedFile;

@Local
public interface DocumentValidationService {

	int emptyFile(Document document) throws IOException, EmptyInputStreamException;

	DocumentFormat documentFormat(UploadedFile uploadedFile) throws ExtensionNotMappedException, ExtensionEmptyException;

	void limitSize(Document document) throws FileOversizedException, IOException, EmptyInputStreamException;

	void checkDocument(Document document) throws IOException, EmptyInputStreamException, FileOversizedException, ExtensionNotMappedException,
			ExtensionEmptyException;

}
