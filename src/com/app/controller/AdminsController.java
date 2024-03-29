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

import com.app.pojos.GuestEntry;
import com.app.pojos.Owner;
import com.app.pojos.Security;

import com.app.service.ISecurityService;

@Controller
@RequestMapping("/admins")
public class AdminsController {
	
	@Autowired
	private ISecurityService sf;
	
	public AdminsController() {
		System.out.println("IN Login Constructor");
	}
	
	

	@GetMapping("/Adportal")
	public String showAdminPortal(Model map) {
		System.out.println("admins portal");
		// save vendor under model map
		
		return "/admin/adminsPortal"; // forward view name
	}
	
	@GetMapping("/add")
	public String showRegistrationForm(Security v) {
		//Vendor v=new Vendor();
		//SC will invoke getters to bind POJO data to form
		//map.addAttribute("vendor",v); //derived name
		System.out.println("in show registr form"+v);
		
		return "/admin/registering";  //forward to reg form
	}

	
	@PostMapping("/add") // =@RequestMapping + method=post
	public String processRegisterForm(Security v,RedirectAttributes flashMap,HttpSession hs) {
		
		
		Owner own=(Owner) hs.getAttribute("user_dtls");
		Security sc=new Security(v.getFirst_name(),v.getLast_name(),v.getAddress(),v.getMobile_numb(),v.getPassword(),v.getEmail(),own,own.getOwner_id());
		
		System.out.println("in process registration form"+v);
		//v--transient
		flashMap.addFlashAttribute("status", sf.registerSecurites(sc));
		
		return "redirect:/admins/list";

	}
	
	@GetMapping("/list")
	public String showSecurityList(Model map) {
		System.out.println("in list security");
		
		map.addAttribute("vendor_list", sf.listSecurity());
		return "/security/SecurityDetails"; // forward view name
	}
	
	@GetMapping("/updateSec")
	public String showUpdateForm(@RequestParam int vid,Model map)
	{
	System.out.println("in show get form");
	map.addAttribute("security",sf.getSecurityDetails(vid));
	//System.out.println(map);
	return "/security/updateSecForm";
	}
	
	@PostMapping("/updateSec")
	public String processUpdateForm(Security v,RedirectAttributes flashMap)
	{
	System.out.println("in process update form");
	flashMap.addFlashAttribute("status", sf.updateSecuirty(v));
	
	return "redirect:/admins/list";
	}
	
	
	
	
	@GetMapping("/addOwner")
	public String showOwnersRegistrationForm(Owner v) {
		//Vendor v=new Vendor();
		//SC will invoke getters to bind POJO data to form
		//map.addAttribute("vendor",v); //derived name
		System.out.println("in show registr form"+v);
		
		return "/owner/registerForm";  //forward to reg form
	}

	
	@PostMapping("/addOwner") // =@RequestMapping + method=post
	public String processOwnersRegisterForm(Owner v,RedirectAttributes flashMap,HttpSession hs) {
		
		
		
		
		
		System.out.println("in process registration form"+v);
		//v--transient
		flashMap.addFlashAttribute("status", sf.registerOwner(v));
		return "redirect:/admins/listOwner";

	}
	
	
	
	
	@GetMapping("/listOwner")
	public String showOwnerList(Model map) {
		System.out.println("in list vendor");
		
		map.addAttribute("vendor_list", sf.listOwner());
		
		return "/owner/ownerDetails"; 
	}
	
	
	@GetMapping("/updateOwn")
	public String showUpdateFormOfOwner(@RequestParam int vid,Model map)
	{
	System.out.println("in show get form");
	map.addAttribute("owner",sf.getOwnerDetails(vid));
	//System.out.println(map);
	return "/owner/updateOwnForm";
	}
	
	@PostMapping("/updateOwn")
	public String processUpdateOwnForm(Owner v,RedirectAttributes flashMap)
	{
	System.out.println("in process update form");
	flashMap.addFlashAttribute("status", sf.updateOwner(v));
	
	return "redirect:/admins/listOwner";
	}
	
	
	
	

	@GetMapping("/listVehicle")
	public String showVehicleList(Model map) {
		System.out.println("in list Vehicle");
		
		map.addAttribute("vehicle_list", sf.listVehicle());

		return "/admin/vehicleDetails";

	}
	
	@GetMapping("/ReportBetweenDate")
	public String showDateForm(GuestEntry v) {
		System.out.println("in list ReportBetweenDate");
		
		
		return "/admin/GuestReportBetweenDate"; // forward view name
	}
	
	@PostMapping("/ReportBetweenDate") // =@RequestMapping + method=post
	public String showVisitorsBydate(GuestEntry v,Model Map,HttpSession hs) throws ParseException {
		System.out.println("in post ReportByDate");
		
		Owner own=(Owner) hs.getAttribute("user_dtls");
		
		Date sc=v.getIn_Time();
		Date sc2=v.getOut_Time();
		  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");  
          String strDate = dateFormat.format(sc);  
          String strDate1 = dateFormat.format(sc2);
          System.out.println("Converted String: " + strDate);  
		
	
		//v--transient
		Map.addAttribute("visitor_details_Bydate", sf.AllVisitorsDetailsBetweenDate(strDate, strDate1));
		return "/owner/VisitorBydate";

	}
	
	
	
	
	
}
