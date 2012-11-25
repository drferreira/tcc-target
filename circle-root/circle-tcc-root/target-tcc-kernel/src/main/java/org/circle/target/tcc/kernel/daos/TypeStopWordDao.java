package org.circle.target.tcc.kernel.daos;

import java.util.List;

import javax.ejb.Local;

import org.circle.target.tcc.kernel.TypeStopWord;

@Local
public interface TypeStopWordDao {

	List<TypeStopWord> getAll();

	TypeStopWord getByName(String value);

}
