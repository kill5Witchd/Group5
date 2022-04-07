package com.capg.OnlineSeatBooking.AdminstrationOfficeDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.OnlineSeatBooking.AdminstrationOfficeDetails.model.AdminOfficeDetails;

@Repository
public interface IadminOffice extends JpaRepository<AdminOfficeDetails, Integer>{

}
