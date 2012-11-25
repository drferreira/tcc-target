package org.circle.target.tcc.kernel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Word implements Serializable {

	private static final long serialVersionUID = -6416611038458712955L;

	@Id
	@Column(name="id_word")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long idWord;
	
	@Column(name = "value_word", nullable = false)
	private String value;

	public Word(String value) {
		this.value = value;
	}
	
	public Word() {
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getIdWord() {
		return idWord;
	}

	public void setIdWord(Long idWord) {
		this.idWord = idWord;
	}
	
	@Override
	public boolean equals(Object object) {
		Word word = (Word) object;
		
		if (value.equals(word.getValue())) {
			return true;
		}else {
			return false;
		}
	}
}
