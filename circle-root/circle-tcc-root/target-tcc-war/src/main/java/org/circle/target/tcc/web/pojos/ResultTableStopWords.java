package org.circle.target.tcc.web.pojos;

import org.circle.target.tcc.kernel.StopWord;
import org.circle.target.tcc.kernel.Word;

public class ResultTableStopWords {
	
	private StopWord stopWord;
	private Word duplicated;
	
	
	public StopWord getStopWord() {
		return stopWord;
	}
	public void setStopWord(StopWord stopWord) {
		this.stopWord = stopWord;
	}
	public Word getDuplicatedWord() {
		return duplicated;
	}
	public void setDuplicatedWord(Word duplicated) {
		this.duplicated = duplicated;
	}
}
