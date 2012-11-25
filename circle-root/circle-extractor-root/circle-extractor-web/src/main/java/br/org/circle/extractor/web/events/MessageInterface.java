package br.org.circle.extractor.web.events;

import br.org.circle.extractor.web.enuns.Properties;

public interface MessageInterface {

	public String getIdComponentTarget();

	public void setIdComponentTarget(String idComponentTarget);

	public String getKeyMessagePropertie();

	public Properties getPropertie();

	public String getKeyHeaderMessage();
}
