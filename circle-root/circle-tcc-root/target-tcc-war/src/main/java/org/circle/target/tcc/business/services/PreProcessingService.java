package org.circle.target.tcc.business.services;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;

import org.circle.target.tcc.kernel.Document;
import org.circle.target.tcc.kernel.PreProcessingCompare;
import org.circle.target.tcc.kernel.PreProcessingDocument;

@Local
public interface PreProcessingService {

	PreProcessingDocument runPreProcessing(Document document) throws IOException;

	List<PreProcessingCompare> createCompareList(PreProcessingDocument preProcessingDocument) throws IOException;
}
