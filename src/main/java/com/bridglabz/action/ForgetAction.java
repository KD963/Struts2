package com.bridglabz.action;

import java.util.Map;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.bridgelabz.dao.UserImpl;
import com.bridglabz.model.User;

@Action(value = "forget", results = { @Result(name = "success", location = "/success-forget.jsp"),
		@Result(name = "error", location = "/error.jsp") })
public class ForgetAction implements SessionAware {

	String email;

	private Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public ForgetAction() {

	}

	public ForgetAction(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String execute() {
		System.out.println("inside execute");
		User user = new User();
		user.setEmail(getEmail());
		UserImpl userImpl = new UserImpl();

		if (userImpl.forget(user)) {
			session.put("email", email);
			return "success";
		} else {
			return "error";
		}
	}

}
