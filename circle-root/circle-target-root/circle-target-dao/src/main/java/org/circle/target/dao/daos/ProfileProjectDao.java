package org.circle.target.dao.daos;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ProfileProjectDao {

	List<Object> fetchByName(String nameProject);

	List<Object> fetchLikeByName(String nameProject);

}
