package org.circle.target.tcc.business.services;

import java.util.List;

import javax.ejb.Local;

import org.circle.target.tcc.business.exceptions.EmptyTypesStopWordsException;
import org.circle.target.tcc.kernel.PreProcessingDocument;
import org.circle.target.tcc.kernel.StopWord;
import org.circle.target.tcc.kernel.StopWordsDocument;
import org.circle.target.tcc.kernel.TypeStopWord;
import org.circle.target.tcc.kernel.Word;

@Local
public interface StopWordService {

	public StopWordsDocument runStopWord(PreProcessingDocument processingDocument);

	public List<TypeStopWord> getAllTypesStopWords() throws EmptyTypesStopWordsException;

	public void saveNewStopWord(StopWord stopWord);

	public TypeStopWord getTypeStopWord(String selectedTypeStopWordId);

	List<Word> getListOfUnknownWords(List<Word> words);

	List<StopWord> getAllStopWords();

}
