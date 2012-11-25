package org.circle.target.web.views;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import org.circle.target.business.exceptions.InvalidLoginException;
import org.circle.target.business.services.AuthenticationService;
import org.circle.target.web.events.ExceptionMessageEvent;
import org.circle.target.web.qualifiers.ExceptionMessages;

@Named
@SessionScoped
public class LoginView implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
	private static final String LOGIN_FAILURE = "LOGIN_FAILURE";

	private String email;
	private String password;

	@EJB private AuthenticationService authenticationService;
	@Inject	@ExceptionMessages private Event<ExceptionMessageEvent> eventExceptionMessage;

	/**
	 * Method responsible for logging in to a User. If the exception is
	 * triggered InvalidLoginException will start an event of type Event
	 * <b><ExceptionMessageEvent></b>
	 */
	public String login() {
		try {
			authenticationService.authenticationLoginUser(password, email);

			return LOGIN_SUCCESS;
		} catch (InvalidLoginException e) {
			eventExceptionMessage.fire(new ExceptionMessageEvent(e));

			return LOGIN_FAILURE;
		}
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public Event<ExceptionMessageEvent> getEventExceptionMessage() {
		return eventExceptionMessage;
	}

	public void setEventExceptionMessage(Event<ExceptionMessageEvent> eventExceptionMessage) {
		this.eventExceptionMessage = eventExceptionMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
}
