package br.org.circle.extractor.web.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
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

	/**
	 * Method responsible for adding a message to FacesMessage FaceContext
	 * receives as a parameter to the value and the type of message.
	 * 
	 * @param facesMessage
	 * @param idComponent
	 */
	public void sendMessageToContext(FacesMessage facesMessage,
			String idComponent) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(idComponent, facesMessage);
	}
}
