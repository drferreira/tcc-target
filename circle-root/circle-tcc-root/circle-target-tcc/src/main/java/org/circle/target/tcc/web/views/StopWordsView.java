package org.circle.target.tcc.web.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.circle.target.tcc.business.services.StopWordService;
import org.circle.target.tcc.kernel.StopWordsDocument;
import org.circle.target.tcc.kernel.Word;

@Named
@ConversationScoped
public class StopWordsView implements Serializable {

	private static final long serialVersionUID = -6552791097127956629L;
	
	@Inject private PreProcessingView preProcessingView;
	@EJB private StopWordService stopWordService;
	private StopWordsDocument stopWordsDocument;

	@PostConstruct
	public void init(){
		stopWordsDocument = stopWordService.runStopWord(preProcessingView.getDocumentClean());
	}
	
	public List<Word> getWordUnknownList(){
		return stopWordsDocument.getUnknownWords();
	}
	
	
	public PreProcessingView getPreProcessingView() {
		return preProcessingView;
	}

	public void setPreProcessingView(PreProcessingView preProcessingView) {
		this.preProcessingView = preProcessingView;
	}


	public StopWordService getStopWordService() {
		return stopWordService;
	}


	public void setStopWordService(StopWordService stopWordService) {
		this.stopWordService = stopWordService;
	}


	public StopWordsDocument getStopWordsDocument() {
		return stopWordsDocument;
	}


	public void setStopWordsDocument(StopWordsDocument stopWordsDocument) {
		this.stopWordsDocument = stopWordsDocument;
	}
}
