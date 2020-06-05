package com.study.seoul.comm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.seoul.comm.service.AuthUtilService;
import com.study.seoul.comm.service.impl.SendNoticeServiceImpl;
import com.study.seoul.comm.util.CommonUtil;
import com.study.seoul.comm.vo.LoginVO;
import com.study.seoul.comm.vo.SendMailVO;
import com.study.seoul.dao.impl.ExampleDao;

@Controller
public class AuthController {
	
	@Autowired
	private SendNoticeServiceImpl sendNotice;
	
	@Autowired
	private AuthUtilService authUtilService;
	
	@Autowired
	private HttpSession session;
	
	private ExampleDao dao;
	
	@Autowired
	public void AuthController( ExampleDao dao) {
		this.dao = dao;
	}

	/**
	 * Login 페이지 오픈 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginPage")
	public String loginPage(Model model) {
		return "login";
	}
	
	
	/**
	 * Login을 위한 사용자 ID에 대한 Auth코드를 생성 및 발송
	 * @param logVo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginAction")
	public String loginAction(@ModelAttribute LoginVO logVo, Model model) {
		// Login VO의 필드와 jsp Form의 name과 자동매ㅓ핑
		try {
			// 1. User Id 조회
			String email = authUtilService.selectEmail(logVo);  
			if(null == email  
					|| email.equals("")){
				throw new Exception("No Email Address");
			}
			
			// 2. set mail Contents
			SendMailVO mail = new SendMailVO();
			mail.setSendDate(CommonUtil.getCurrentDateAndTime("yyyyMMdd"));
			mail.setRecvMailAddr(email);
			mail.setMailSubject("Auth Info Maile");
			String code = authUtilService.makeAuthCode(7);
			String secStr = "Security Code : " + code;
			mail.setMailText("please type this text and type in a minute. [" +secStr+ "]");
			

			// 3. auth code update to table
			LoginVO insVo = new LoginVO();
			insVo.setUserId(logVo.getUserId());
			insVo.setPasswd(code);
			authUtilService.setAuthCodeToUser(insVo);
			
			
			// 4. send mail
			sendNotice.sendEmail(mail);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		// 4. 화면 이동
		model.addAttribute("userId", logVo.getUserId());
		return "auth";
	}
	
	/**
	 * 사용자 ID와 코드로 검증 후 session 생성
	 * @param logVo
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/loginAuth")
	public String loginAuth(@ModelAttribute LoginVO logVo, Model model) {
		// Make session
		try {
			// 1. Check Auth code with User id
			LoginVO selVo = authUtilService.selectUserVo(logVo);
			
			if(null == selVo) {
				throw new Exception("Not matching auth Code with User ID");
			}
			
			// 2. Make Sessiong
			selVo.setPasswd(null);
			session.setAttribute("loginVo", selVo);
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "screen1";
	}
	
	@RequestMapping(value="/screen2")
	public String screen2(@ModelAttribute LoginVO logVo, Model model) {
		
		return "screen2";
	}
	
	@RequestMapping(value="/screen1")
	public String screen1(@ModelAttribute LoginVO logVo, Model model) {
		
		return "screen1";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value="/error")
	public String error(Model model) {
		return "error";
	}
}
