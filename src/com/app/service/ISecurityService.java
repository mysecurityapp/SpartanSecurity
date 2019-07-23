package com.app.service;

import java.util.List;

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
	List<Vehicle> ownersVehicle(int id);
	List<GuestEntry> VisitorsDetails(String flat_no);
	List<GuestEntry> VisitorsDetailsByDate(String date);
}
