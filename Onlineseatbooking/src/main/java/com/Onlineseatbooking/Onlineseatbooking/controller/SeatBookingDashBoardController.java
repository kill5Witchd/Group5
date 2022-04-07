package com.Onlineseatbooking.Onlineseatbooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.Onlineseatbooking.Onlineseatbooking.model.Seat;
import com.Onlineseatbooking.Onlineseatbooking.services.SeatBookingService;
import com.Onlineseatbooking.Onlineseatbooking.model.AdminOfficeDetails;
import com.Onlineseatbooking.Onlineseatbooking.repository.BookingDashBoardRepository;
import com.Onlineseatbooking.Onlineseatbooking.Exceptions.InvalidOfficeAvailableSpaces;


public class SeatBookingDashBoardController {
	Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
    private SeatBookingService seatBookingService;
	@Autowired
    private BookingDashBoardRepository bookingDashBoardRepository;
	@GetMapping(value="/viewbokking")
    public Iterable<Seat> getAllBookedSeats(){
			return seatBookingService.getAllBookedSeats();
    }
	@GetMapping(value="/viewvaccancies")
	public List<AdminOfficeDetails> viewVacciencesByLocation(String address) throws InvalidOfficeAvailableSpaces{
		return bookingDashBoardRepository.viewVaccienceByLocation(address);
    }
	@GetMapping(value="/viewvaccancies")
	public List<AdminOfficeDetails> viewVaccienceByOffice(int officeId) throws InvalidOfficeAvailableSpaces{
		return bookingDashBoardRepository.viewVaccienceByOffice(officeId);
    }
	@GetMapping(value="/viewvaccancies")
	public List<AdminOfficeDetails> viewVaccienceByFloor(String floor) throws InvalidOfficeAvailableSpaces{
		return bookingDashBoardRepository.viewVaccienceByLocation(floor);
    }
}
