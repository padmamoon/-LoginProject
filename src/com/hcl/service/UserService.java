package com.hcl.service;

import com.hcl.model.Login;
import com.hcl.model.User;

public interface UserService {
	int register(User user); 
	   User validateUser(Login login); 
	
} 

