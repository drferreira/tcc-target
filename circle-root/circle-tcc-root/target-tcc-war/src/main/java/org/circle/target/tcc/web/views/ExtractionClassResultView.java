package org.circle.target.tcc.web.views;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.tcc.kernel.StopWordsDocument;
import org.circle.target.tcc.kernel.Word;

@Named
public class ExtractionClassResultView implements Serializable {

	private static final long serialVersionUID = 354963534364403335L;
	
	@Inject
	private StopWordsView stopWordsView;
	
	public List<Word> getListWords(){
		StopWordsDocument stopWordsDocument = stopWordsView.getStopWordsDocument();

		return stopWordsDocument.getResult();
	}
	
	public StopWordsView getStopWordsView() {
		return stopWordsView;
	}

	public void setStopWordsView(StopWordsView stopWordsView) {
		this.stopWordsView = stopWordsView;
	}
}
