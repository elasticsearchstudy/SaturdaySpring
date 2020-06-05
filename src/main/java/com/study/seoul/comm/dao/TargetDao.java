package com.study.seoul.comm.dao;

import java.util.List;

import com.study.seoul.comm.vo.TargetVO;

public interface TargetDao {

	// Inquiry Target List
	public List<TargetVO> getTargetList(TargetVO tgtVo);
	
	// Modify Target Info
	public void modifyTargetInfo(TargetVO tgtVo);
	
	// get Target Data
	public TargetVO getTargetData(TargetVO tgtVo);
	
	// Register Target Data
	public void regTargetData(TargetVO tgtVo);
	
	// get Next Seq
	public int getNextSeq();
	
	// delete Target Data
	public void delTargetInfo(TargetVO tgtVo);
}
