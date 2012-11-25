package org.circle.target.tcc.kernel;

import java.util.List;

public class StopWordsDocument {
	
	private List<Word> unknownWords;

	public List<Word> getUnknownWords() {
		return unknownWords;
	}

	public void setUnknownWords(List<Word> unknownWords) {
		this.unknownWords = unknownWords;
	}
}
