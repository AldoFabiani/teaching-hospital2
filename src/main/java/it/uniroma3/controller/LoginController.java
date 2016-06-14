package it.uniroma3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class LoginController {
	@RequestMapping(value = "/logoutPage", method =	RequestMethod.GET)
	public String logoutPage() {
		return "index";
	}
	@RequestMapping(value = "/loginPage", method =	RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
}
