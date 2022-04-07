package com.Onlineseatbooking.Onlineseatbooking.services;

import java.util.List;

import com.Onlineseatbooking.Onlineseatbooking.Entity.AdmintrationOfficeDetalils;
import com.Onlineseatbooking.Onlineseatbooking.Exceptions.InvalidOfficeAvailableSpaces;

public interface IAdminstrationOfficeDetailsService {
	public AdmintrationOfficeDetalils addOfficeLocation(AdmintrationOfficeDetalils admintrationOfficeDetalils);
	public AdmintrationOfficeDetalils UpdateOfficeLocation(AdmintrationOfficeDetalils admintrationOfficeDetalils);
	public List<AdmintrationOfficeDetalils> getAllAdmintrationOfficeDetalils();
	public AdmintrationOfficeDetalils getOfficeLocation(int OfficeId);
	public AdmintrationOfficeDetalils getOfficeLayouts(int OfficeId);
	public AdmintrationOfficeDetalils getOfficeFloor(int OfficeId);
	public AdmintrationOfficeDetalils getOfficeSeatCapcity(int OfficeId);
	public AdmintrationOfficeDetalils getOfficeAvailableSpaces(int OfficeId);
	public boolean  hasSeatingAvailbleSpaces(int availableSpaces) throws InvalidOfficeAvailableSpaces;
	
}
