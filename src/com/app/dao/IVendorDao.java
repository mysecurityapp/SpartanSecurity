package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	Vendor validateUser(String email,String pass);
	List<Vendor> getVendorDetails();
	Vendor deleteVendor(int id);
	String registerVendor(Vendor v);
	String deleteVendorDetails(Vendor v);
	String updateVendorDetails(Vendor v);
	Vendor getVendorDetails(int vid);
	
}
