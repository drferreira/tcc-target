package br.org.circle.extractor.dao.daos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import br.org.circle.extractor.dao.entitys.Document;

/**
 * Dao responsible for managing all resources on persistent documents.
 * 
 * @author tectuba
 * 
 */
public class DocumentDao extends GenericDao {
	private static final long serialVersionUID = 1L;

	/**
	 * Method responsible for saving data from a particular file in the bank. An
	 * entity receives and persists in the same database.
	 * 
	 * @param document
	 */
	public void saveDocumentInformations(Document document) {
		save(document);
	}

	/**
	 * Function responsible for checking whether a given file already exists.
	 * The check is done based on the name and the same in all possible
	 * locations of rescue.
	 * 
	 * @param namefile
	 * @return
	 */
	public boolean exist(String namefile) {
		if (listByName(namefile).isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Function responsible for listing all documents from its name.
	 * 
	 * @param namefile
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List listByName(String namefile) {
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Document.class).add(Restrictions.eq("nameFile", namefile));
		return criteria.list();
	}
}
