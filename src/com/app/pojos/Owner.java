package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="owner_table")
public class Owner {
	
	private int owner_id;
	private String flat_no;
	private String first_name;
	private String last_name;
	private String mobile_no;
	private String password;
	private String email;
	private String role;
	private List<Vehicle> Vehicles=new ArrayList<>();
	private List<Security> Security=new ArrayList<>();
	private List<Guest> guest=new ArrayList<>();
	

	


	public Owner(int owner_id, String flat_no, String first_name, String last_name, String mobile_no, String password,
			String email, String role, List<Vehicle> vehicles, List<com.app.pojos.Security> security,
			List<Guest> guest) {
		super();
		this.owner_id = owner_id;
		this.flat_no = flat_no;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_no = mobile_no;
		this.password = password;
		this.email = email;
		this.role = role;
		Vehicles = vehicles;
		Security = security;
		this.guest = guest;
	}


	public Owner() {
		super();
	}

	
	

	public Owner(String flat_no, String first_name, String last_name, String mobile_no, String password, String email,
			String role) {
		super();
		this.flat_no = flat_no;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_no = mobile_no;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getOwner_id() {
		return owner_id;
	}


	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}


	public String getFlat_no() {
		return flat_no;
	}


	public void setFlat_no(String flat_no) {
		this.flat_no = flat_no;
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


	public String getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}





	@OneToMany(mappedBy = "malik",cascade=CascadeType.ALL,fetch =FetchType.LAZY)
	 public List<Vehicle> getVehicles() {
		return Vehicles;
	}


	public void setVehicles(List<Vehicle> vehicles) {
		Vehicles = vehicles;
	}



	@OneToMany(mappedBy = "saheb",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	public List<Security> getSecurity() {
		return Security;
	}


	public void setSecurity(List<Security> security) {
		Security = security;
	}

	
	

	@OneToMany(mappedBy = "owner",cascade=CascadeType.ALL)
	public List<Guest> getGuest() {
		return guest;
	}


	public void setGuest(List<Guest> guest) {
		this.guest = guest;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Owner [owner_id=" + owner_id + ", flat_no=" + flat_no + ", first_name=" + first_name + ", last_name="
				+ last_name + ", mobile_no=" + mobile_no + ", password=" + password + ", email=" + email + ", role="
				+ role + ", Vehicles=" + Vehicles + ", Security=" + Security + ", guest=" + guest + "]";
	}


	

	

	

	
	

}
