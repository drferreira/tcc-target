package org.circle.target.web.dtos;

public class MessageGrowl {
	private String keyHeaderMessage;
	private String namePropertie;
	private String keyMessagePropertie;
	private String idComponentTarget;

	public String getKeyHeaderMessage() {
		return keyHeaderMessage;
	}

	public void setKeyHeaderMessage(String keyHeaderMessage) {
		this.keyHeaderMessage = keyHeaderMessage;
	}

	public String getNamePropertie() {
		return namePropertie;
	}

	public void setNamePropertie(String namePropertie) {
		this.namePropertie = namePropertie;
	}

	public String getKeyMessagePropertie() {
		return keyMessagePropertie;
	}

	public void setKeyMessagePropertie(String keyPropertie) {
		this.keyMessagePropertie = keyPropertie;
	}

	public String getIdComponentTarget() {
		return idComponentTarget;
	}

	public void setIdComponentTarget(String idComponentTarget) {
		this.idComponentTarget = idComponentTarget;
	}
}
