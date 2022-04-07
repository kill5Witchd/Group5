package com.Onlineseatbooking.Onlineseatbooking.controller;

import com.Onlineseatbooking.Onlineseatbooking.DTO.LoginDto;
import com.Onlineseatbooking.Onlineseatbooking.DTO.SignUpDto;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.Onlineseatbooking.Onlineseatbooking.ResourceNotFoundException;
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
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    //Register/SignUp REST API
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
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
    @GetMapping("/get")
    public List<User> getDetails() {
      return this.userRepository.findAll();
    }
//    @SuppressWarnings("unlikely-arg-type")
//    @GetMapping("/edit/{username}")
//    public String updateUser(@PathVariable("username") String username, Model model) throws ResourceNotFoundException {
//        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Invalid user id :" + username));
//        model.addAttribute(user);
//        userRepository.equals(user);
//        return "update_user";
//    }
//
//    @PutMapping("/edit/{username}")
//    public String update_User(User user) throws ResourceNotFoundException {
//
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
//
//         String encodedconfirmPassword = passwordEncoder.encode(user.getPassword());
//         user.setPassword(encodedconfirmPassword);
//        //userRepository.save(user);
//
//        return "updateSuccess";
//    }
//
//
//     Delete
//    @GetMapping("/users/{id}")
//   public String deleteUser(@PathVariable("id") long id, Model model) {
//        User user = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        userRepo.delete(user);
//        return "redirect:/users";
//    }
@GetMapping("/user")
public List<User> get(){
    return userRepository.findAll();
}

    @PostMapping("/user")
    public User save(@RequestBody User userrr) {
        return userRepository.save(userrr);
    }

    @GetMapping("/user/{id}")
    public User get(@PathVariable long id) {
        Optional<User> userrr = userRepository.findById(id);
        if(userrr.isPresent()) {
            return userrr.get();
        }else {
            throw new RuntimeException("User not found for the id "+id);
        }
    }


    @PutMapping("/user/{id}")
    public User update(@RequestBody User userr){
        return userRepository.save(userr);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable long id) {
        Optional<User> userrr = userRepository.findById(id);
        if(userrr.isPresent()) {
            userRepository.delete(userrr.get());
            return "User is deleted with id "+id;
        }else {
            throw new RuntimeException("User not found for the id "+id);
        }
    }



}
