package net.codejava.login;

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
	public String viewHomePage()
	{
		return "index";
	}
	@GetMapping("/list_users")
	public String viewUsersList(Model model)
	{
		List<User> listUsers = repo.findAll();
    	model.addAttribute("listUsers",listUsers);
    	return "users";
	}
	@GetMapping("/user_home")
	public String showUserHome(Model model)
	{
		//List<User> listUsers=repo.findAll();
		model.addAttribute("user",new User());
		
		return "userlogin_home";
	}
	@GetMapping("/logout")
	public String viewLogout()
	{
		return "user_logout";
	}
	
	
}
