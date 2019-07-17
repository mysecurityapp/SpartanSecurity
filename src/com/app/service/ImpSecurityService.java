package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISecurity;
import com.app.pojos.Owner;
import com.app.pojos.Security;
@Service
@Transactional
public class ImpSecurityService implements ISecurityService{

	@Autowired
	private ISecurity dao;

	@Override
	public Owner validateOwners(String email, String password) {
		// TODO Auto-generated method stub
		return dao.validateOwner(email, password);
	}

	@Override
	public Security validateSecuritys(String email, String password) {
		// TODO Auto-generated method stub
		return dao.validateSecurity(email, password);
	}

	
	
	
	}


