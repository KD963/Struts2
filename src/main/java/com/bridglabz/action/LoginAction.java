package com.bridglabz.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bridgelabz.dao.UserImpl;
import com.bridglabz.model.User;
import com.sun.org.apache.regexp.internal.recompile;

@Action(value = "login", results = { @Result(name = "success", location = "/success-login.jsp"),
		@Result(name = "error", location = "/error.jsp") })
public class LoginAction {

	private String email;
	private String password;

	public LoginAction() {

	}

	public LoginAction(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "LoginAction [email=" + email + ", password=" + password + "]";
	}

	public String execute() {
		User user = new User();
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		
		UserImpl userImpl = new UserImpl();

		if (userImpl.login(user)) {
			return "success";
		} else {
			return "error";
		}

	}

}
