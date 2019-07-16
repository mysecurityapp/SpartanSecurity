package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="suppliers")
public class Suppliers {
	private int vid;
	private String first_name;
	private String last_name;
	private String Address;
	private String mobile;
	private String role;
	private String email;
	private Security secID;
	
	
	public Suppliers() {
		super();
	}


	public Suppliers(int vid, String first_name, String last_name, String address, String mobile, String role,
			String email, Security secID) {
		super();
		this.vid = vid;
		this.first_name = first_name;
		this.last_name = last_name;
		Address = address;
		this.mobile = mobile;
		this.role = role;
		this.email = email;
		this.secID = secID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getVid() {
		return vid;
	}


	public void setVid(int vid) {
		this.vid = vid;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@ManyToOne
	 @JoinColumn(name = "SecurityID")
	public Security getSecID() {
		return secID;
	}


	public void setSecID(Security secID) {
		this.secID = secID;
	}


	@Override
	public String toString() {
		return "Suppliers [vid=" + vid + ", first_name=" + first_name + ", last_name=" + last_name + ", Address="
				+ Address + ", mobile=" + mobile + ", role=" + role + ", email=" + email + ", secID=" + secID + "]";
	}
	

	
	
	
	
}
