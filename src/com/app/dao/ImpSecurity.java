package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Owner;
import com.app.pojos.Security;



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
	

}
