package com.study.seoul.comm.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.seoul.comm.dao.TargetStsDao;
import com.study.seoul.comm.vo.TargetStsVO;
@Repository
public class TargetStsDaoImpl implements TargetStsDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "mappers.targetstsdao-mapper";

	
	/**
	 * register Target Data
	 */
	@Override
	public void regTargetStsData(TargetStsVO tgtVo) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".i000", tgtVo);
	}

	/**
	 * get Next Seq
	 */
	@Override
	public int getNextSeq() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".s001");
	}

}
