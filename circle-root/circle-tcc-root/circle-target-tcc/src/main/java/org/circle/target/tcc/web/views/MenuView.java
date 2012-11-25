package org.circle.target.tcc.web.views;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class MenuView implements Serializable{

	private static final long serialVersionUID = -7448014999713528220L;
	private static final String GO_TO_HOME = "GO_TO_HOME";
	private static final String GO_TO_NEXT_STEP = "GO_TO_NEXT_STEP";
	private static final String GO_TO_STOPWORDS_PAGE = "GO_TO_STOPWORDS_PAGE";
	
	@Inject private Conversation conversation;
	
	public String cancelExtraction(){
		conversation.end();
		
		return GO_TO_HOME;
	}
	
	public String nextStep(){
		return GO_TO_NEXT_STEP;
	}
	
	public String viewResults(){
		return getNameViewId();
	}
	
	public String backToExtraction(){
		return getNameViewId();
	}
	
	private String getNameViewId(){
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}
	
	public String listStopWords(){
		return GO_TO_STOPWORDS_PAGE;
	}
}
