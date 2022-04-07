package com.Onlineseatbooking.Onlineseatbooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.Onlineseatbooking.Onlineseatbooking.model.Seat;
import com.Onlineseatbooking.Onlineseatbooking.Entity.*;
import com.Onlineseatbooking.Onlineseatbooking.services.SeatBookingService;

import com.Onlineseatbooking.Onlineseatbooking.repository.IAdminstrationOfficeDetailsRepository;
import com.Onlineseatbooking.Onlineseatbooking.Exceptions.InvalidOfficeAvailableSpaces;


public class SeatBookingDashBoardController {
	Logger logger = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	private IAdminstrationOfficeDetailsRepository iAdminstrationOfficeDetailsRepository;
	@Autowired
    private SeatBookingService seatBookingService;
	@Autowired
	private AdmintrationOfficeDetalils admin;
	@GetMapping(value="/viewbokking")
    public Iterable<Seat> getAllBookedSeats(){
			return seatBookingService.getAllBookedSeats();
    }
	@GetMapping(value="/viewvaccancies")
	public List<AdmintrationOfficeDetalils> SearchAvailableSpaces() throws InvalidOfficeAvailableSpaces{
		if(admin.getAvailableSpaces()!=0) {
			return iAdminstrationOfficeDetailsRepository.findAll();
		}
		else {
			throw new InvalidOfficeAvailableSpaces("no spaces");
		}
    }
}
