package com.app.dao;

import com.app.pojos.Owner;
import com.app.pojos.Security;

public interface ISecurity {
	Owner validateOwner(String email,String password);
	Security validateSecurity(String email,String password);
}
