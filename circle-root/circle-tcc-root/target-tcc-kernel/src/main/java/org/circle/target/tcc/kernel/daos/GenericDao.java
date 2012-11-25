package org.circle.target.tcc.kernel.daos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.SimpleExpression;


/**
 * Generic DAO responsible for encapsulating attributes and functions common to
 * all DAOs.
 * 
 * @author tectuba
 *
 */
public abstract class GenericDao implements Serializable {

	@PersistenceContext
	private EntityManager entityManager;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Performs persistent new entries in the database.
	 * 
	 * @param entity
	 *            : Entity to be persisted.
	 */
	public void persist(Object entity) {
		entityManager.persist(entity);
	}
	
	public void merge(Object entity){
		entityManager.merge(entity);
	}

	/**
	 * 
	 * Perform a search for an existing entry in the database from your PK. If
	 * the search does not return NULL result is returned.
	 * @param <T>
	 * 
	 * @param pk
	 *            : PK value of the search to be performed.
	 * 
	 */
	public <T> T findbyKey(Class<T> clazz, Object pk) {
		return entityManager.find(clazz, pk);
	}

	/**
	 * 
	 * Perform to removal of an existing entry in the database for it to be made
	 * the object takes as parameter / input on the base to be able to remove.
	 * 
	 * @param entity
	 *            : Existing entity in the database which will be removed.
	 * 
	 */
	public void remove(Object entity) {
		entityManager.remove(entity);

	}

	/**
	 * 
	 * Performs update of an entity in the database. All data that have existing
	 * differences will be replaced.
	 * 
	 * @param entity
	 *            : Existing entity which will be persisted in the database.
	 * 
	 */
	public void update(Object entity) {
		entityManager.merge(entity);

	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public <T> Criteria createCriteria(Class<T> clazz){
		Session session = (Session) entityManager.getDelegate();
		return session.createCriteria(clazz);
	}
	
	/**
	 * 
	 * @param clazz
	 * @param restrictions
	 * @return
	 */
	public <T> Criteria mountCriteria(Class<T> clazz, List<SimpleExpression> restrictions){
		Criteria criteria = createCriteria(clazz);
		
		for (SimpleExpression simpleExpression : restrictions) {
			criteria.add(simpleExpression);
		}
		return criteria;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
