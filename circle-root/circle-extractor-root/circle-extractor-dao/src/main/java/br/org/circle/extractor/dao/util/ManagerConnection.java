package br.org.circle.extractor.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ManagerConnection {

	/**
	 * Create basic EntityManager for tests
	 * 
	 * @param pUnit
	 *            : String name persistence unit
	 * @return
	 */
	public static EntityManager createEntityManager(String pUnit) {
		return Persistence.createEntityManagerFactory(pUnit)
				.createEntityManager();
	}
}
