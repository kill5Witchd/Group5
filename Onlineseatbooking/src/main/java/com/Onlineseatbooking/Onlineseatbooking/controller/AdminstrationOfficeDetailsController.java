package com.Onlineseatbooking.Onlineseatbooking.controller;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Onlineseatbooking.Onlineseatbooking.Entity.AdmintrationOfficeDetalils;
import com.Onlineseatbooking.Onlineseatbooking.Exceptions.InvalidOfficeAvailableSpaces;
import com.Onlineseatbooking.Onlineseatbooking.services.AdminstrationService;
import com.Onlineseatbooking.Onlineseatbooking.services.IAdminstrationOfficeDetailsService;


@RestController
@RequestMapping("/onlineTicket/adminstrationOfficeDetailsService")
public class AdminstrationOfficeDetailsController {
	Logger logger = Logger.getLogger(AdminController.class.getName());
	@Autowired
	IAdminstrationOfficeDetailsService adminstrationOfficeDetailsService;
	@Autowired
	AdminstrationService adminstartionService;
	public AdminstrationOfficeDetailsController() {
		logger.log(Level.INFO,"-----> Inside AdminstrationOfficeDetails Service Controller Working!");
	}
	
	@PostMapping("/addAdminstrationOfficeDetails")
	public ResponseEntity<AdmintrationOfficeDetalils> addAdminstrationOffice(@RequestBody AdmintrationOfficeDetalils admin) {
		return new ResponseEntity<>(adminstrationOfficeDetailsService.addOfficeLocation(admin), HttpStatus.OK);
	}
	@PutMapping("/updateAdminstrationOfficeDetailsByAddress")
    public AdmintrationOfficeDetalils updateAdmintrationOfficeDetalils(@RequestBody AdmintrationOfficeDetalils admintrationOfficeDetalils) {
        return adminstrationOfficeDetailsService.UpdateOfficeLocation(admintrationOfficeDetalils);
    }
	@PutMapping("/updateAdminstrationOfficeDetailsByOfficeId")
    public AdmintrationOfficeDetalils updateAdmintrationOfficeDetalilsByOfficeId(@RequestBody AdmintrationOfficeDetalils admintrationOfficeDetalils) {
        return adminstartionService.UpdateOfficeLocationById(admintrationOfficeDetalils);
    }
	@GetMapping("/AllAdminstrationOfficeDetails")
	public ResponseEntity<List<AdmintrationOfficeDetalils>> viewAllAdminstrationOfficesDetails() {
		return new ResponseEntity<>(adminstrationOfficeDetailsService.getAllAdmintrationOfficeDetalils(), HttpStatus.OK);
	}
	@GetMapping("/AdminstrationOfficeLocation/{id}")
	 public AdmintrationOfficeDetalils getAdmintrationOfficeLocation (@PathVariable int id) {
	        return adminstrationOfficeDetailsService.getOfficeLocation(id);
	}
	@GetMapping("/AdminstrationOfficeLayouts/{id}")
	 public AdmintrationOfficeDetalils getAdmintrationOfficeLayouts (@PathVariable int id) {
	        return adminstrationOfficeDetailsService.getOfficeLayouts(id);
	}
	@GetMapping("/AdminstrationOfficeFloors/{id}")
	 public AdmintrationOfficeDetalils getAdmintrationOfficeFloors (@PathVariable int id) {
	        return adminstrationOfficeDetailsService.getOfficeFloor(id);
	}
	@GetMapping("/AdminstrationOfficeSeatingCapacity/{id}")
	 public AdmintrationOfficeDetalils getAdmintrationOfficeSeatingCapacity (@PathVariable int id) {
	        return adminstrationOfficeDetailsService.getOfficeSeatCapcity(id);
	}
	@GetMapping("/AdminstrationOfficeAvailableSpaces/{id}")
	 public AdmintrationOfficeDetalils getAdmintrationOfficeAvailableSpaces (@PathVariable int id) {
	        return adminstrationOfficeDetailsService.getOfficeAvailableSpaces(id);
	}
	@GetMapping("/validatingAdminstrationAvailableSpaces/{availableSpaces}")
	public ResponseEntity<Boolean> isValidAdminstrationAvailableSpaces(@PathVariable int availableSpaces) throws InvalidOfficeAvailableSpaces {
		return new ResponseEntity<>(adminstrationOfficeDetailsService.hasSeatingAvailbleSpaces(availableSpaces),HttpStatus.OK);
	}
}
