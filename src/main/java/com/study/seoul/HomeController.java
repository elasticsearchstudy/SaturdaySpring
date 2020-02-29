package com.study.seoul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method =RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("text", "Test Spring page ");
		return "index";
	}

}
