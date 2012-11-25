package br.org.circle.extractor.dao.enuns;

public enum StopwordType {

	LOCAL("local"),
	PROJECT("project"),
	GLOBAL("global");
	
	private String type;
	
	private StopwordType(String type) {
		this.type=type;
	}
	
	public String getType(){
		return type;
	}

}
