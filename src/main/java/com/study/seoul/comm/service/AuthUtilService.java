package com.study.seoul.comm.service;

import com.study.seoul.comm.vo.LoginVO;

public interface AuthUtilService {

	public void setAuthCodeToUser(LoginVO vo);
	
	public String makeAuthCode(int len);
	
	public String selectEmail(LoginVO vo);
	
	public LoginVO selectUserVo(LoginVO vo);
	
}
