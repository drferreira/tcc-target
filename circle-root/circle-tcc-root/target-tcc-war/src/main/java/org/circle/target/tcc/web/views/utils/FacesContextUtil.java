package org.circle.target.tcc.web.views.utils;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Utility classes that provides features to help manages message via
 * FaceContext
 * 
 * @author tectuba
 * 
 */
public class FacesContextUtil implements Serializable{

	private static final long serialVersionUID = 1L;

	public static void sendMessageToContext(Severity severity, String summary, String detail, String idComponent) {
		FacesMessage facesMessage = new FacesMessage(severity, summary, detail);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(idComponent, facesMessage);
	}
	
}
