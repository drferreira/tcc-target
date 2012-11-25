package org.circle.target.web.views;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.circle.target.business.exceptions.InvalidLoginException;
import org.circle.target.business.exceptions.UserNotAvailable;
import org.circle.target.business.factorys.PersonalDataFactory;
import org.circle.target.business.factorys.SecurityDataFactory;
import org.circle.target.business.services.AuthenticationService;
import org.circle.target.business.services.UserService;
import org.circle.target.web.events.ExceptionMessageEvent;
import org.circle.target.web.qualifiers.ExceptionMessages;

@Named
@SessionScoped
public class CreationUserView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String CREATION_SUCCESS = "CREATION_SUCCESS";
	private static final String CREATION_FAILURE = "CREATION_FAILURE";

	private String email;
	private String password;
	private String rePassword;
	private String firstName;
	private String lastName;
	private Date birthday;

	@Inject
	@ExceptionMessages
	private Event<ExceptionMessageEvent> eventExceptionMessage;
	@EJB
	private UserService userService;
	@EJB
	private AuthenticationService authenticationService;

	/**
	 * Method accessed by XHTML responsible for creating a New User in the
	 * system. Uses UserService service. When the User is not available and
	 * raises the event ExceptionMessageEvent screen displays an error message.
	 * 
	 * @return
	 * @throws InvalidLoginException
	 */
	public String createUser() throws InvalidLoginException {
		SecurityDataFactory securityDataFactory = new SecurityDataFactory();
		PersonalDataFactory personalDataFactory = new PersonalDataFactory();

		try {
			userService.createNewUser(securityDataFactory.createBasic(email, password),
					personalDataFactory.createBasic(birthday.getTime(), firstName, lastName));

			authenticationService.authenticationLoginUser(password, email);

			return CREATION_SUCCESS;
		} catch (UserNotAvailable e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));

			return CREATION_FAILURE;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
