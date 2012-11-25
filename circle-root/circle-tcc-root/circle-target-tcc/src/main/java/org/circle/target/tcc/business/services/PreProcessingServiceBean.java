package org.circle.target.tcc.business.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.tcc.kernel.Document;
import org.circle.target.tcc.kernel.PreProcessingCompare;
import org.circle.target.tcc.kernel.PreProcessingDocument;
import org.circle.target.tcc.kernel.Word;

public @Stateless
class PreProcessingServiceBean implements PreProcessingService {
	private static final String REGEX_SPLIT = "(?<=\\S\\s)";
	private static final String REGEX_REPLACE_PUNCT = "\\p{Punct}";
	private static final String REGEX_REPLACE_LINE_BREACK = "\\n";

	@Override
	public PreProcessingDocument runPreProcessing(Document document) throws IOException {
		PreProcessingDocument documentClean = new PreProcessingDocument(document);

		List<Word> listWordsWithoutPunctuation = getListOfWords(document);
		List<Word> listWordsLowerCase = changeForLowerCase(listWordsWithoutPunctuation);

		documentClean.setGrossWords(listWordsLowerCase);

		return documentClean;
	}

	@Override
	public List<PreProcessingCompare> createCompareList(PreProcessingDocument preProcessingDocument) throws IOException {
		List<Word> dirtyList = splitText(preProcessingDocument.getDocument());
		List<Word> clearList = preProcessingDocument.getGrossWords();
		
		List<PreProcessingCompare> preProcessingCompares = new ArrayList<PreProcessingCompare>();
		
		Iterator<Word> iteratorDirty = dirtyList.iterator();
		Iterator<Word> interatorClear = clearList.iterator();
		
		while (iteratorDirty.hasNext() && interatorClear.hasNext()) {
			PreProcessingCompare compare = new PreProcessingCompare();
			compare.setOriginal(iteratorDirty.next());
			compare.setModified(interatorClear.next());
			
			preProcessingCompares.add(compare);
		}
		
		return preProcessingCompares;
	}

	public List<Word> changeForLowerCase(List<Word> words) {
		List<Word> resultList = new ArrayList<Word>();

		for (Word word : words) {
			Word resultWord = new Word(word.getValue().toLowerCase());
			resultList.add(resultWord);
		}

		return resultList;
	}

	public List<Word> getListOfWords(Document document) throws IOException {
		return removePunctuation(removeLineBreack(splitText(document)));
	}

	public List<Word> removePunctuation(List<Word> words) {
		return clearWords(REGEX_REPLACE_PUNCT, words);
	}
	
	public List<Word> removeLineBreack(List<Word> words) {
		return clearWords(REGEX_REPLACE_LINE_BREACK, words);
	}

	private List<Word> clearWords(String regex, List<Word> words) {
		List<Word> resultList = new ArrayList<Word>();

		for (Word word : words) {
			resultList.add(new Word(word.getValue().replaceAll(regex, "")));
		}

		return resultList;
	}

	public String removePunctuation(String text) {
		return text.replaceAll(REGEX_REPLACE_PUNCT, "");
	}

	public String removeLineBreack(String text) {
		return text.replaceAll(REGEX_REPLACE_LINE_BREACK, " ");
	}

	public String[] splitText(String text) {
		return text.split(REGEX_SPLIT);
	}

	public List<Word> splitText(Document document) throws IOException {
		String[] listWords = splitText(document.getText());
		List<Word> listResult = new ArrayList<Word>();

		for (String string : listWords) {
			listResult.add(new Word(string));
		}

		return listResult;
	}
}
