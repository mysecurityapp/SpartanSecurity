package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Owner;

import com.app.pojos.Vehicle;
import com.app.service.ISecurityService;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private ISecurityService sf;
	
	public OwnerController() {
		System.out.println("IN Owner Constructor");
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	// req handling method to process login form
	@PostMapping("/login") // =@RequestMapping + method=post
	public String processLoginForm(Model map, 
			@RequestParam String email,
			@RequestParam String password,
			HttpSession hs) {
		System.out.println("in process login form");
		try {
			// invoke service layer method
			Owner v = sf.validateOwners(email, password);
			// login success
			map.addAttribute("status", "Login Successful....");
			// store user details under session scope
			hs.setAttribute("user_dtls", v);
			// chk role
			if (v.getRole().equals("Admin")) // admin login
			{
					return "redirect:/admins/Adportal";//replace by redirect
			}
			// vendor login
			return "/owner/OwnersPortal";
		} catch (RuntimeException e) {
			System.out.println("err in user controller " + e);
			// invalid login
			// add err mesg as model attribute ---req scope
			map.addAttribute("status", "Invalid Login , Pls retry!!!!");
			e.printStackTrace();
			return "/user/login";
		}
		
		
		
		}
	@GetMapping("/vehicle")
	public String showVechileForm(Vehicle V) {
		System.out.println("in vehicle login form");
		return "/owner/vehicleReg";
	}
	
	
	
	@PostMapping("/vehicle") // =@RequestMapping + method=post
	public String processRegisterForm(Vehicle v,RedirectAttributes flashMap,HttpSession hs) {
		
		
		Owner own=(Owner) hs.getAttribute("user_dtls");
		Vehicle sc=new Vehicle(v.getVehicle_no(),v.getVehicle_type(),own);
		
		System.out.println("in process registration form"+v);
		//v--transient
		flashMap.addFlashAttribute("status", sf.registerVehicle(sc));
		return "redirect:/owner/vehicle";

	}
	

}
