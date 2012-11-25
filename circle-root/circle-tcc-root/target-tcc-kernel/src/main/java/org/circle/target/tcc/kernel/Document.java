package org.circle.target.tcc.kernel;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

public class Document implements Serializable {

	private static final long serialVersionUID = -5282570756289884306L;
	
	private UploadedFile uploadedFile;
	
	public Document(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public int getSize() throws IOException {
		return getInputStream().available();
	}
	
	public String getText() throws IOException{
		return IOUtils.toString(getInputStream());
	}
	
	public InputStream getInputStream() throws IOException {
		return uploadedFile.getInputstream();
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
}
