package com.Onlineseatbooking.Onlineseatbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Onlineseatbooking.Onlineseatbooking.model.AdminOfficeDetails;

public interface BookingDashBoardRepository extends JpaRepository<AdminOfficeDetails, Integer>{
	public List<AdminOfficeDetails> viewVaccienceByLocation(String address);
	public List<AdminOfficeDetails> viewVaccienceByOffice(int officeId);
	public List<AdminOfficeDetails> viewVaccienceByFloor(String floor);
}
