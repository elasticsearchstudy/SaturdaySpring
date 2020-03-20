package com.study.seoul.comm.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.seoul.comm.dao.SendNoticeDao;
import com.study.seoul.comm.vo.SendMailVO;

@Repository
public class SendNoticeDaoImpl implements SendNoticeDao {

	@Autowired
	private SqlSessionTemplate sqlSession;;
	
	private static final String NAMESPACE = "mappers.mydao-mapper";

	@Override
	public void insertSendMail(SendMailVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".i000", vo);
	}

	@Override
	public Integer selectMaxSeq() {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+".s001");
	}
	
}
