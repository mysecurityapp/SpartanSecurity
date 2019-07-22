package com.app.pojos;

import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="guest_entry")
public class GuestEntry{

	private int entry_id;
	private String Vehicle_no;
	//private Security security;
	private Date in_Time;
	private Date out_Time;
	private Security securityid;
	private String flat_no;
	private Guest athithi;
	
	
	


	public GuestEntry( String vehicle_no, Date in_Time, Date out_Time,
			Security securityid, String flat_no, Guest athithi) {
		super();
		this.entry_id = entry_id;
		Vehicle_no = vehicle_no;
		//this.security = security;
		this.in_Time = in_Time;
		this.out_Time = out_Time;
		this.securityid = securityid;
		this.flat_no = flat_no;
		this.athithi = athithi;
	}


	public GuestEntry() {
		super();
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getEntry_id() {
		return entry_id;
	}


	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}


	public String getVehicle_no() {
		return Vehicle_no;
	}


	public void setVehicle_no(String vehicle_no) {
		Vehicle_no = vehicle_no;
	}


//	public Security getSecurity() {
//		return security;
//	}


//	public void setSecurity(Security security) {
//		this.security = security;
//	}


	@Temporal(TemporalType.DATE)
	public Date getIn_Time() {
		return in_Time;
	}


	public void setIn_Time(Date in_Time) {
		this.in_Time = in_Time;
	}


	@Temporal(TemporalType.DATE)
	public Date getOut_Time() {
		return out_Time;
	}


	public void setOut_Time(Date out_Time) {
		this.out_Time = out_Time;
	}


	 @ManyToOne
	 @JoinColumn(name = "SecurityID")
	public Security getSecurityid() {
		return securityid;
	}


	public void setSecurityid(Security securityid) {
		this.securityid = securityid;
	}


	public String getFlat_no() {
		return flat_no;
	}


	public void setFlat_no(String flat_no) {
		this.flat_no = flat_no;
	}

	 @ManyToOne
	 @JoinColumn(name = "GuestID")
	public Guest getAthithi() {
		return athithi;
	}


	public void setAthithi(Guest athithi) {
		this.athithi = athithi;
	}

	
	

	@Override
	public String toString() {
		return "GuestEntry [entry_id=" + entry_id + ", Vehicle_no=" + Vehicle_no + ", security=" 
				+ ", in_Time=" + in_Time + ", out_Time=" + out_Time + ", securityid=" + securityid + ", flat_no="
				+ flat_no + ", athithi=" + athithi + "]";
	}


	
	
	
	
	
	
}
