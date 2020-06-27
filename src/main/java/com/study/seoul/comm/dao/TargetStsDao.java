package com.study.seoul.comm.dao;

import com.study.seoul.comm.vo.TargetStsVO;

public interface TargetStsDao {

	// Register Target Data
	public void regTargetStsData(TargetStsVO tgtVo);
	
	// get Next Seq
	public int getNextSeq();
	
}
