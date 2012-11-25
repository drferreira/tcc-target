package br.org.circle.extractor.business.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.org.circle.extractor.dao.entitys.Owner;

public class FakeUserUtil {
	
	@PersistenceContext
	private EntityManager entityManager;
	public static final String KEYUSER = "AAAAA";

	/**
	 * Search for a user user for testing.
	 * 
	 * @return
	 */
	public Owner getFakeUser(){
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Owner.class).add(
				Restrictions.eq("keyUser", KEYUSER));
		return (Owner) criteria.uniqueResult();
	}
}
