package org.circle.target.tcc.web.views;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.tcc.business.services.PreProcessingService;
import org.circle.target.tcc.kernel.PreProcessingCompare;

@Named
@ConversationScoped
public class PreProcessingResultsView implements Serializable {

	private static final long serialVersionUID = -637903970809259002L;

	@Inject
	private PreProcessingView preProcessingView;
	@EJB
	private PreProcessingService preProcessingService;
	private List<PreProcessingCompare> comparisonList;

	@PostConstruct
	public void init() throws IOException {
		comparisonList = preProcessingService.createCompareList(preProcessingView.getDocumentClean());
	}

	public PreProcessingView getPreProcessingView() {
		return preProcessingView;
	}

	public void setPreProcessingView(PreProcessingView preProcessingView) {
		this.preProcessingView = preProcessingView;
	}

	public PreProcessingService getPreProcessingService() {
		return preProcessingService;
	}

	public void setPreProcessingService(PreProcessingService preProcessingService) {
		this.preProcessingService = preProcessingService;
	}

	public List<PreProcessingCompare> getComparisonList() {
		return comparisonList;
	}

	public void setComparisonList(List<PreProcessingCompare> comparisonList) {
		this.comparisonList = comparisonList;
	}
}
