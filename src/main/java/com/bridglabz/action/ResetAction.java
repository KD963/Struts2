package com.bridglabz.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bridgelabz.dao.UserImpl;
import com.bridglabz.model.User;

@Action(value = "reset", results = { @Result(name = "success", location = "/success-reset.jsp"),
		@Result(name = "error", location = "/error.jsp") })
public class ResetAction {

	String password;
	HttpSession session = ServletActionContext.getRequest().getSession(false);

	public ResetAction() {

	}

	public ResetAction(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() {
		User user = new User();
		user.setPassword(getPassword());
		String email = (String) session.getAttribute("email");
		user.setEmail(email);
		UserImpl userImpl = new UserImpl();

		if (userImpl.reset(user)) {
			return "success";
		} else {
			return "error";
		}
	}

}
