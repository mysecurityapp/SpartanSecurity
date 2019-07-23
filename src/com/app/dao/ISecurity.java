package com.app.dao;

import java.util.Date;
import java.util.List;

<<<<<<< HEAD
=======
import com.app.pojos.Guest;
>>>>>>> 5da4c1c66535412a4d6d88a6c359540bf3af16b4
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
	List<Owner> listOwner();
	String registerVehicle(Vehicle v);
	List<Vehicle> listVehicle();
<<<<<<< HEAD
	List<Vehicle> OwnersVehicle(int id);
	List<GuestEntry> VisitorsDetails(String flat_no);
	List<GuestEntry> VisitorsDetailsByDate(String date);
=======
	String registerGuest(Guest g);
	String registerGuestEntry(GuestEntry g);
	String checkout(String mobileNo);
>>>>>>> 5da4c1c66535412a4d6d88a6c359540bf3af16b4
	
}
