package com.app.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Guest;
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
	public String registerGuest(Guest g) {
		sf.getCurrentSession().save(g); //persistent
		//	sf.getCurrentSession().save(v);
			return "Security detials inserted for id"+g.getGuest_id();
	}
	@Override
	public String registerGuestEntry(GuestEntry g) {
		sf.getCurrentSession().save(g); //persistent
		//	sf.getCurrentSession().save(v);
			return "Security detials inserted for id"+g.getEntry_id();
	}

	@Override
	public Security validateSecurity(String email, String password) {
		String jpql="select v from Security v where v.email=:em and v.password=:ps";
		
		return sf.getCurrentSession().createQuery(jpql,Security.class)
				.setParameter("em", email).setParameter("ps", password)
				.getSingleResult();
	}
	
	@Override
	public String checkout(String mobileNo) {
		String jpql="select g from GuestEntry g where GuestID=(select v.guest_id from Guest v where v.mobile_num=:mb) ";
		GuestEntry g = sf.getCurrentSession().createQuery(jpql,GuestEntry.class)
		.setParameter("mb", mobileNo)
		.getSingleResult();
		System.out.println("details:"+g.getAthithi().getMobile_num() + "::"+g.getAthithi().getAddress());
		Date d=new Date();
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
		g.setOut_Time(cal.getTime());
		sf.getCurrentSession().update(g);
		return "User checkedout successfully..!!";
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
		sf.getCurrentSession().persist(v); //persistent
		//	sf.getCurrentSession().save(v);
			return "Vehicle detials inserted for id"+v.getVehicle_no();
	}

	@Override
	public List<Vehicle> listVehicle() {
		String jpql = "select v from Vehicle v";
		return sf.getCurrentSession().createQuery(jpql,Vehicle.class)
		.getResultList();
	}
	

}
