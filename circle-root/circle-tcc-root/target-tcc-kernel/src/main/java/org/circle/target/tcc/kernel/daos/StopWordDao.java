package org.circle.target.tcc.kernel.daos;

import java.util.List;

import javax.ejb.Local;

import org.circle.target.tcc.kernel.StopWord;
import org.circle.target.tcc.kernel.Word;
import org.circle.target.tcc.kernel.exceptions.DataNotFoundException;

@Local
public interface StopWordDao {

	void save(StopWord stopWord);

	List<StopWord> getAll();

	StopWord getStopWordByNameWord(Word word) throws DataNotFoundException;

}
