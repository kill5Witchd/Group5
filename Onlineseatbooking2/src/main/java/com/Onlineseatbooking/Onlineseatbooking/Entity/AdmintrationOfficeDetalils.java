package com.Onlineseatbooking.Onlineseatbooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="AdmintrationOffice")
public class AdmintrationOfficeDetalils {
	@Column
	@GeneratedValue
	private int OfficeId;
	@Column
	private String OfficeAddress;
	@Column
	private String floorDetails;
	@Column
	private String layouts;
	@Column
	private int seatingCapcity;
	@Column
	private int availableSpaces;
	
	public AdmintrationOfficeDetalils(int officeId, String officeAddress, String floorDetails, String layouts,
			int seatingCapcity, int availableSpaces) {
		super();
		OfficeId = officeId;
		OfficeAddress = officeAddress;
		this.floorDetails = floorDetails;
		this.layouts = layouts;
		this.seatingCapcity = seatingCapcity;
		this.availableSpaces = availableSpaces;
	}

	public int getOfficeId() {
		return OfficeId;
	}

	public void setOfficeId(int officeId) {
		OfficeId = officeId;
	}

	public String getOfficeAddress() {
		return OfficeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		OfficeAddress = officeAddress;
	}

	public String getFloorDetails() {
		return floorDetails;
	}

	public void setFloorDetails(String floorDetails) {
		this.floorDetails = floorDetails;
	}

	public String getLayouts() {
		return layouts;
	}

	public void setLayouts(String layouts) {
		this.layouts = layouts;
	}

	public int getSeatingCapcity() {
		return seatingCapcity;
	}

	public void setSeatingCapcity(int seatingCapcity) {
		this.seatingCapcity = seatingCapcity;
	}

	public int getAvailableSpaces() {
		return availableSpaces;
	}

	public void setAvailableSpaces(int availableSpaces) {
		this.availableSpaces = availableSpaces;
	}

	public AdmintrationOfficeDetalils orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public AdmintrationOfficeDetalils get(Object object) {
		// TODO Auto-generated method stub
		return (AdmintrationOfficeDetalils) object;
	}
	
	
	

}
