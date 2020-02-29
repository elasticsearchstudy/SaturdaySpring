package com.study.seoul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.seoul.dao.impl.ExampleDao;

@Controller
public class HomeController {
	
	@Autowired ExampleDao dao;
	
	@RequestMapping(value = "/", method =RequestMethod.GET)
	public String home(Model model) {
//		model.addAttribute("text", "Test Spring page ");
		try {
			model.addAttribute("text", dao.selectTest());
			System.out.println(dao.selectTest());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

}
