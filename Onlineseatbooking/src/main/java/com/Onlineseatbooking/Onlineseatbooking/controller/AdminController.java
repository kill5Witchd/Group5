package com.Onlineseatbooking.Onlineseatbooking.controller;

import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Onlineseatbooking.Onlineseatbooking.Entity.Admin;
import com.Onlineseatbooking.Onlineseatbooking.repository.IAdminRepository;
import com.Onlineseatbooking.Onlineseatbooking.services.IAdminService;

@RestController
@RequestMapping("/onlineTicket/admin")

public class AdminController {
	Logger logger = Logger.getLogger(AdminController.class.getName());
	@Autowired
	IAdminService adminService;
	
	@Autowired
	private IAdminRepository iAdminRepository;
	
	public AdminController() {
		logger.log(Level.INFO,"-----> Inside Admin Service Controller Working!");
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	
	@GetMapping("/Admins")
	public ResponseEntity<List<Admin>> viewAllAdmin() {
		return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.OK);
	}
	
	//This Method after User/Customer is added
	/*@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}*/
	
	//Validating the user
	@GetMapping("/validatingAdmin/{username}/{password}")
	public ResponseEntity<Boolean> isValidAdmin(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(adminService.isValidAdmin(username, password),HttpStatus.OK);
		}
	/*This Method is Valid When User/Customer Added
	@DeleteMapping("/deleteCustomer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int userId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.OK);
	}*/
	
}
