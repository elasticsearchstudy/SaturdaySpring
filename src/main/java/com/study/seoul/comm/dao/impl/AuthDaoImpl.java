package com.study.seoul.comm.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.seoul.comm.dao.AuthDao;
import com.study.seoul.comm.vo.LoginVO;

@Repository
public class AuthDaoImpl implements AuthDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "mappers.authdao-mapper";

	@Override
	public void insertAuthCode(LoginVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".u000", vo);
	}

	@Override
	public String selectEmail(LoginVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".s000", vo);
	}

	@Override
	public LoginVO selectUserVO(LoginVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".s001", vo);
	}
	
}
