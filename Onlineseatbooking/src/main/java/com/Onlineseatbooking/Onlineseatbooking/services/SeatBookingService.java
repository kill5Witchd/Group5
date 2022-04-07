package com.Onlineseatbooking.Onlineseatbooking.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Onlineseatbooking.Onlineseatbooking.dao.SeatBookingDao;
import com.Onlineseatbooking.Onlineseatbooking.model.Seat;
@Service
public class SeatBookingService {
    @Autowired
    private SeatBookingDao seatBookingDao;

    public Seat createSeat(Seat seat) {
        return seatBookingDao.save(seat);
    }
    public Seat getSeatById(Integer seatId) {
        return seatBookingDao.findById(seatId).get();
    }
    public Iterable<Seat> getAllBookedSeats() {
        return seatBookingDao.findAll();
    }
    public void deleteSeat(Integer seatId) {
        seatBookingDao.deleteById(seatId);
    }
    public Seat updateSeat(Integer seatId, String newEmail) {

        Seat seatFromDb = seatBookingDao.findById(seatId).get();
        seatFromDb.setEmail(newEmail);
        Seat upadedSeat = seatBookingDao.save(seatFromDb);
        return upadedSeat;
    }
}
