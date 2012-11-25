package br.org.circle.extractor.dao.util;

import junit.framework.Assert;

import org.junit.Test;

public class ManagerConnectionTest {

	/**
	 * Test to create a manual test entitymanager
	 */
	@Test
	public void getEntityManager() {
		Assert.assertNotNull(ManagerConnection
				.createEntityManager("circle-pu-test"));
	}
}
