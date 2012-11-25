package org.circle.target.web.events;

import java.io.Serializable;
import org.circle.target.web.enums.Properties;

public class Events implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idComponentTarget;
	private String keyHeaderMessage;
	private String keyMessagePropertie;
	private Properties propertie;

	public String getIdComponentTarget() {
		return idComponentTarget;
	}

	public void setIdComponentTarget(String idComponentTarget) {
		this.idComponentTarget = idComponentTarget;
	}

	public String getKeyHeaderMessage() {
		return keyHeaderMessage;
	}

	public void setKeyHeaderMessage(String keyHeaderMessage) {
		this.keyHeaderMessage = keyHeaderMessage;
	}

	public String getKeyMessagePropertie() {
		return keyMessagePropertie;
	}

	public void setKeyMessagePropertie(String keyMessagePropertie) {
		this.keyMessagePropertie = keyMessagePropertie;
	}

	public Properties getPropertie() {
		return propertie;
	}

	public void setPropertie(Properties propertie) {
		this.propertie = propertie;
	}
}
