package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.ISecurityService;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private ISecurityService sf;
	
	public OwnerController() {
		System.out.println("IN Owner Constructor");
	}
	
	

}
