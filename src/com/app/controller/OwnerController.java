package com.app.controller;

import java.text.DateFormat;
import java.text.ParseException;
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

import com.app.pojos.Guest;
import com.app.pojos.GuestEntry;
import com.app.pojos.Owner;
import com.app.pojos.Suppliers;
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
		return "redirect:/owner/Ownersvehicle";

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
	public String showVisitorsBydate(GuestEntry v,Model Map,HttpSession hs) throws ParseException {
		System.out.println("in post ReportByDate");
		
		Owner own=(Owner) hs.getAttribute("user_dtls");
		String flat_no=own.getFlat_no();
		Date sc=v.getIn_Time();
		  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");  
          String strDate = dateFormat.format(sc);  
          System.out.println("Converted String: " + strDate);  
		
	
		//v--transient
		Map.addAttribute("visitor_details_Bydate", sf.VisitorsDetailsByDate(strDate,flat_no));
		return "/owner/VisitorBydate";

	}
	
	
	
	@GetMapping("/RegGuest")
	public String showRegGuestForm(Guest V) {
		System.out.println("in guest form");
		return "/owner/guestReg";
	}
	
	
	
	@PostMapping("/RegGuest") // =@RequestMapping + method=post
	public String processRegGuestForm(Guest v,RedirectAttributes flashMap,HttpSession hs) {
		
		
		Owner own=(Owner) hs.getAttribute("user_dtls");
		Guest sc=new Guest(v.getMobile_num(),v.getFirst_name(),v.getLast_name(),v.getAddress(),v.getEmail(),own,own.getOwner_id());
		
		System.out.println("in process registration form"+v);
		//v--transient
		flashMap.addFlashAttribute("status", sf.registerGuestbyOwner(sc));
		return "/owner/OwnersPortal";

	}
	
	
	@GetMapping("/suppliers")
	public String showSelectionOfsuppliers(Suppliers v ) {
		
		
		return "/owner/SelectVendor";
		
	}
	
	@PostMapping("/suppliers") // =@RequestMapping + method=post
	public String processListSuppliersForm(Suppliers v,Model Map,HttpSession hs) {
		
		
		Owner own=(Owner) hs.getAttribute("user_dtls");
		String roll=v.getRole();
		System.out.println("in process registration form"+v);
		//v--transient
		Map.addAttribute("status", sf.listSuppliers(roll));
		return "/owner/listVendor";

	}
	
	

}
