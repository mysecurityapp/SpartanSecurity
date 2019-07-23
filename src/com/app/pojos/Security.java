package com.app.pojos;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * @author user41
 *
 */
@Entity
@Table(name="Sec_gaurd")
public class Security {
	

	private int id;
	private String first_name;
	private String last_name;
	private String address;
	private String mobile_numb;
	private String password;
	private String email;
	private Owner saheb;
	private List<Guest> guest=new ArrayList<>();
	private List<GuestEntry> guestsEntry=new ArrayList<>();
	private List<Suppliers> Supplier=new ArrayList<>();
	
	public Security() {
		super();
	}

	public Security(int id, String first_name, String last_name, String address, String mobile_numb, String password,
			String email, Owner saheb, List<Guest> guest, List<GuestEntry> guestsEntry, List<Suppliers> supplier) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.mobile_numb = mobile_numb;
		this.password = password;
		this.email = email;
		this.saheb = saheb;
		this.guest = guest;
		this.guestsEntry = guestsEntry;
		Supplier = supplier;
	}









	public Security(String first_name, String last_name, String address, String mobile_numb, String password,
			String email, Owner own,int ownid) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.mobile_numb = mobile_numb;
		this.password = password;
		this.email = email;
		this.saheb=own;
		saheb.setOwner_id(ownid);
		
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	public String getMobile_numb() {
		return mobile_numb;
	}


	public void setMobile_numb(String mobile_numb) {
		this.mobile_numb = mobile_numb;
	}


	 @ManyToOne
	 @JoinColumn(name = "Secretary_id")
	public Owner getSaheb() {
		return saheb;
	}


	public void setSaheb(Owner saheb) {
		this.saheb = saheb;
	}


	

	@OneToMany(mappedBy = "security_id",cascade=CascadeType.ALL,fetch =FetchType.LAZY)
	public List<Guest> getGuest() {
		return guest;
	}




	public void setGuest(List<Guest> guest) {
		this.guest = guest;
	}





	@OneToMany(mappedBy = "securityid",cascade=CascadeType.ALL,fetch =FetchType.LAZY)
	public List<GuestEntry> getGuestsEntry() {
		return guestsEntry;
	}





	public void setGuestsEntry(List<GuestEntry> guestsEntry) {
		this.guestsEntry = guestsEntry;
	}


	
	
	

	@OneToMany(mappedBy = "secID",cascade=CascadeType.ALL,fetch =FetchType.LAZY)
	public List<Suppliers> getSupplier() {
		return Supplier;
	}




	public void setSupplier(List<Suppliers> supplier) {
		Supplier = supplier;
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
		return "Security [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", mobile_numb=" + mobile_numb + ", password=" + password + ", email=" + email + ", saheb=" + saheb
				+ ", guest=" + guest + ", guestsEntry=" + guestsEntry + ", Supplier=" + Supplier + "]";
	}




	






	


	
	

//
//	@OneToMany(mappedBy = "security_id",cascade=CascadeType.ALL)
//	public List<Guest> getGuest() {
//		return guest;
//	}
//
//
//
//
//	public void setGuest(List<Guest> guest) {
//		this.guest = guest;
//	}


	
	

//	@OneToMany(mappedBy = "securityid",cascade=CascadeType.ALL)
//	public List<GuestEntry> getGuestsEntry() {
//		return guestsEntry;
//	}
//
//
//
//
//	public void setGuestsEntry(List<GuestEntry> guestsEntry) {
//		this.guestsEntry = guestsEntry;
//	}




	




	


	
	
	
	
	
}
