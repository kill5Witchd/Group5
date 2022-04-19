package com.Onlineseatbooking.Onlineseatbooking.services;

import java.util.List;

import com.Onlineseatbooking.Onlineseatbooking.Entity.Admin;

public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public Admin getAdmin(int userId);
	public List<Admin> getAllAdmin();
	public Boolean isValidAdmin(String username, String password);
}
