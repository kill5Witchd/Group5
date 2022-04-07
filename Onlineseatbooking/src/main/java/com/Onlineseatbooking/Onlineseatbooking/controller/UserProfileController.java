package com.Onlineseatbooking.Onlineseatbooking.controller;

import com.Onlineseatbooking.Onlineseatbooking.CustomerNotFoundException;
import com.Onlineseatbooking.Onlineseatbooking.NoAccessException;
import com.Onlineseatbooking.Onlineseatbooking.ResourceNotFoundException;
import com.Onlineseatbooking.Onlineseatbooking.model.Role;
import com.Onlineseatbooking.Onlineseatbooking.model.User;
import com.Onlineseatbooking.Onlineseatbooking.repository.RoleRepository;
import com.Onlineseatbooking.Onlineseatbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
    @RequestMapping("/api/auth")
    public class UserProfileController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public List<User> get() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User save(@RequestBody User new_user) {
        return userRepository.save(new_user);
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable long id) {
        Optional<User> new_user = userRepository.findById(id);
        if (new_user.isPresent()) {
            return new_user.get();
        } else {
            throw new RuntimeException("User not found for the id : " + id);
        }
    }


    @PutMapping("/user/{id}")
    public User update(@RequestBody User new_user, @PathVariable long id) throws CustomerNotFoundException,NoAccessException {
        Optional<User> user = userRepository.findById(id);
        if(new_user.getName() == null){
            String name= user.get().getName();
            new_user.setName(name);
        }
        if(new_user.getEmail() == null){
            String mail= user.get().getEmail();
            new_user.setEmail(mail);
        }
        if(new_user.getUsername() == null){
            String uname= user.get().getUsername();
            new_user.setUsername(uname);
        }
        if(new_user.getId() != id) {throw new NoAccessException("Can't change Id");}
        if(new_user.getPassword() != null) {throw new NoAccessException("No Access To Change Password");}

        if(new_user.getRoles() == null){
            Set<Role> roll = user.get().getRoles();
            new_user.setRoles(roll);
        }

        new_user.setPassword(user.get().getPassword());
        return userRepository.save(new_user);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id) throws CustomerNotFoundException{
        Optional<User> new_user = userRepository.findById(id);
        if (new_user == null) {
            userRepository.delete(new_user.get());
            return "User is deleted with id " + id;
        } else {
            throw new CustomerNotFoundException("User not found for the id " + id);
        }
    }

    @PutMapping("/edit/{id}")
    public String update_User(@RequestBody User new_user, BindingResult bindingResult, @PathVariable("id") Long userId) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(new_user.getPassword());
        new_user = user.get();
        new_user.setPassword(encodedPassword);

        userRepository.save(new_user);

        return "Password Updated";
    }

}