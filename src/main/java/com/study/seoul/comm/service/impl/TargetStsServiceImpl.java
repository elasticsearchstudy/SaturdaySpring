package com.study.seoul.comm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.seoul.comm.dao.TargetStsDao;
import com.study.seoul.comm.service.TargetStsService;
import com.study.seoul.comm.vo.TargetStsVO;
@Service("targetStsService")
public class TargetStsServiceImpl implements TargetStsService {
	

	@Autowired
	private TargetStsDao targetStsDao;
	
	/**
	 * Register Target Data
	 */
	@Override
	public void registerTargetStsInfo(TargetStsVO tgtVo) {
		// TODO Auto-generated method stub
		int seq = targetStsDao.getNextSeq();
		tgtVo.setSeq(seq);
		targetStsDao.regTargetStsData(tgtVo);
	}

	
}
