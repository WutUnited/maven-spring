package tmn.cpg.wut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tmn.cpg.wut.model.UserProfile;
 
@Controller
@RequestMapping("/")
public class BaseController {
 
	@Autowired
	private UserProfile userProfile;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
		model.addAttribute("message", "Maven Project + Spring Hello!");
		return "welcome";
 
	}
 
	@RequestMapping(value="/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		System.out.println("Hello : "+name);
		
		String email = userProfile.getEmail(name);

		model.addAttribute("message", "Maven Project + Spring Hello! - " + name);
		model.addAttribute("email", "Your email : "+email);
		
		return "welcome";
 
	}
 
}
