package com.app.pojos;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="guest")
public class Guest {
	private int guest_id;
	private String mobile_num;
	private String first_name;
	private String last_name;
	private String address;
	private String email;
	private Security security_id;
	private Owner owner;
	private List<GuestEntry> guests=new ArrayList<>();
	
	public Guest( String mobile_num, String first_name, String last_name, String address, String email,
			Security security_id) {
		super();
		//this.guest_id = guest_id;
		this.mobile_num = mobile_num;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.email = email;
		this.security_id = security_id;
		//this.owner = owner;
		//this.guests = guests;
	}
	

	public Guest() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	public String getMobile_num() {
		return mobile_num;
	}

	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
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
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	 @JoinColumn(name = "security_ID")
	public Security getSecurity_id() {
		return security_id;
	}

	public void setSecurity_id(Security security_id) {
		this.security_id = security_id;
	}

	
	

	@Override
	public String toString() {
		return "Guest [guest_id=" + guest_id + ", mobile_num=" + mobile_num + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", address=" + address + ", email=" + email + ", security_id="
				+ security_id + ", owner_id=" + owner + "]";
	}

	@ManyToOne
	 @JoinColumn(name = "Owner_ID")
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@OneToMany(mappedBy = "athithi",cascade=CascadeType.ALL)
	public List<GuestEntry> getGuests() {
		return guests;
	}


	public void setGuests(List<GuestEntry> guests) {
		this.guests = guests;
	}
	
	
	
	

	
	
	

}
