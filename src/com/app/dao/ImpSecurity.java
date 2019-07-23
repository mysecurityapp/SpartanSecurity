package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.GuestEntry;
import com.app.pojos.Owner;
import com.app.pojos.Security;
import com.app.pojos.Vehicle;



@Repository
public class ImpSecurity implements ISecurity {
	
	@Autowired
	SessionFactory sf;
	
	@Override
	public Owner validateOwner(String email, String password) {
		String jpql="select v from Owner v where v.email=:em and v.password=:ps";
		return sf.getCurrentSession().createQuery(jpql,Owner.class)
				.setParameter("em", email).setParameter("ps", password)
				.getSingleResult();
	}

	@Override
	public Security validateSecurity(String email, String password) {
		String jpql="select v from Security v where v.email=:em and v.password=:ps";
		return sf.getCurrentSession().createQuery(jpql,Security.class)
				.setParameter("em", email).setParameter("ps", password)
				.getSingleResult();
	}

	@Override
	public String registerSecurity(Security v) {
		sf.getCurrentSession().persist(v); //persistent
		//	sf.getCurrentSession().save(v);
			return "Security detials inserted for id"+v.getId();
	}

	@Override
	public Security getSecurityDetails(int vid) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Security.class, vid);
	}

	@Override
	public List<Security> listSecurity() {
		String jpql = "select v from Security v";
		return sf.getCurrentSession().createQuery(jpql,Security.class)
		.getResultList();
	}

	@Override
	public String updateSecurityDetails(Security v) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(v);  //v--persistent
		
		return "Security detials updated for id:"+v.getId();
	}

	@Override
	public String registerOwner(Owner v) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(v); //persistent
		//	sf.getCurrentSession().save(v);
			return "Security detials inserted for id"+v.getOwner_id();
	}

	@Override
	public List<Owner> listOwner() {
		String jpql = "select v from Owner v";
		return sf.getCurrentSession().createQuery(jpql,Owner.class)
		.getResultList();
	}

	@Override
	public String registerVehicle(Vehicle v) {
		//sf.getCurrentSession().persist(v); //persistent
			sf.getCurrentSession().save(v);
			return "Vehicle detials inserted for id"+v.getVehicle_no();
	}

	@Override
	public List<Vehicle> listVehicle() {
		System.out.println("list of vechile dao above jpql");
		String jpql = "select v from Vehicle v";
		
		List<Vehicle> lst= sf.getCurrentSession().createQuery(jpql,Vehicle.class)
		.getResultList();
		System.out.println("list of vechile dao"+lst.get(0).getVehicle_no());
		 return lst;
	}

	@Override
	public List<Vehicle> OwnersVehicle(int vid) {
		// TODO Auto-generated method stub
		System.out.println("in dao of ownVehicle");
		String jpql="select v from Vehicle v where Owner_id=:id";
		return sf.getCurrentSession().createQuery(jpql,Vehicle.class).setParameter("id", vid)
				.getResultList();
	}

	@Override
	public List<GuestEntry> VisitorsDetails(String flat_no) {
		// TODO Auto-generated method stub
		System.out.println("in dao of Visitor list by owner");
		//
		//select  first_name,last_name,email,address,in_Time,out_Time,vehicle_no from guest d ,guest_entry c where flat_no=405;

		String jpql="select v from GuestEntry v where v.flat_no=:fno";
	  
				List<GuestEntry>li=sf.getCurrentSession().createQuery(jpql,GuestEntry.class).setParameter("fno", flat_no)
				.getResultList();
				System.out.println();
				return li;
	}

	@Override
	public List<GuestEntry> VisitorsDetailsByDate(String date) {
		// TODO Auto-generated method stub
		System.out.println("in dao of Visitor list by date");
		String jpql="select v from GuestEntry v where v.in_Time between :dt and :dt2";
		return sf.getCurrentSession().createQuery(jpql,GuestEntry.class).setParameter("dt", date+" 00:00:01").setParameter("dt2", date+" 23:59:59")
				.getResultList();
		
	}
	

}
