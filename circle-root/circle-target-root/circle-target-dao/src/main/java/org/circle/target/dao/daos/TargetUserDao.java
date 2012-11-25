package org.circle.target.dao.daos;

import java.util.List;

import javax.ejb.Local;

import org.circle.target.dao.entities.PersonalData;
import org.circle.target.dao.entities.SecurityData;
import org.circle.target.dao.entities.TargetUser;

@Local
public interface TargetUserDao {

	TargetUser fetchtBySecurityData(SecurityData securityData);

	List<TargetUser> getAllUsers();

	void updateUser(TargetUser targetUser);

	void saveNewUser(TargetUser targetUser);

	List<TargetUser> fetchByPersonalData(PersonalData personalData);

}
