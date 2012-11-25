package br.org.circle.extractor.web.events;

import br.org.circle.extractor.web.enuns.Properties;

public class DocumentUploadSuccessEvent extends EventsExtractor implements MessageInterface {

	private static final long serialVersionUID = 1L;

	public DocumentUploadSuccessEvent() {
		setKeyMessagePropertie("upload.success");
		setKeyHeaderMessage("upload.success.header");
		setIdComponentTarget("messages");
		setPropertie(Properties.MESSAGES_DOCUMENT);
	}
}
