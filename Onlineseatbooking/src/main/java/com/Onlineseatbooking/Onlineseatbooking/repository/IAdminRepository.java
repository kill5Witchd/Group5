package com.Onlineseatbooking.Onlineseatbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Onlineseatbooking.Onlineseatbooking.Entity.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByUsernameAndPassword(String username, String password);
}
