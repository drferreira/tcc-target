package org.circle.target.tcc.business.services;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.circle.target.tcc.kernel.PreProcessingDocument;
import org.circle.target.tcc.kernel.StopWordsDocument;
import org.circle.target.tcc.kernel.Word;
import org.circle.target.tcc.kernel.daos.WordDao;

@Stateless
public class StopWordServiceBean implements Serializable, StopWordService {

	private static final long serialVersionUID = 286664141754103809L;

	@EJB
	private WordDao wordDao;

	@Override
	public StopWordsDocument runStopWord(PreProcessingDocument processingDocument) {
		StopWordsDocument stopWordsDocument = new StopWordsDocument();
		
		stopWordsDocument.setUnknownWords(processingDocument.getGrossWords());
		
		return stopWordsDocument;
	}

	public List<Word> getListOfUnknownWords(List<Word> words) {
		List<Word> unknownWords = new LinkedList<Word>();

		for (Word word : words) {
			if (!isWordMapped(word)) {
				unknownWords.add(word);
			}
		}

		return unknownWords;
	}

	public boolean isWordMapped(Word word) {
		if (wordDao.getWord(word.getValue()) != null) {
			return true;
		} else {
			return false;
		}
	}

}
