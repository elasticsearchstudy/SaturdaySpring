package com.study.seoul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.seoul.comm.service.impl.SendNoticeServiceImpl;
import com.study.seoul.comm.vo.SendMailVO;
import com.study.seoul.dao.impl.ExampleDao;

@Controller
public class HomeController {
	
	@Autowired
	private SendNoticeServiceImpl sendNotice;
	
	
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
			
			
			
			SendMailVO mail = new SendMailVO();
			mail.setSendDate("20200320");
			mail.setRecvMailAddr("spinut14@gmail.com");
			mail.setMailSubject("Test Mail Send");
			mail.setMailText("system is unstable please check it.");
			System.out.println(mail.getRegDate());
			System.out.println(mail.getRegTime());
			System.out.println(mail.getChgDate());
			System.out.println(mail.getChgTime());
			System.out.println(mail.getTrxId());
			sendNotice.sendEmail(mail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("text", result);
		return "index";
	}

}
