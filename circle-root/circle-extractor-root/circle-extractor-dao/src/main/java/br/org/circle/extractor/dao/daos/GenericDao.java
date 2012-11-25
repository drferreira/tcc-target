package br.org.circle.extractor.dao.daos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Generic DAO responsible for encapsulating attributes and functions common to
 * all DAOs.
 * 
 * @author tectuba
 * 
 * @param <T>
 */
public class GenericDao implements Dao, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Performs persistent new entries in the database.
	 * 
	 * @param entity
	 *            : Entity to be persisted.
	 */
	@Override
	public void save(Object entity) {
		entityManager.persist(entity);
	}

	/**
	 * 
	 * Perform a search for an existing entry in the database from your PK. If
	 * the search does not return NULL result is returned.
	 * 
	 * @param pk
	 *            : PK value of the search to be performed.
	 * @param clazz
	 *            : .class which refers to the point of search, eg Searching
	 *            table = VendasEntity.class sale as a reference.
	 * 
	 */
	@Override
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
	@Override
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
	@Override
	public void update(Object entity) {
		entityManager.merge(entity);

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
