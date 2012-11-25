package org.circle.target.tcc.kernel;

import java.util.List;

public class StopWordsDocument {
	
	private List<Word> wordsWithoutRepetitions;
	private List<Word> unknownWords;
	private List<StopWord> stopWords;
	private List<Word> result;

	public List<Word> getResult() {
		return result;
	}

	public void setResult(List<Word> result) {
		this.result = result;
	}

	public List<Word> getUnknownWords() {
		return unknownWords;
	}

	public void setUnknownWords(List<Word> unknownWords) {
		this.unknownWords = unknownWords;
	}

	public List<StopWord> getStopWords() {
		return stopWords;
	}

	public void setStopWords(List<StopWord> stopWords) {
		this.stopWords = stopWords;
	}

	public List<Word> getWordsWithoutRepetitions() {
		return wordsWithoutRepetitions;
	}

	public void setWordsWithoutRepetitions(List<Word> wordsWithoutRepetitions) {
		this.wordsWithoutRepetitions = wordsWithoutRepetitions;
	}
}
