package com.Onlineseatbooking.Onlineseatbooking.controller;

import com.Onlineseatbooking.Onlineseatbooking.DTO.LoginDto;
import com.Onlineseatbooking.Onlineseatbooking.DTO.SignUpDto;
import com.Onlineseatbooking.Onlineseatbooking.NoAccessException;
import com.Onlineseatbooking.Onlineseatbooking.ResourceNotFoundException;
import com.Onlineseatbooking.Onlineseatbooking.model.Role;
import com.Onlineseatbooking.Onlineseatbooking.model.User;
import com.Onlineseatbooking.Onlineseatbooking.repository.RoleRepository;
import com.Onlineseatbooking.Onlineseatbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import com.Onlineseatbooking.Onlineseatbooking.NoAccessException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Login/Sign in REST API
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    //Register/SignUp REST API
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) throws NoAccessException{

        // add check for username exists in a DB
        if (userRepository.existsByUsername(signUpDto.getUsername())) {throw new NoAccessException("Username already taken");}

        // add check for email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }

//    // Update user
//    @SuppressWarnings("unlikely-arg-type")
//    @GetMapping("/edit/{id}")
//    public String updateUser(@PathVariable("id") Long userId, Model model) throws ResourceNotFoundException {
//        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user id :" + userId));
//        model.addAttribute(user);
//        userRepository.equals(user);
//        String result = "Name : " + user.getName() + " , Email : " + user.getEmail() + " , Username : " + user.getUsername();
//        return result;
//    }

//    @PostMapping("/edit/{id}")
//    public String update_User(User nuser, BindingResult bindingResult, @PathVariable("id") Long userId, Model model) throws ResourceNotFoundException {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);

//        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user id :" + userId));
//
//        if(nuser.getName() != null){
//            String name= nuser.getName();
//            user.setName(name);
//        }
//        if(nuser.getEmail() != null){
//            String mail= nuser.getEmail();
//            user.setName(mail);
//        }
//        if(nuser.getUsername() != null){
//            String uname= nuser.getUsername();
//            user.setName(uname);
//        }
//        if(nuser.getPassword() != null){
//            String pass= nuser.getPassword();
//            user.setName(pass);
//        }
//        userRepository.save(user);
//
//        return "Update Success";
//    }

    //////
//    @GetMapping("/user")
//    public List<User> get() {
//        return userRepository.findAll();
//    }
//
//    @PostMapping("/user")
//    public User save(@RequestBody User new_user) {
//        return userRepository.save(new_user);
//    }
//
//    @GetMapping("/user/{id}")
//    public User get(@PathVariable long id) {
//        Optional<User> new_user = userRepository.findById(id);
//        if (new_user.isPresent()) {
//            return new_user.get();
//        } else {
//            throw new RuntimeException("User not found for the id " + id);
//        }
//    }
//
//
//    @PutMapping("/user/{id}")
//    public User update(@RequestBody User new_user) {
//        return userRepository.save(new_user);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public String delete(@PathVariable long id) {
//        Optional<User> new_user = userRepository.findById(id);
//        if (new_user.isPresent()) {
//            userRepository.delete(new_user.get());
//            return "User is deleted with id " + id;
//        } else {
//            throw new RuntimeException("User not found for the id " + id);
//        }
//    }
//
//    @PostMapping("/edit/{id}")
//    public String update_User(User new_user, BindingResult bindingResult, @PathVariable("id") Long userId, Model model) throws ResourceNotFoundException {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(new_user.getPassword());
//        new_user.setPassword(encodedPassword);
//        userRepository.save(new_user);
//
//        return "Password Updated";
//    }
}