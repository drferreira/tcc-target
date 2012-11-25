package org.circle.target.tcc.kernel;

import java.io.Serializable;

public class PreProcessingCompare implements Serializable {
	
	private static final long serialVersionUID = -2882894921408194090L;
	private Word original;
	private Word modified;
	
	
	public Word getOriginal() {
		return original;
	}
	
	public void setOriginal(Word original) {
		this.original = original;
	}
	
	public Word getModified() {
		return modified;
	}

	public void setModified(Word modified) {
		this.modified = modified;
	}
}
