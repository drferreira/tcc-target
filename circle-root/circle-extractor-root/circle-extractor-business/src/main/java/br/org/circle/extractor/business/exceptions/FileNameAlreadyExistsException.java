package br.org.circle.extractor.business.exceptions;

public class FileNameAlreadyExistsException extends MessageInterfaceException {
	private static final long serialVersionUID = 1L;
	
	public FileNameAlreadyExistsException() {
		super(FileNameAlreadyExistsException.class);
	}

}
