package br.org.circle.extractor.web.events;

import br.org.circle.extractor.business.exceptions.MessageInterfaceException;
import br.org.circle.extractor.web.enuns.Properties;

public class ExceptionMessageEvent extends EventsExtractor implements MessageInterface {

	private static final long serialVersionUID = 1L;

	public ExceptionMessageEvent(MessageInterfaceException exception) {
		setKeyMessagePropertie(exception.getClazz().getSimpleName());
		setKeyHeaderMessage("exception.header");
		setIdComponentTarget("messages");
		setPropertie(Properties.MESSAGES_EXCEPTIONS);
	}
}
