package com.study.seoul.comm.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.seoul.comm.dao.TargetDao;
import com.study.seoul.comm.vo.TargetVO;
@Repository
public class TargetDaoImpl implements TargetDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "mappers.targetdao-mapper";

	/**
	 * Inquiry Target Info List
	 */
	@Override
	public List<TargetVO> getTargetList(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".r000", tgtVo);
	}
	
	/**
	 * Modify Target Info
	 */
	@Override
	public void modifyTargetInfo(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".u000", tgtVo);
		
	}

	/**
	 * get Target Data
	 */
	@Override
	public TargetVO getTargetData(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".s000", tgtVo);
	}

	
	/**
	 * register Target Data
	 */
	@Override
	public void regTargetData(TargetVO tgtVo) {
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

	/**
	 * delete Target Data 
	 */
	@Override
	public void delTargetInfo(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".d000", tgtVo);
		
	}
	
}
