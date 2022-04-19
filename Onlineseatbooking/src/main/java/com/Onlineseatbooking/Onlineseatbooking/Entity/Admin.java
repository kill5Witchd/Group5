package com.Onlineseatbooking.Onlineseatbooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.Onlineseatbooking.Onlineseatbooking.model.User;

import lombok.Data;
@Data
@Entity
@Table(name="Admin")
public class Admin extends User {
	@Column
	private String adminName;
	@Column
	private String adminContact;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String adminName, String adminContact) {
		super();
		this.adminName = adminName;
		this.adminContact = adminContact;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}
	
	
	
}
