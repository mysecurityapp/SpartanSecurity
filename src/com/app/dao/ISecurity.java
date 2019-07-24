package com.app.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


import com.app.pojos.Guest;

import com.app.pojos.GuestEntry;
import com.app.pojos.Owner;
import com.app.pojos.Security;
import com.app.pojos.Vehicle;




public interface ISecurity {
	Owner validateOwner(String email,String password);
	Security validateSecurity(String email,String password);
	String registerSecurity(Security v);
	Security getSecurityDetails(int vid);
	List<Security> listSecurity();
	String updateSecurityDetails(Security v);
	String registerOwner(Owner v);
	String updateOwnerDetails(Owner v);
	Owner getOwnerDetails(int vid);
	List<Owner> listOwner();
	String registerVehicle(Vehicle v);
	List<Vehicle> listVehicle();

	List<Vehicle> OwnersVehicle(int id);
	List<GuestEntry> VisitorsDetails(String flat_no);
	List<GuestEntry> VisitorsDetailsByDate(String date,String flatno) throws ParseException;
	List<GuestEntry> AllVisitorsDetailsBtweenDate(String date,String date2) throws ParseException;
	String registerGuest(Guest g);
	String registerGuestEntry(GuestEntry g);
	String checkout(String mobileNo);

	
}
