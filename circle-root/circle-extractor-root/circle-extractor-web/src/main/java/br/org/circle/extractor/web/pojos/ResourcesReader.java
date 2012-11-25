package br.org.circle.extractor.web.pojos;

import java.io.IOException;
import java.io.InputStream;

public class ResourcesReader {
	
	/**
	 * Responsible for seeking a method of an inputStream propertie access
	 * possible to behold.
	 * 
	 * @param fileNameResource
	 * @return
	 */
	public InputStream getInputStreamResource(String fileNameResource) {
		try {
			InputStream imputStream = Thread.currentThread().getContextClassLoader().getResource(fileNameResource).openStream();
			return imputStream;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
