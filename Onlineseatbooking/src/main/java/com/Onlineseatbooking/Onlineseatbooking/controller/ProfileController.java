package com.Onlineseatbooking.Onlineseatbooking.controller;
import com.Onlineseatbooking.Onlineseatbooking.Exceptions.CustomerNotFoundException;
import com.Onlineseatbooking.Onlineseatbooking.model.User;
import com.Onlineseatbooking.Onlineseatbooking.repository.RoleRepository;
import com.Onlineseatbooking.Onlineseatbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/user/{id}")
    public User get(@PathVariable long id) {
        Optional<User> new_user = userRepository.findById(id);
        if (new_user.isPresent()) {
            return new_user.get();
        } else {
            throw new RuntimeException("User not found for the id " + id);
        }
    }


    @PutMapping("/user/{id}")
    public User update(@RequestBody User new_user) {
        return userRepository.save(new_user);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id) throws CustomerNotFoundException{
        Optional<User> new_user = userRepository.findById(id);
        if (new_user.isPresent()) {
            userRepository.delete(new_user.get());
            return "User is deleted with id " + id;
        } else {
            throw new RuntimeException("User not found for the id " + id);
        }
    }
    @PutMapping("/edit/{id}")
    public String update_User(@RequestBody User new_user, BindingResult bindingResult, @PathVariable("id") Long userId) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(new_user.getPassword());
        new_user = user.get();
        new_user.setPassword(encodedPassword);
        userRepository.save(new_user);
        return "Password Updated";
    }
}