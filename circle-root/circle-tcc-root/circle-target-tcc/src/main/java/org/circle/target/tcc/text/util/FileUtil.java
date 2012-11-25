package org.circle.target.tcc.text.util;

import org.circle.target.tcc.text.enuns.DocumentFormat;
import org.circle.target.tcc.text.exceptions.ExtensionEmptyException;
import org.circle.target.tcc.text.exceptions.ExtensionNotMappedException;
import org.primefaces.model.UploadedFile;

public class FileUtil {

	/**
	 * Responsible method for extracting a list of the type related to extension
	 * in the UploadedFile received as parameter. Also uses the method public
	 * String getExtension (String fullNameFile) to perform the action. If there
	 * is a valid extension for not being mapped or described the value null is
	 * returned.
	 * 
	 * @param uploadedFile
	 * @return
	 * @throws ExtensionNotMappedException
	 * @throws ExtensionEmptyException
	 */
	public DocumentFormat getExtension(UploadedFile uploadedFile) throws ExtensionNotMappedException, ExtensionEmptyException {
		String extension = getExtension(uploadedFile.getFileName());

		DocumentFormat documentFormatList[] = DocumentFormat.values();

		for (DocumentFormat documentFormat : documentFormatList) {
			if (extension.equals(documentFormat.getType())) {
				return documentFormat;
			}
		}
		throw new ExtensionNotMappedException();
	}

	/**
	 * Receives as a parameter the full name of a particular file and returns to
	 * the same extent as long as it respects the standard. "xxx". If not
	 * identified presense an extension null is returned. Sets the return within
	 * the extension variable
	 * 
	 * @param fullNameFile
	 *            : String full name file.
	 * @return: String extension or null on failure
	 * @throws ExtensionEmptyException
	 *             Empty extension in fullNameFile
	 */
	public String getExtension(String fullNameFile) throws ExtensionEmptyException {
		String extension[] = fullNameFile.split("\\.");
		int occurrences = extension.length;
		if (occurrences == 1) {
			throw new ExtensionEmptyException();
		} else {
			return extension[occurrences - 1];
		}
	}
}
