package br.org.circle.extractor.business.exceptions;

@SuppressWarnings("rawtypes")
public class MessageInterfaceException extends Exception {

	private static final long serialVersionUID = 1L;
	private Class clazz;
	
	public <T extends MessageInterfaceException> MessageInterfaceException(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	
}
