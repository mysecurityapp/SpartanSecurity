package com.app.dao;

import java.util.List;

import com.app.pojos.Owner;
import com.app.pojos.Security;




public interface ISecurity {
	Owner validateOwner(String email,String password);
	Security validateSecurity(String email,String password);
	String registerSecurity(Security v);
	Security getSecurityDetails(int vid);
	List<Security> listSecurity();
	String updateSecurityDetails(Security v);
	String registerOwner(Owner v);
	List<Owner> listOwner();
	
}
