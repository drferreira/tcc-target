package org.circle.target.dao.daos;

import java.util.List;
import javax.ejb.Local;
import org.circle.target.dao.entities.PersonalData;

@Local
public interface PersonalDataDao {

	List<PersonalData> fetchLikeFirstName(String firstName);

	List<PersonalData> fetchLikeLastName(String lastName);



}
