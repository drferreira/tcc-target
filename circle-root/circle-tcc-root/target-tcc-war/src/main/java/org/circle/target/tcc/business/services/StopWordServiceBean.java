package org.circle.target.tcc.business.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.circle.target.tcc.business.exceptions.EmptyTypesStopWordsException;
import org.circle.target.tcc.kernel.PreProcessingDocument;
import org.circle.target.tcc.kernel.StopWord;
import org.circle.target.tcc.kernel.StopWordsDocument;
import org.circle.target.tcc.kernel.TypeStopWord;
import org.circle.target.tcc.kernel.Word;
import org.circle.target.tcc.kernel.daos.StopWordDao;
import org.circle.target.tcc.kernel.daos.TypeStopWordDao;
import org.circle.target.tcc.kernel.daos.WordDao;
import org.circle.target.tcc.kernel.exceptions.DataNotFoundException;

@Stateless
public class StopWordServiceBean implements Serializable, StopWordService {

	private static final long serialVersionUID = 286664141754103809L;

	@EJB
	private WordDao wordDao;
	@EJB
	private TypeStopWordDao typeStopWordDao;
	@EJB
	private StopWordDao stopWordDao;

	@Override
	public StopWordsDocument runStopWord(
			PreProcessingDocument processingDocument) {
		StopWordsDocument stopWordsDocument = new StopWordsDocument();

		List<Word> wordsWithoutRepetitions = removeRepetitions(processingDocument.getGrossWords());
		List<Word> unknownWords = getListOfUnknownWords(wordsWithoutRepetitions);
		List<StopWord> stopWordsLocated = getStopWords(wordsWithoutRepetitions);

		stopWordsDocument.setWordsWithoutRepetitions(wordsWithoutRepetitions);
		stopWordsDocument.setUnknownWords(unknownWords);
		stopWordsDocument.setStopWords(stopWordsLocated);
		stopWordsDocument.setResult(removeRepetitions(unknownWords));
		
		return stopWordsDocument;
	}

	private List<StopWord> getStopWords(List<Word> wordsWithoutRepetitions) {
		List<StopWord> stopWords = new ArrayList<StopWord>();

		for (Word word : wordsWithoutRepetitions) {
			try {
				Word wordTransient = wordDao.getWord(word.getValue());
				StopWord stopWord = stopWordDao
						.getStopWordByNameWord(wordTransient);
				stopWords.add(stopWord);

			} catch (DataNotFoundException e) {
			}
		}

		return stopWords;
	}

	@Override
	public List<StopWord> getAllStopWords() {
		return stopWordDao.getAll();
	}

	@Override
	public List<Word> getListOfUnknownWords(List<Word> words) {
		List<Word> unknownWords = new LinkedList<Word>();

		for (Word word : words) {
			if (!isWordMapped(word)) {
				unknownWords.add(word);
			}
		}

		return unknownWords;
	}

	public List<Word> removeRepetitions(List<Word> words) {
		List<Word> result = new ArrayList<Word>();

		for (Word word : words) {
			if (!result.contains(word)) {
				result.add(word);
			}
		}

		return result;
	}

	public boolean isWordMapped(Word word) {
		if (wordDao.getWord(word.getValue()) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<TypeStopWord> getAllTypesStopWords()
			throws EmptyTypesStopWordsException {
		List<TypeStopWord> allTypesStopWords = typeStopWordDao.getAll();

		if (!allTypesStopWords.isEmpty()) {
			return allTypesStopWords;

		} else {
			throw new EmptyTypesStopWordsException();
		}
	}

	@Override
	public void saveNewStopWord(StopWord stopWord) {
		stopWordDao.save(stopWord);
	}

	@Override
	public TypeStopWord getTypeStopWord(String value) {
		return typeStopWordDao.getByName(value);
	}

}
