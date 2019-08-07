package com.bridglabz.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bridgelabz.dao.UserImpl;
import com.bridglabz.model.User;

@Action(value = "register", results = { @Result(name = "success", location = "/success-register.jsp"),
		@Result(name = "error", location = "error.jsp") })
public class RegisterAction {

	private String name;
	private String email;
	private String password;

	public RegisterAction() {

	}

	public RegisterAction(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String execute() {
		User user = new User(name, email, password);
		UserImpl userImpl = new UserImpl();
		userImpl.register(user);
		return "success";
	}
}
