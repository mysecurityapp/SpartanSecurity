package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IVendorService service;

	public AdminController() {
		System.out.println("in constr of " + getClass().getName());
	}
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int vid,Model map)
	{
	System.out.println("in show get form");
	map.addAttribute("vendor",service.getVendorDetails(vid));
	System.out.println(map);
	return "/admin/update";
	}
	
	@PostMapping("/update")
	public String processUpdateForm(Vendor v,RedirectAttributes flashMap)
	{
	System.out.println("in process update form");
	flashMap.addFlashAttribute("status", service.updateVendor(v));
	
	return "redirect:/admin/list";
	}

	@GetMapping("/list")
	public String showVendorList(Model map) {
		System.out.println("in list vendor");
		// save vendor under model map
		map.addAttribute("vendor_list", service.listVendors());
		return "/admin/list"; // forward view name
	}

	@GetMapping("/add")
	public String showRegistrationForm(Vendor v) {
		//Vendor v=new Vendor();
		//SC will invoke getters to bind POJO data to form
		//map.addAttribute("vendor",v); //derived name
		System.out.println("in show registr form"+v);
		
		return "/admin/register";  //forward to reg form
	}

	@PostMapping("/add") // =@RequestMapping + method=post
	public String processRegisterForm(Vendor v,RedirectAttributes flashMap) {
		//Vendor v = new Vendor();
		//invokes matching setters(req param names--path--MUST match with
		//POJO prop names.)
		
		System.out.println("in process registration form"+v);
		//v--transient
		flashMap.addFlashAttribute("status", service.registerVendor(v));
		return "redirect:/admin/list";

	}

	@GetMapping("/delete")
	public String deleteVendor(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in delete vendor" + vid);

		flashMap.addFlashAttribute("status", service.deleteVendor(vid));

		return "redirect:/admin/list";
	}

}
