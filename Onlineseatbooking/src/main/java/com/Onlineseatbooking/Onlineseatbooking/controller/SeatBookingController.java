package com.Onlineseatbooking.Onlineseatbooking.controller;
import com.Onlineseatbooking.Onlineseatbooking.repository.RoleRepository;
import com.Onlineseatbooking.Onlineseatbooking.DTO.SeatDto;
import com.Onlineseatbooking.Onlineseatbooking.model.Role;
import com.Onlineseatbooking.Onlineseatbooking.model.Seat;
import com.Onlineseatbooking.Onlineseatbooking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Onlineseatbooking.Onlineseatbooking.services.SeatBookingService;

import java.util.Collections;

@RestController
@RequestMapping(value="/api/Seats")
public class SeatBookingController {

    @Autowired
    private SeatBookingService seatBookingService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(value="/create")
   public Seat createSeat(@RequestBody Seat seat){
        return seatBookingService.createSeat(seat);
//        Seat seat = new Seat();
//        seat.setSeatId(seatDto.getSeatId());
//        seat.setBookingDate(seatDto.getBookingDate());
//        seat.setSourceFloor(seatDto.getSourcefloor());
//        seat.setEmail(seatDto.getEmail());
//
//        Role roles = roleRepository.findByName("ROLE_USER").get();
//        seat.setRoles(Collections.singleton(roles));
//
//        seatBookingService.save(seat);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//
   }

    @GetMapping(value="/seat/{seatId}")
    //@RequestMapping(value="/ticket/{ticketId}")
    public Seat getSeatById(@PathVariable("seatId")Integer seatId){
        return seatBookingService.getSeatById(seatId);
    }

    @GetMapping(value="/seat/allseat")
    public Iterable<Seat> getAllBookedSeats(){
        return seatBookingService.getAllBookedSeats();
    }

    @DeleteMapping(value="/Seat/{seatId}")
    public void deleteseat(@PathVariable("seatId")Integer seatId){
        seatBookingService.deleteSeat(seatId);
    }

    @PutMapping(value="/Seat/{seatId}/{newEmail:.+}")
    public Seat updateSeat(@PathVariable("seatId")Integer seatId, @PathVariable("newEmail")String newEmail){
        return seatBookingService.updateSeat(seatId,newEmail);
    }
}
