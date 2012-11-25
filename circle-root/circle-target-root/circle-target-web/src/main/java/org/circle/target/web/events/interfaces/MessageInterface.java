package org.circle.target.web.events.interfaces;

import org.circle.target.web.enums.Properties;

public interface MessageInterface {

	public String getIdComponentTarget();

	public void setIdComponentTarget(String idComponentTarget);

	public String getKeyMessagePropertie();

	public Properties getPropertie();

	public String getKeyHeaderMessage();
}
