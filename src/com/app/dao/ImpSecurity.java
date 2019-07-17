package com.app.dao;

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
		String jpql="select v from Owner v where v.email=:em and v.password=:ps";
		return sf.getCurrentSession().createQuery(jpql,Security.class)
				.setParameter("em", email).setParameter("ps", password)
				.getSingleResult();
	}
	

}
