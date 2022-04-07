package com.Onlineseatbooking.Onlineseatbooking.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="ticket", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"seat_id"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class Seat {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="seat_id")
    private Integer seatId;



    @Column(name="booking_date")
    private Date bookingDate;

    @Column(name="source_floor")
    private Integer sourcefloor;

    @Column(name="email")
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
    public Integer getSourceFloor() {
        return sourcefloor;
    }
    public void setSourceFloor(Integer sourcefloor) {
        this.sourcefloor = sourcefloor;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Seat [SeatId=" + seatId +  ", bookingDate=" + bookingDate
                + ", sourcefloor=" + sourcefloor + " , email=" + email +"]";
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "seat_id", referencedColumnName = "seat_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
