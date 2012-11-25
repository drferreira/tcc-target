package org.circle.target.dao.daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.dao.entities.Document;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public @Stateless class DocumentDaoBean extends GenericDao implements DocumentDao {

	private static final long serialVersionUID = 241519644847596L;
	private final Class<Document> entity = Document.class;

	/**
	 * Function responsible for checking whether a given file already exists.
	 * The check is done based on the name and the same in all possible
	 * locations of rescue.
	 * 
	 * @param namefile
	 * @return
	 */
	@Override
	public boolean exist(String nameFile) {
		if (listByName(nameFile).isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Method responsible for saving data from a particular file in the bank. An
	 * entity receives and persists in the same database.
	 * 
	 * @param document
	 */
	@Override
	public void saveDocumentInformations(Document document) {
		save(document);
	}

	@Override
	public void remove(Document document) {
		remove(document);
	}

	/**
	 * Function responsible for listing all documents from its name.
	 * 
	 * @param namefile
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> listByName(String namefile) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("nameFile", namefile));
		
		Criteria criteria = createCriteria(entity);
		mountCriteria(entity, expressions);
		
		return criteria.list();
	}
}
