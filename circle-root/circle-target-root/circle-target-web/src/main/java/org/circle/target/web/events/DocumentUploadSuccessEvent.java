package org.circle.target.web.events;

import org.circle.target.web.enums.Properties;
import org.circle.target.web.events.interfaces.MessageInterface;


public class DocumentUploadSuccessEvent extends Events implements MessageInterface {

	private static final long serialVersionUID = 1L;

	public DocumentUploadSuccessEvent() {
		setKeyMessagePropertie("upload.success");
		setKeyHeaderMessage("upload.success.header");
		setIdComponentTarget("messages");
		setPropertie(Properties.MESSAGES_DOCUMENT);
	}
}
