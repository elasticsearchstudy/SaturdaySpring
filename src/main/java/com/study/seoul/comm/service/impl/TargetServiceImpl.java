package com.study.seoul.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.seoul.comm.dao.TargetDao;
import com.study.seoul.comm.service.TargetService;
import com.study.seoul.comm.vo.TargetVO;
@Service("targetService")
public class TargetServiceImpl implements TargetService {
	

	@Autowired
	private TargetDao targetDao;
	

	/**
	 * Inquiry Target system List
	 */
	@Override
	public List<TargetVO> getTargetList(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		List<TargetVO> tgtList = targetDao.getTargetList(tgtVo);
		return tgtList;
	}
	
	/**
	 * modify Target Info
	 */
	@Override
	public void modifyTargetInfo(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		targetDao.modifyTargetInfo(tgtVo);
		
	}

	
	/**
	 * get Target Data  
	 */
	@Override
	public TargetVO getTargetData(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		return targetDao.getTargetData(tgtVo);
	}
	
	/**
	 * Register Target Data
	 */
	@Override
	public void registerTargetInfo(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		int seq = targetDao.getNextSeq();
		System.out.println("SEQ  : " + seq);
		tgtVo.setSeq(seq);
		targetDao.regTargetData(tgtVo);
	}

	
	/**
	 * Delete Target Data 
	 */
	@Override
	public void delTargetInfo(TargetVO tgtVo) {
		// TODO Auto-generated method stub
		
	}
	
}
