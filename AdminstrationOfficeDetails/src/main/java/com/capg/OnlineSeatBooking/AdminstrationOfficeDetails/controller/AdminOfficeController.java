package com.capg.OnlineSeatBooking.AdminstrationOfficeDetails.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.OnlineSeatBooking.AdminstrationOfficeDetails.Exceptions.ResourceNotFoundException;
import com.capg.OnlineSeatBooking.AdminstrationOfficeDetails.Repository.IadminOffice;
import com.capg.OnlineSeatBooking.AdminstrationOfficeDetails.model.AdminOfficeDetails;


@RestController
@RequestMapping("/api/booking")
public class AdminOfficeController {
	@Autowired
	IadminOffice iadminRepository;
	
	@GetMapping("/AdminstrationOffices")
	public List<AdminOfficeDetails> getAllAdminstrationOffice() {
		return iadminRepository.findAll();
	}

	@GetMapping("/AdminstrationOffice/{id}")
	public ResponseEntity<AdminOfficeDetails> getEmployeeById(@PathVariable(value = "id") int officeId)
			throws ResourceNotFoundException {
		AdminOfficeDetails adminstrationOffice = iadminRepository.findById(officeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + officeId));
		return ResponseEntity.ok().body(adminstrationOffice);
	}

	@PostMapping("/AddadminstrationOffice")
	public AdminOfficeDetails createAdminstrationOffice( @RequestBody AdminOfficeDetails adminstrationOffice) {
		return iadminRepository.save(adminstrationOffice);
	}

	@PutMapping("/AdminstrationOffice/{id}")
	public ResponseEntity<AdminOfficeDetails> updateadminstrationOffice(@PathVariable(value = "id") int officeId,
		 @RequestBody AdminOfficeDetails adminstrationOfficeDetails) throws ResourceNotFoundException {
		AdminOfficeDetails adminstrationOffice = iadminRepository.findById(officeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + officeId));
		
		adminstrationOffice.setAddress(adminstrationOfficeDetails.getAddress());
		adminstrationOffice.setAvailablespaces(adminstrationOfficeDetails.getAvailablespaces());
		adminstrationOffice.setFloor(adminstrationOfficeDetails.getFloor());
		adminstrationOfficeDetails.getSeatcapacity();
		final AdminOfficeDetails updatedEmployee = iadminRepository.save(adminstrationOffice);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/AdminstrationOffice/{id}")
	public Map<String, Boolean> deleteAdminstrationOffice(@PathVariable(value = "id") int officeId)
			throws ResourceNotFoundException {
		AdminOfficeDetails adminOffice = iadminRepository.findById(officeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + officeId));

		iadminRepository.delete(adminOffice);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

