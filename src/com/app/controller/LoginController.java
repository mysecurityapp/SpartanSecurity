package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.ISecurityService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private ISecurityService sf;
	
	public LoginController() {
		System.out.println("IN Login Constructor");
	}
	
	@GetMapping("/form")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

}
