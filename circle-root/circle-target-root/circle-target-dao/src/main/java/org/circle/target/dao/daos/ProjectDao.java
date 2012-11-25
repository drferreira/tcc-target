package org.circle.target.dao.daos;

import java.util.List;

import javax.ejb.Local;

import org.circle.target.dao.entities.Project;
import org.circle.target.dao.entities.TargetUser;

@Local
public interface ProjectDao {

	List<Project> fetchAllMyProjects(TargetUser targetUser);

	void saveNewProject(Project project);

	void updateProject(Project project);

}
