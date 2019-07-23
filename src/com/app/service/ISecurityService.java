package com.app.service;

import java.util.List;

<<<<<<< HEAD
=======
import com.app.pojos.Guest;
>>>>>>> 5da4c1c66535412a4d6d88a6c359540bf3af16b4
import com.app.pojos.GuestEntry;
import com.app.pojos.Owner;
import com.app.pojos.Security;
import com.app.pojos.Vehicle;




public interface ISecurityService {
	Owner validateOwners(String email,String password);
	Security validateSecuritys(String email,String password);
	String registerSecurites(Security v);
	Security getSecurityDetails(int id);
	List<Security> listSecurity();
	String updateSecuirty(Security v);
	String registerOwner(Owner v);
	List<Owner> listOwner();
	String registerVehicle(Vehicle v);
	List<Vehicle> listVehicle();
<<<<<<< HEAD
	List<Vehicle> ownersVehicle(int id);
	List<GuestEntry> VisitorsDetails(String flat_no);
	List<GuestEntry> VisitorsDetailsByDate(String date);
=======
	String registerGuest(Guest g);
	String registerGuestEntry(GuestEntry g);
	String checkOut(String mobNo);
>>>>>>> 5da4c1c66535412a4d6d88a6c359540bf3af16b4
}
