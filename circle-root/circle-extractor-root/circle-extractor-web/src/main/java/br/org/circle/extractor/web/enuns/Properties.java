package br.org.circle.extractor.web.enuns;

public enum Properties {

	MESSAGES_EXCEPTIONS("messages-exception.properties"),
	MESSAGES_DOCUMENT("messages-document.properties");
	
	private String name;
	
	private Properties(String name) {
		this.name = name;
	}
	
	public String getNamePropertie(){
		return name;
	}
}
