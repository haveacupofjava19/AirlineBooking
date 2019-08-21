package com.saket.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saket.flightreservation.entities.User;
import com.saket.flightreservation.repositories.UserRepository;
import com.saket.flightreservation.services.SecurityService;

@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private SecurityService securityService;

	@RequestMapping("/showRegistration")
	public String showRegistrationPage() {
		LOGGER.info("inside showRegistration()");
		return "login/registerUser";
	}

	@RequestMapping(value="registerUser", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {
		LOGGER.info("inside registerUser()"+user);
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("inside showLogin()");
		return "login/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(@RequestParam("email")String email,@RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("inside login(): email"+email+" pwd: "+password);
		boolean loginRes = securityService.login(email, password);
		
		if(loginRes) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg", "Invalid username or password");
		}
		return "login/login";
	}
}
