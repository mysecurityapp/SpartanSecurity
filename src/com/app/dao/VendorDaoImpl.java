package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao{
	
	@Autowired
	SessionFactory sf;

	@Override
	public Vendor validateUser(String email, String pass) {
		String jpql="select v from Vendor v where v.email=:em and v.password=:ps";
		return sf.getCurrentSession().createQuery(jpql,Vendor.class)
				.setParameter("em", email).setParameter("ps", pass)
				.getSingleResult();
	}

	@Override
	public List<Vendor> getVendorDetails() {
		// TODO Auto-generated method stub
		String jpql = "select v from Vendor v where v.role=:role";
		return sf.getCurrentSession().createQuery(jpql,Vendor.class)
				.setParameter("role", "vendor").getResultList();
	}

	@Override
	public Vendor deleteVendor(int id) {
		// TODO Auto-generated method stub
		//String jpql = "delete from Vendor v where v.id=:id";
		//System.out.println();
		Vendor v = sf.getCurrentSession().get(Vendor.class,id);
		Session session = sf.getCurrentSession();
	    session.delete(v);
		return v;
	}

	@Override
	public String registerVendor(Vendor v) {
		//v--Transient
		sf.getCurrentSession().persist(v); //persistent
	//	sf.getCurrentSession().save(v);
		return "Vendor detials inserted for id"+v.getId();
	}

	@Override
	public String deleteVendorDetails(Vendor v) {
		// v--detached POJO ref
		sf.getCurrentSession().delete(v);
		return "Vendor details deleted for vendor id"+v.getId();
	}

	@Override
	public String updateVendorDetails(Vendor v) {
		
		//v-detached vendor POJO containing updated vendor details
		//detached-->persistent
		sf.getCurrentSession().update(v);  //v--persistent
		//hib will perform auto dirty checking(update query)
		//will be fired upon commit
		return "Vendor detials updated for id:"+v.getId();
	}

	@Override
	public Vendor getVendorDetails(int vid) {
		
		return sf.getCurrentSession().get(Vendor.class, vid);
	}
	

}
