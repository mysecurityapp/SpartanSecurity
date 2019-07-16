package com.app.service;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorService {
	
	Vendor validateUser(String email,String pass);
	List<Vendor> listVendors();
	String registerVendor(Vendor v);
	Vendor deleteVendor(int id);
	String deleteVendors(int vid);
	Vendor getVendorDetails(int id);
	String updateVendor(Vendor v);

}
