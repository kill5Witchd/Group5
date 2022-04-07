package com.Onlineseatbooking.Onlineseatbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Onlineseatbooking.Onlineseatbooking.Entity.AdmintrationOfficeDetalils;
import com.Onlineseatbooking.Onlineseatbooking.Exceptions.InvalidOfficeAvailableSpaces;
import com.Onlineseatbooking.Onlineseatbooking.repository.IAdminstrationOfficeDetailsRepository;

@Service
public class AdminstrationService implements IAdminstrationOfficeDetailsService  {
	@Autowired
	IAdminstrationOfficeDetailsRepository iAdminstrationOfficeDetailsRepository;
	
	@Override
	public AdmintrationOfficeDetalils addOfficeLocation(AdmintrationOfficeDetalils admintrationOfficeDetalils) {
		iAdminstrationOfficeDetailsRepository.save(admintrationOfficeDetalils);
		return admintrationOfficeDetalils;
	}
	//Updating by officeId
	public AdmintrationOfficeDetalils UpdateOfficeLocationById(AdmintrationOfficeDetalils admintrationOfficeDetalils) {
		// TODO Auto-generated method stub
		AdmintrationOfficeDetalils existingAdmintrationOfficeDetalils = iAdminstrationOfficeDetailsRepository.findById(admintrationOfficeDetalils.getOfficeId()).orElse(null);
		existingAdmintrationOfficeDetalils.setOfficeAddress(admintrationOfficeDetalils.getOfficeAddress());
		existingAdmintrationOfficeDetalils.setFloorDetails(admintrationOfficeDetalils.getFloorDetails());
		existingAdmintrationOfficeDetalils.setLayouts(admintrationOfficeDetalils.getLayouts());
		existingAdmintrationOfficeDetalils.setSeatingCapcity(admintrationOfficeDetalils.getSeatingCapcity());
		existingAdmintrationOfficeDetalils.setAvailableSpaces(admintrationOfficeDetalils.getAvailableSpaces());
        return iAdminstrationOfficeDetailsRepository.save(existingAdmintrationOfficeDetalils);
	}
	//Updating by OfficeAddress
	@Override
	public AdmintrationOfficeDetalils UpdateOfficeLocation(AdmintrationOfficeDetalils admintrationOfficeDetalils) {
		// TODO Auto-generated method stub
		AdmintrationOfficeDetalils existingAdmintrationOfficeDetalils = iAdminstrationOfficeDetailsRepository.findByOfficeAddress(admintrationOfficeDetalils.getOfficeAddress()).orElse(null);
		existingAdmintrationOfficeDetalils.setOfficeAddress(admintrationOfficeDetalils.getOfficeAddress());
		existingAdmintrationOfficeDetalils.setFloorDetails(admintrationOfficeDetalils.getFloorDetails());
		existingAdmintrationOfficeDetalils.setLayouts(admintrationOfficeDetalils.getLayouts());
		existingAdmintrationOfficeDetalils.setSeatingCapcity(admintrationOfficeDetalils.getSeatingCapcity());
		existingAdmintrationOfficeDetalils.setAvailableSpaces(admintrationOfficeDetalils.getAvailableSpaces());
        return iAdminstrationOfficeDetailsRepository.save(existingAdmintrationOfficeDetalils);
	}

	@Override
	public List<AdmintrationOfficeDetalils> getAllAdmintrationOfficeDetalils() {
		// TODO Auto-generated method stub
		return iAdminstrationOfficeDetailsRepository.findAll();
	}

	@Override
	public boolean hasSeatingAvailbleSpaces(int availableSpaces) throws InvalidOfficeAvailableSpaces {
		// TODO Auto-generated method stub
		int RemainingSpace=iAdminstrationOfficeDetailsRepository.getOfficeAvailableSpaces(25);
		if(availableSpaces>RemainingSpace) {
			throw new InvalidOfficeAvailableSpaces("There is only few places Left out 25 Spaces");
		}
		return true;
	}
	@Override
	public AdmintrationOfficeDetalils getOfficeLocation(int OfficeId) {
		// TODO Auto-generated method stub
		return iAdminstrationOfficeDetailsRepository.findById(OfficeId).get();
	}
	@Override
	public AdmintrationOfficeDetalils getOfficeLayouts(int OfficeId) {
		// TODO Auto-generated method stub
		return iAdminstrationOfficeDetailsRepository.findById(OfficeId).get();

	}
	@Override
	public AdmintrationOfficeDetalils getOfficeFloor(int OfficeId) {
		// TODO Auto-generated method stub
		return iAdminstrationOfficeDetailsRepository.findById(OfficeId).get();

	}
	@Override
	public AdmintrationOfficeDetalils getOfficeSeatCapcity(int OfficeId) {
		// TODO Auto-generated method stub
		return iAdminstrationOfficeDetailsRepository.findById(OfficeId).get();

	}
	@Override
	public AdmintrationOfficeDetalils getOfficeAvailableSpaces(int OfficeId) {
		// TODO Auto-generated method stub
		return iAdminstrationOfficeDetailsRepository.findById(OfficeId).get();

	}

	
}
