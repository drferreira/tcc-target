package org.circle.target.web.observers;

import java.io.InputStream;

import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import org.circle.target.web.dtos.MessageGrowl;
import org.circle.target.web.events.DocumentUploadSuccessEvent;
import org.circle.target.web.events.ExceptionMessageEvent;
import org.circle.target.web.pojos.PropertiesLoader;
import org.circle.target.web.pojos.ResourcesReader;
import org.circle.target.web.qualifiers.ExceptionMessages;
import org.circle.target.web.qualifiers.FinishingUpload;
import org.circle.target.web.utils.FacesContextUtil;

/**
 * Observer responsible for managing events linked to documents from one project
 * / user.
 * 
 * @author tectuba
 * 
 */
public class MessagesObserver {
	@Inject
	private FacesContextUtil facesContextUtil;
	@Inject
	private PropertiesLoader propertiesLoader;
	@Inject
	private ResourcesReader resourcesReader;

	/**
	 * Method responsible for performing the post process of completing the
	 * upload.
	 * 
	 * @param event
	 */
	public void sendMessageOfSuccess(@Observes @FinishingUpload DocumentUploadSuccessEvent documentUploadSuccessEvent) {
		MessageGrowl messageGrowl = new MessageGrowl();
		messageGrowl.setNamePropertie(documentUploadSuccessEvent.getPropertie().getNamePropertie());
		messageGrowl.setKeyMessagePropertie(documentUploadSuccessEvent.getKeyMessagePropertie());
		messageGrowl.setIdComponentTarget(documentUploadSuccessEvent.getIdComponentTarget());
		messageGrowl.setKeyHeaderMessage(documentUploadSuccessEvent.getKeyHeaderMessage());

		sendMessageInterface(messageGrowl);
	}

	/**
	 * Method responsible for screen display an exception message. Receives as a
	 * parameter of type Event ExceptionMessageEvent
	 * 
	 * @param event
	 */
	public void sendMessageException(@Observes @ExceptionMessages ExceptionMessageEvent event) {
		MessageGrowl messageGrowl = new MessageGrowl();
		messageGrowl.setNamePropertie(event.getPropertie().getNamePropertie());
		messageGrowl.setKeyMessagePropertie(event.getKeyMessagePropertie());
		messageGrowl.setIdComponentTarget(event.getIdComponentTarget());
		messageGrowl.setKeyHeaderMessage(event.getKeyHeaderMessage());

		sendMessageInterface(messageGrowl);
	}

	/**
	 * Method responsible for sending to the context of a particular message
	 * interface. Receives as a parameter the name of the propertie containing
	 * the message, the message key and the ID propertie component that received
	 * the message.
	 * 
	 * @param namePropertie
	 * @param keyPropertie
	 * @param idComponentTarget
	 */
	private void sendMessageInterface(MessageGrowl messageGrowl) {
		InputStream inputStreamResource = resourcesReader.getInputStreamResource(messageGrowl.getNamePropertie());
		propertiesLoader.loadPropertie(inputStreamResource);

		String valueMessage = propertiesLoader.getValue(messageGrowl.getKeyMessagePropertie());
		String keyHeaderMessage = propertiesLoader.getValue(messageGrowl.getKeyHeaderMessage());
		
		FacesMessage facesMessage = new FacesMessage(keyHeaderMessage, valueMessage);
		facesContextUtil.sendMessageToContext(facesMessage, messageGrowl.getIdComponentTarget());
	}
}
