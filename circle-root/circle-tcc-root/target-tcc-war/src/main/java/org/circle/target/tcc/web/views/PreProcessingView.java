package org.circle.target.tcc.web.views;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.tcc.business.services.PreProcessingService;
import org.circle.target.tcc.kernel.Document;
import org.circle.target.tcc.kernel.PreProcessingDocument;

@Named
@ConversationScoped
public class PreProcessingView implements Serializable{

	private static final long serialVersionUID = -8392458892639568995L;
	
	@Inject private UploadView uploadView;
	@EJB private PreProcessingService preProcessingService;
	
	private PreProcessingDocument preProcessingDocument;
	
	@PostConstruct
	public void init(){
		try {
			preProcessingDocument = preProcessingService.runPreProcessing(uploadView.getDocument());
		
		} catch (IOException e) {
			
		}
	}
	
	public String getOriginalText() throws IOException{
		Document document = uploadView.getDocument();
		return document.getText();
	}

	public PreProcessingDocument getDocumentClean() {
		return preProcessingDocument;
	}

	public void setDocumentClean(PreProcessingDocument documentClean) {
		this.preProcessingDocument = documentClean;
	}
}
