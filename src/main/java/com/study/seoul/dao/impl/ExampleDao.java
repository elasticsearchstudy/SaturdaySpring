package com.study.seoul.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public String selectTest() throws Exception{
		return sqlSession.selectOne("mappers.mydao-mapper.s000").toString();
	}
}
