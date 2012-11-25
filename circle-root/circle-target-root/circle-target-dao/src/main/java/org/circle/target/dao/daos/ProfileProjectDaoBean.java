package org.circle.target.dao.daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.dao.entities.ProfileProject;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@Stateless
public class ProfileProjectDaoBean extends GenericDao implements ProfileProjectDao {

	private static final long serialVersionUID = 1L;
	private final Class<ProfileProject> entity = ProfileProject.class;

	/**
	 * Method responsible for conducting a search for designs using as the name
	 * of the same parameter.
	 * 
	 * @param nameProject
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> fetchByName(String nameProject) {
		List<SimpleExpression> listExpressions = new ArrayList<SimpleExpression>();
		listExpressions.add(Restrictions.eq("nameProject", nameProject));

		Criteria criteria = mountCriteria(entity, listExpressions);
		return criteria.list();
	}
	
	/**
	 * Method responsible for conducting a search for designs using as the name
	 * of the same parameter.
	 * It uses a search approach. Command like.
	 * 
	 * @param nameProject
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> fetchLikeByName(String nameProject){
		List<SimpleExpression> listExpressions = new ArrayList<SimpleExpression>();
		listExpressions.add(Restrictions.eq("nameProject", nameProject+"%"));

		Criteria criteria = mountCriteria(entity, listExpressions);
		return criteria.list();
	}
	
	
}
