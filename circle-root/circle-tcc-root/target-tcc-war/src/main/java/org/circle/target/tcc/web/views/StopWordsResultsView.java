package org.circle.target.tcc.web.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.tcc.kernel.StopWord;
import org.circle.target.tcc.kernel.StopWordsDocument;
import org.circle.target.tcc.kernel.Word;
import org.circle.target.tcc.web.pojos.ResultTableStopWords;

@Named
public class StopWordsResultsView implements Serializable {

	private static final long serialVersionUID = -5890729874122732126L;

	@Inject
	private StopWordsView stopWordsView;
	@Inject
	private PreProcessingView preProcessingView;
	
	public List<StopWord> getListOfStopWordsFound(){
		StopWordsDocument stopWordsDocument = stopWordsView.getStopWordsDocument();
		
		return stopWordsDocument.getStopWords();
	}
	
	public List<ResultTableStopWords> getListResultTable(){
		List<Word> fullText = preProcessingView.getDocumentClean().getGrossWords();
		List<StopWord> stopWords = stopWordsView.getStopWordsDocument().getStopWords();
		List<Word> repetitionWords = getRepeatedWords(fullText);
		
		List<ResultTableStopWords> resultTableStopWords = new ArrayList<ResultTableStopWords>();
		
		Iterator<StopWord> itStop = stopWords.iterator();
		Iterator<Word> itRep = repetitionWords.iterator();
		
		while (itStop.hasNext() || itRep.hasNext()) {
			ResultTableStopWords stop = new ResultTableStopWords();
			
			try {
				stop.setStopWord(itStop.next());
			} catch (NoSuchElementException e) {
				// List finished
			}
			
			try {
				stop.setDuplicatedWord(itRep.next());
			} catch (NoSuchElementException e) {
				// List finished
			}
			
			resultTableStopWords.add(stop);
		}
		
		return resultTableStopWords;
	}
	
	private List<Word> getRepeatedWords(List<Word> words){
		List<Word> cleanList = new ArrayList<Word>();
		List<Word> repetitionList = new ArrayList<Word>();
		
		for (Word word : words) {
			if (!cleanList.contains(word)) {
				cleanList.add(word);
				
			}else {
				repetitionList.add(word);
			}
		}
		
		return repetitionList;
	}

	public StopWordsView getStopWordsView() {
		return stopWordsView;
	}

	public void setStopWordsView(StopWordsView stopWordsView) {
		this.stopWordsView = stopWordsView;
	}
}
