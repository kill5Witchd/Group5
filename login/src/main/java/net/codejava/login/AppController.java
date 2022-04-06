package net.codejava.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	@GetMapping("")
	public String viewHomePage()
	{
		return "index";
	}
	@GetMapping("/list_users")
	public String viewUsersList()
	{
		//List<User> listUsers=repo.findAll();
		//model.addAttribute("listUsers",attributeValue);
		return "users";
	}
	
}
