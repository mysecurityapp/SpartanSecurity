package com.app.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.GuestEntry;
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
	
	@GetMapping("/Ownersvehicle")
	public String showOwnersVehicle(Model map,HttpSession hs) {
		System.out.println("in owners vehicle control");
		Owner own=(Owner) hs.getAttribute("user_dtls");
		int ownID=own.getOwner_id();
		map.addAttribute("vehicle_owner", sf.ownersVehicle(ownID));
		
		return "/owner/OwnersVehicle";
		
	}
	
	
	@GetMapping("/OwnersVisitors")
	public String showOwnersVisitors(Model map,HttpSession hs) {
		System.out.println("in owners visitor control");
		Owner own=(Owner) hs.getAttribute("user_dtls");
		String flatno=own.getFlat_no();
		map.addAttribute("visitor_owner", sf.VisitorsDetails(flatno));
		
		return "/owner/visitorsDetailsOfOwner";
		
	}
	
	@GetMapping("/ReportByDate")
	public String showDateForm(GuestEntry v) {
		System.out.println("in list ReportByDate");
		
		
		return "/owner/GuestRetrivalByDate"; // forward view name
	}
	
	@PostMapping("/ReportByDate") // =@RequestMapping + method=post
	public String showVisitorsBydate(GuestEntry v,RedirectAttributes flashMap,HttpSession hs) {
		System.out.println("in post ReportByDate");
		
		Owner own=(Owner) hs.getAttribute("user_dtls");
		Date sc=v.getIn_Time();
		  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");  
          String strDate = dateFormat.format(sc);  
          System.out.println("Converted String: " + strDate);  
		
		System.out.println("in process registration form"+v);
		//v--transient
		flashMap.addFlashAttribute("status", sf.VisitorsDetailsByDate(strDate));
		return "/owner/VisitorBydate";

	}
	
	
	
	
	

}
