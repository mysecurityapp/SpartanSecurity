package com.app.service;

import java.text.ParseException;
import java.util.List;


import com.app.pojos.Guest;

import com.app.pojos.GuestEntry;
import com.app.pojos.Owner;
import com.app.pojos.Security;
import com.app.pojos.Suppliers;
import com.app.pojos.Vehicle;




public interface ISecurityService {
	Owner validateOwners(String email,String password);
	Security validateSecuritys(String email,String password);
	String registerSecurites(Security v);
	Security getSecurityDetails(int id);
	List<Security> listSecurity();
	String updateSecuirty(Security v);
	String registerOwner(Owner v);
	Owner getOwnerDetails(int id);
	String updateOwner(Owner v);
	List<Owner> listOwner();
	String registerVehicle(Vehicle v);
	List<Vehicle> listVehicle();

	List<Vehicle> ownersVehicle(int id);
	List<GuestEntry> VisitorsDetails(String flat_no);
	List<GuestEntry> VisitorsDetailsByDate(String date,String flatno) throws ParseException;
	List<GuestEntry> AllVisitorsDetailsBetweenDate(String date,String date2) throws ParseException;
	String registerGuest(Guest g);
	String registerGuestEntry(GuestEntry g);
	String checkOut(String mobNo);

	
	String registerGuestbyOwner(Guest v);
	List<Suppliers> listSuppliers(String role);
	
	
	Guest GetGuestDetail(String MobileNo);
	
	String registerSuppliers(Suppliers v);
}
