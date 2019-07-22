package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Guest;
import com.app.pojos.GuestEntry;
import com.app.pojos.Security;
import com.app.pojos.Vendor;
import com.app.service.ISecurityService;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	@Autowired
	private ISecurityService service;

	public SecurityController() {
		System.out.println("in def constr of " + getClass().getName());
	}

	// req handling method to show login form
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
			Security v = service.validateSecuritys(email, password);
			// login success
			map.addAttribute("status", "Login Successful....");
			// store user details under session scope
			hs.setAttribute("sec_dtls", v);
			// chk role
			
			// vendor login
			return "/security/dashboard";
		} catch (RuntimeException e) {
			System.out.println("err in user controller " + e);
			// invalid login
			// add err mesg as model attribute ---req scope
			map.addAttribute("status", "Invalid Login , Pls retry!!!!");
			e.printStackTrace();
			return "/user/login";
		}
		

	}
	
	

	@GetMapping("/register")
	public String showRegistrationForm() {
		//Vendor v=new Vendor();
		//SC will invoke getters to bind POJO data to form
		//map.addAttribute("vendor",v); //derived name
		System.out.println("in show registr form");
		
		return "/security/register";  //forward to reg form
	}
	
	@GetMapping("/checkout")
	public String checkout() {
		//Vendor v=new Vendor();
		//SC will invoke getters to bind POJO data to form
		//map.addAttribute("vendor",v); //derived name
		System.out.println("in show registr form");
		
		return "/security/checkout";  //forward to reg form
	}
	@PostMapping("/checkout") // =@RequestMapping + method=post
	public String processCheckOut(Model map
			, 
			@RequestParam String mobile,
			HttpSession hs,RedirectAttributes flashMap
			) {
		System.out.println("in register guest");
		
		try {
		service.checkOut(mobile);
		map.addAttribute("checkout", "Guest checked out successfully");
			
			return "/security/checkout";
		} catch (RuntimeException e) {
			System.out.println("err in user controller " + e);
			// invalid login
			// add err mesg as model attribute ---req scope
			map.addAttribute("checkout", "Guest is not registered..!!");
			e.printStackTrace();
			return "/security/checkout";
		}
		

	}
	
	@GetMapping("/dashboard")
	public String showDashboard() {
		//Vendor v=new Vendor();
		//SC will invoke getters to bind POJO data to form
		//map.addAttribute("vendor",v); //derived name
		System.out.println("in show registr form");
		
		return "/security/dashboard";  //forward to reg form
	}
	
	@PostMapping("/register") // =@RequestMapping + method=post
	public String processRegistrationForm(Model map
			, 
			@RequestParam String fname,
			@RequestParam String lname,
			@RequestParam String email,
			@RequestParam String mobile,
			@RequestParam String address,
//			@RequestParam Date inTime,
//			@RequestParam Date outTime,
			@RequestParam String vehicleNo,
			@RequestParam String flatNo,
			HttpSession hs,RedirectAttributes flashMap
			) {
		System.out.println("in register guest");
		
		try {
			// invoke service layer method
			Security s = (Security) hs.getAttribute("sec_dtls");
			Guest guest = new Guest(mobile, fname, lname, address, email, s);
			Date date=new Date();
			System.out.println("date::"+date);
			GuestEntry g=new GuestEntry(vehicleNo, date, date, s , flatNo, guest);
			flashMap.addFlashAttribute("status", service.registerGuest(guest));
			flashMap.addFlashAttribute("sts", service.registerGuestEntry(g));
			// login success
			
			// store user details under session scope
			
			// chk role
			
			// vendor login
			
			return "redirect:/security/dashboard";
		} catch (RuntimeException e) {
			System.out.println("err in user controller " + e);
			// invalid login
			// add err mesg as model attribute ---req scope
			map.addAttribute("status", "Invalid Login , Pls retry!!!!");
			e.printStackTrace();
			return "/user/login";
		}
		

	}
	@PostMapping("/add") // =@RequestMapping + method=post
	public String processRegisterForm(Guest g,RedirectAttributes flashMap) {
		//Vendor v = new Vendor();
		//invokes matching setters(req param names--path--MUST match with
		//POJO prop names.)
		
		System.out.println("in process registration form"+g);
		//v--transient
		//flashMap.addFlashAttribute("status", service(v));
		return "redirect:/admin/list";

	}
	
	
	
	
	
	
	// req handling method for user log out
	@GetMapping("/logout")
	public String userLogout(HttpSession hs,Model map,
			HttpServletRequest request,HttpServletResponse response) {
		System.out.println("in user logout");
		//save user dtls from session scope ---> request scope
		map.addAttribute("dtls",hs.getAttribute("user_dtls"));
		//invalidate user's session
		hs.invalidate();
		//navigate the clnt to index page after slight dly
		response.setHeader("refresh", 
				"5;url="+request.getContextPath());
		return "/user/logout";
	}

}
