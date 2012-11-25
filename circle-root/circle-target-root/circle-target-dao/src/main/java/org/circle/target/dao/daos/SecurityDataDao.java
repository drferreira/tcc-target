package org.circle.target.dao.daos;

import java.util.List;

import javax.ejb.Local;

import org.circle.target.dao.entities.SecurityData;

@Local
public interface SecurityDataDao {



	List<SecurityData> fetchLikeByEmail(String emailUser);

	SecurityData fetchByEmail(String email);

	Object fetchtBySequenceAuthentication(String password, String email);


}
