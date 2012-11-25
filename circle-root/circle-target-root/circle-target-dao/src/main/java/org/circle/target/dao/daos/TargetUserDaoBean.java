package org.circle.target.dao.daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.dao.entities.PersonalData;
import org.circle.target.dao.entities.SecurityData;
import org.circle.target.dao.entities.TargetUser;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@Stateless
public class TargetUserDaoBean extends GenericDao implements TargetUserDao {

	private static final long serialVersionUID = 1L;
	private final Class<TargetUser> targetUser = TargetUser.class;

	@Override
	public void saveNewUser(TargetUser targetUser) {
		save(targetUser);
	}

	@Override
	public void updateUser(TargetUser targetUser) {
		update(targetUser);
	}

	/**
	 * Method responsible for searching for all existing users in the database.
	 * 
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<TargetUser> getAllUsers() {
		return createCriteria(targetUser).list();
	}

	/**
	 * Search a User using as a reference your data security. Returns a single
	 * result.
	 * 
	 * @param securityData
	 *            : Need a managed object.
	 * @return
	 */
	@Override
	public TargetUser fetchtBySecurityData(SecurityData securityData) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("securityData", securityData));

		Criteria criteria = mountCriteria(targetUser, expressions);
		return (TargetUser) criteria.uniqueResult();
	}
	
	/**
	 * Method responsible for fetching a list of "Target User" from a
	 * "personal data".
	 * 
	 * @param personalData
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<TargetUser> fetchByPersonalData(PersonalData personalData) {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("personalData", personalData));

		Criteria criteria = mountCriteria(targetUser, expressions);
		return criteria.list();
	}
}
