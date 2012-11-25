package org.circle.target.dao.daos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.circle.target.dao.entities.SecurityData;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@Stateless
public class SecurityDataDaoBean extends GenericDao implements SecurityDataDao {

	private static final long serialVersionUID = 1L;
	private final Class<SecurityData> entity = SecurityData.class;

	/**
	 * Method responsible for conducting a search through the basic components
	 * of a User Authentication.
	 * 
	 * @param password
	 *            :
	 * @param email
	 *            :
	 * @return
	 */
	@Override
	public Object fetchtBySequenceAuthentication(String password, String email) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("password", password));
		expressions.add(Restrictions.eq("email", email));

		Criteria criteria = mountCriteria(entity, expressions);
		return criteria.uniqueResult();
	}

	/**
	 * Method responsible for conducting a search of a date using security as a
	 * criterion the mail.
	 * 
	 */
	@Override
	public SecurityData fetchByEmail(String email) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("email", email));

		Criteria criteria = mountCriteria(entity, expressions);
		return (SecurityData) criteria.uniqueResult();
	}

	/**
	 * Method responsible for conducting a search of a date using security as a
	 * criterion the mail. Uses the argument "like" to search for approximation.
	 * 
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public List<SecurityData> fetchLikeByEmail(String emailUser) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("email", emailUser+"%"));

		Criteria criteria = mountCriteria(entity, expressions);
		return criteria.list();
	}
}
