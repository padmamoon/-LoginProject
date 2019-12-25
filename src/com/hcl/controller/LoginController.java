package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Login;
import com.hcl.model.User;
import com.hcl.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView showLogin()
	{
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("login", new Login());
		return mv;
	}
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("login") Login login)
	{
		ModelAndView mv = null;
		
		User user = userService.validateUser(login);
		
		if(null!=user)
		{
			mv = new ModelAndView("welcome");
			mv.addObject("firstname",user.getFirstname());
		}
		else
		{
			mv = new ModelAndView("login");
			mv.addObject("message", "Username and Password is wrong..!!!");
		}
		return mv;
	}
}
