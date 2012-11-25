package org.circle.target.tcc.business.services;

import javax.ejb.Local;

import org.circle.target.tcc.kernel.PreProcessingDocument;
import org.circle.target.tcc.kernel.StopWordsDocument;

@Local
public interface StopWordService {

	public StopWordsDocument runStopWord(PreProcessingDocument processingDocument);

}
