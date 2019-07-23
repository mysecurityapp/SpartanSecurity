package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISecurity;
import com.app.pojos.GuestEntry;
import com.app.pojos.Owner;
import com.app.pojos.Security;
import com.app.pojos.Vehicle;

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

	@Override
	public String registerSecurites(Security v) {
		// TODO Auto-generated method stub
		return dao.registerSecurity(v);
	}

	@Override
	public Security getSecurityDetails(int id) {
		// TODO Auto-generated method stub
		return dao.getSecurityDetails(id);
	}

	@Override
	public List<Security> listSecurity() {
		// TODO Auto-generated method stub
		return dao.listSecurity();
	}

	@Override
	public String updateSecuirty(Security v) {
		// TODO Auto-generated method stub
		return dao.updateSecurityDetails(v);
	}

	@Override
	public String registerOwner(Owner v) {
		// TODO Auto-generated method stub
		return dao.registerOwner(v);
	}

	@Override
	public List<Owner> listOwner() {
		// TODO Auto-generated method stub
		return dao.listOwner();
	}

	@Override
	public String registerVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		return dao.registerVehicle(v);
	}

	@Override
	public List<Vehicle> listVehicle() {
		System.out.println("in vehicle list service");
		// TODO Auto-generated method stub
		return dao.listVehicle();
	}

	@Override
	public List<Vehicle> ownersVehicle(int id) {
		// TODO Auto-generated method stub
		return dao.OwnersVehicle(id);
	}

	@Override
	public List<GuestEntry> VisitorsDetails(String flat_no) {
		return dao.VisitorsDetails(flat_no);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GuestEntry> VisitorsDetailsByDate(String date) {
		// TODO Auto-generated method stub
		return dao.VisitorsDetailsByDate(date);
	}



	
	
	
	}


