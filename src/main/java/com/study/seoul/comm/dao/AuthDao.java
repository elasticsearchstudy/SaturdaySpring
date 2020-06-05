package com.study.seoul.comm.dao;

import com.study.seoul.comm.vo.LoginVO;

public interface AuthDao {

	public void insertAuthCode(LoginVO vo);
	
	public String selectEmail(LoginVO vo);
	
	public LoginVO selectUserVO(LoginVO vo);
	
}
