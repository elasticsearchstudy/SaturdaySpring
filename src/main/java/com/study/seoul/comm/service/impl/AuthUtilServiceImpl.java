package com.study.seoul.comm.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.seoul.comm.dao.AuthDao;
import com.study.seoul.comm.service.AuthUtilService;
import com.study.seoul.comm.vo.LoginVO;

@Service("authUtilService")
public class AuthUtilServiceImpl implements AuthUtilService{

	@Autowired
	private AuthDao authDao;
	
	
	
	
	@Override
	public void setAuthCodeToUser(LoginVO vo) {
		// TODO Auto-generated method stub
		authDao.insertAuthCode(vo);
	}



	@Override
	public String makeAuthCode(int len) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		Random rnd = new Random();
		for(int i=0; i<len; i++) {
			if(rnd.nextBoolean()) {
				str.append((char)((int)(rnd.nextInt(26)) + 97));
			}else {
				str.append((rnd.nextInt(10)));
			}
		}
		return str.toString();
	}



	@Override
	public String selectEmail(LoginVO vo) {
		// TODO Auto-generated method stub
		return authDao.selectEmail(vo);
	}



	@Override
	public LoginVO selectUserVo(LoginVO vo) {
		// TODO Auto-generated method stub
		return authDao.selectUserVO(vo);
	}
	
	
	
}
