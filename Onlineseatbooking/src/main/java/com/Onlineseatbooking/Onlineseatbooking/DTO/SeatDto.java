package com.Onlineseatbooking.Onlineseatbooking.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class SeatDto {

    private Integer seatId;
    private Date bookingDate;
    private Integer sourcefloor;
    private String email;


    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getSourcefloor() {
        return sourcefloor;
    }

    public void setSourcefloor(Integer sourcefloor) {
        this.sourcefloor = sourcefloor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }






}
