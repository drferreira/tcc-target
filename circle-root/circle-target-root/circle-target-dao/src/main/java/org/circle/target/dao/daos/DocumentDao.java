package org.circle.target.dao.daos;

import java.util.List;

import javax.ejb.Local;

import org.circle.target.dao.entities.Document;

@Local
public interface DocumentDao {

	boolean exist(String nameFile);

	void saveDocumentInformations(Document document);

	void remove(Document document);

	List<Object> listByName(String namefile);

}
