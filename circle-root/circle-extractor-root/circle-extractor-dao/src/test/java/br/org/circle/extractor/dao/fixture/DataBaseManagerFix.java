package br.org.circle.extractor.dao.fixture;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.org.circle.extractor.dao.entitys.Owner;
import br.org.circle.extractor.dao.util.ManagerConnection;

public class DataBaseManagerFix {

	private EntityManager entityManager;
	public static final String KEYUSER = "AAAAA";
	
	/**
	 * Helper method to insert a User in the database. Should be used as a JUnit
	 * test
	 */
	@Test
	public void createUserForTest() {
		entityManager = ManagerConnection.createEntityManager("circle-pu-test");

		entityManager.getTransaction().begin();

		Owner owner = new Owner();
		owner.setKeyUser(KEYUSER);
		entityManager.persist(owner);
		entityManager.getTransaction().commit();
	}
}
