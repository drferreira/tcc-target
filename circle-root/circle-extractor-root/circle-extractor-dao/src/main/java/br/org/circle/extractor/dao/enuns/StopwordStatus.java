package br.org.circle.extractor.dao.enuns;

public enum StopwordStatus {

	REMOVED_IN_EXTRACTION("removedExtraction"),
	REMOVED_IN_PROJECT("removedProject"),
	INCORRECT("incorrect"),
	VALID("valid");
	
	private String status;
	
	private StopwordStatus(String status) {
		this.status=status;
	}
	
	public String getstatus(){
		return status;
	}
}
