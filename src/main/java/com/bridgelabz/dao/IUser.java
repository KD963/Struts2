package com.bridgelabz.dao;

import com.bridglabz.model.User;

public interface IUser {
	void register(User user);
	boolean login(User user);
	boolean forget(User user);
	boolean reset(User user);
	

	

}
