package org.circle.target.tcc.kernel;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class PreProcessingDocument implements Serializable {

	private static final long serialVersionUID = 8724812572046744378L;

	private Document document;
	private List<Word> grossWords;
	
	public PreProcessingDocument(Document document) throws IOException {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<Word> getGrossWords() {
		return grossWords;
	}

	public void setGrossWords(List<Word> grossWords) {
		this.grossWords = grossWords;
	}
}
