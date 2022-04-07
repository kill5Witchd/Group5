package com.Onlineseatbooking.Onlineseatbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="adminstration_detals")
public class AdminOfficeDetails {
	@Id
	@GeneratedValue
	private int officeId;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private final int seatcapacity=100;
	private int availablespaces;
	private String floor;
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public int getAvailablespaces() {
		return availablespaces;
	}
	public void setAvailablespaces(int availablespaces) {
		this.availablespaces = availablespaces;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public int getSeatcapacity() {
		return seatcapacity;
	}
	

}
