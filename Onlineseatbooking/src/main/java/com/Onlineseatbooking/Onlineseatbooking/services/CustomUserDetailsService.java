package com.Onlineseatbooking.Onlineseatbooking.services;

import com.Onlineseatbooking.Onlineseatbooking.CustomerNotFoundException;

import com.Onlineseatbooking.Onlineseatbooking.model.Role;
import com.Onlineseatbooking.Onlineseatbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        com.Onlineseatbooking.Onlineseatbooking.model.User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }
    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

//    public void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException {
//        User customer = userRepository.findByEmail(email);
//        if (customer != null) {
//            customer.setResetPasswordToken(token);
//            userRepository.save(customer);
//        } else {
//            throw new CustomerNotFoundException("Could not find any customer with the email " + email);
//        }
//    }
//
//    public User getByResetPasswordToken(String token) {
//        return userRepository.findByResetPasswordToken(token);
//    }
//
//    public void updatePassword(User customer, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        customer.setPassword(encodedPassword);
//
//        customer.setResetPasswordToken(null);
//        userRepository.save(customer);
//    }

}
