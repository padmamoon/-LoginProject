package com.hcl.dao;

import com.hcl.model.Login;
import com.hcl.model.User;

public interface UserDao {
	int register(User user);

	User validateUser(Login login);

}
