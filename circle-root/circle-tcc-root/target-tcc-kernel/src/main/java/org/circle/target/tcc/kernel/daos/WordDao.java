package org.circle.target.tcc.kernel.daos;

import javax.ejb.Local;

import org.circle.target.tcc.kernel.Word;

@Local
public interface WordDao {

	Word getWord(String value);

}
