package com.Onlineseatbooking.Onlineseatbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Onlineseatbooking.Onlineseatbooking.Entity.AdmintrationOfficeDetalils;

public interface IAdminstrationOfficeDetailsRepository extends JpaRepository<AdmintrationOfficeDetalils, Integer> {
	public AdmintrationOfficeDetalils findByOfficeAddress(String OfficeAddress);
	public int getOfficeAvailableSpaces(int availableSpaces);
}
