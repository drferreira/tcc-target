package org.circle.target.tcc.text.enuns;


public enum DocumentFormat {

	DOC("doc"), DOCX("docx"), ODT("odt"), TXT("txt");

	private String type;

	private DocumentFormat(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	/**
	 * Checks whether the passed value is equal to the value set in the
	 * enumeration
	 * 
	 * @param extension
	 * @return
	 */
	public boolean equals(String extension) {
		if (this.type.equalsIgnoreCase(extension)) {
			return true;
		} else {
			return false;
		}
	}
		
}
