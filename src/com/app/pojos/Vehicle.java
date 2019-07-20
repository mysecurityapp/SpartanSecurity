package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="vehicle_table")
public class Vehicle {
	
	private String Vehicle_no;
	private String Vehicle_type;
	private Owner malik;
	
	
	public Vehicle(String vehicle_no, String vehicle_type, Owner malik) {
		super();
		Vehicle_no = vehicle_no;
		Vehicle_type = vehicle_type;
		this.malik = malik;
	}

	public Vehicle(String vehicle_no, String vehicle_type, Owner malik,int id) {
		super();
		Vehicle_no = vehicle_no;
		Vehicle_type = vehicle_type;
		this.malik = malik;
		malik.setOwner_id(id);
	}

	

	public Vehicle() {
		super();
	}


	@Id
	public String getVehicle_no() {
		return Vehicle_no;
	}


	public void setVehicle_no(String vehicle_no) {
		Vehicle_no = vehicle_no;
	}


	public String getVehicle_type() {
		return Vehicle_type;
	}


	public void setVehicle_type(String vehicle_type) {
		Vehicle_type = vehicle_type;
	}


	 @ManyToOne
	 @JoinColumn(name = "Owner_id")
	public Owner getMalik() {
		return malik;
	}


	public void setMalik(Owner malik) {
		this.malik = malik;
	}


	@Override
	public String toString() {
		return "Vehicle [Vehicle_no=" + Vehicle_no + ", Vehicle_type=" + Vehicle_type + ", malik=" + malik + "]";
	}


	
	
	
}
