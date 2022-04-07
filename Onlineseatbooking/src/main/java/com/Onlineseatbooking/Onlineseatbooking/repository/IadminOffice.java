package com.Onlineseatbooking.Onlineseatbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Onlineseatbooking.Onlineseatbooking.model.AdminOfficeDetails;

@Repository
public interface IadminOffice extends JpaRepository<AdminOfficeDetails, Integer>{

}
