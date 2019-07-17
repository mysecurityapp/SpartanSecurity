package com.app.service;

import com.app.pojos.Owner;
import com.app.pojos.Security;

public interface ISecurityService {
	Owner validateOwners(String email,String password);
	Security validateSecuritys(String email,String password);

}
