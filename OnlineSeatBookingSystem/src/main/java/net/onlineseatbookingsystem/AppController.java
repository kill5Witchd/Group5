package net.onlineseatbookingsystem;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class AppController {
	@Autowired
	private UserRepository repo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
    	
    	model.addAttribute("user", new User());
    	return "signup_form";
    }
    
    
    
    
    
    
    
    @GetMapping("/user_home")
    public String showUserHome(Model model) {
    	
    	model.addAttribute("user", new User());
    	return "userlogin_home";
    }
    
    
    
    
    
    
    
    
    
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";
    }
    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
    	List<User> listUsers = repo.findAll();
    	model.addAttribute("listUsers",listUsers);
    	
    	return "users";
    }
}
