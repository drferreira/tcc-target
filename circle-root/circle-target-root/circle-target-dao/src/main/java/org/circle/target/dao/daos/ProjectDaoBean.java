package org.circle.target.dao.daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.dao.entities.Project;
import org.circle.target.dao.entities.TargetUser;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public @Stateless
class ProjectDaoBean extends GenericDao implements ProjectDao {

	private static final long serialVersionUID = 1L;
	private final Class<Project> entity = Project.class;

	/**
	 * Perform a search for all projects which I am owner.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Project> fetchAllMyProjects(TargetUser targetUser) {
		List<SimpleExpression> listExpressions = new ArrayList<SimpleExpression>();
		listExpressions.add(Restrictions.eq("ownerProject", targetUser));

		Criteria criteria = mountCriteria(entity, listExpressions);
		List<Project> list = (List<Project>) criteria.list();

		return list;
	}

	/**
	 * Persist a new project in the database.
	 * 
	 * @param project
	 */
	@Override
	public void saveNewProject(Project project) {
		save(project);
	}
	
	@Override
	public void updateProject(Project project){
		merge(project);
	}
}
