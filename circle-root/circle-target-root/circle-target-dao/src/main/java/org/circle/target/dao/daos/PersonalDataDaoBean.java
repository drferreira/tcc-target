package org.circle.target.dao.daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.dao.entities.PersonalData;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@Stateless
public class PersonalDataDaoBean extends GenericDao implements PersonalDataDao {

	private static final long serialVersionUID = 1L;
	private final Class<PersonalData> entity = PersonalData.class;

	/**
	 * Method responsible for fetching a list of "personal data" in which the
	 * value exists first name, using the "like".
	 * 
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<PersonalData> fetchLikeFirstName(String firstName) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("firstName", firstName + "%"));

		Criteria criteria = mountCriteria(entity, expressions);
		return criteria.list();
	}

	/**
	 * Method responsible for fetching a list of "personal data" in which there
	 * is the value last name, using the "like".
	 * 
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<PersonalData> fetchLikeLastName(String lastName) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("lastName", lastName + "%"));

		Criteria criteria = mountCriteria(entity, expressions);
		return criteria.list();
	}

}
