package org.circle.target.web.events;

import org.circle.target.business.exceptions.MessageException;
import org.circle.target.web.enums.Properties;
import org.circle.target.web.events.interfaces.MessageInterface;

public class ExceptionMessageEvent extends Events implements MessageInterface {

	private static final long serialVersionUID = 1L;

	public ExceptionMessageEvent(MessageException exception) {
		setKeyMessagePropertie(exception.getClazz().getSimpleName());
		setKeyHeaderMessage("exception.header");
		setIdComponentTarget("messages");
		setPropertie(Properties.MESSAGES_EXCEPTIONS);
	}
}
