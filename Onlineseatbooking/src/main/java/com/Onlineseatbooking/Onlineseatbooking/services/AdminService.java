package com.Onlineseatbooking.Onlineseatbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Onlineseatbooking.Onlineseatbooking.Entity.Admin;
import com.Onlineseatbooking.Onlineseatbooking.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService {
	@Autowired
	IAdminRepository iAdminRepository;

	@Override
	// saving a specific record by using the method save() of CrudRepository
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		iAdminRepository.save(admin);
		return admin;
	}
	// getting a specific record by using the method findById() of CrudRepository
	@Override
	public Admin getAdmin(int userId) {
		// TODO Auto-generated method stub
		return iAdminRepository.findById(userId).get();
	}
	
	// getting all Employee record by using the method findaAll() of CrudRepository
	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return iAdminRepository.findAll();
	}
	//this method check the admin's credential is valid or not
	@Override
	public Boolean isValidAdmin(String username, String password) {
		// TODO Auto-generated method stub
		return iAdminRepository.findByUsernameAndPassword(username, password)!=null;
	}

}
