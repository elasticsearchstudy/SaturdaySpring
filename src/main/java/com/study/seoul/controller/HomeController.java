package com.study.seoul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.seoul.dao.impl.ExampleDao;

@Controller
public class HomeController {
	
	private ExampleDao dao;
	
	@Autowired
	public void HomeController( ExampleDao dao) {
		this.dao = dao;
	}

	
	@RequestMapping(value = "/", method =RequestMethod.GET)
	public String home(Model model) {
		String result ="";
		try {
			result= dao.selectTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("text", result);
		return "index";
	}

	@GetMapping("/healthcheck")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "healthcheck";
	}
}
