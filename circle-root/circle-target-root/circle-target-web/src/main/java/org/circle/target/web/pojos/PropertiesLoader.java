package org.circle.target.web.pojos;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * 
 * Class responvel for managing access to properties. Provides access to the
 * same resources, and handling them.
 * 
 * @author tectuba
 * 
 */
public class PropertiesLoader implements Serializable{

	private static final long serialVersionUID = 1L;
	private Properties propertie;
	private InputStream inputStreamPropertie;

	/**
	 * Method responsible for loading a new propertie and make available the
	 * resources on it.
	 * 
	 * @param fileNameResource
	 * @return
	 */
	public boolean loadPropertie(InputStream inputStreamPropertie) {
		this.inputStreamPropertie = inputStreamPropertie;
		propertie = new Properties();
		
		try {
			propertie.load(inputStreamPropertie);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	public String getValue(String key) {
		return (String) propertie.getProperty(key);
	}

	public Properties getPropertie() {
		return propertie;
	}

	public void setPropertie(Properties propertie) {
		this.propertie = propertie;
	}

	public InputStream getInputStreamPropertie() {
		return inputStreamPropertie;
	}

	public void setInputStreamPropertie(InputStream inputStreamPropertie) {
		this.inputStreamPropertie = inputStreamPropertie;
	}
	
	

}
