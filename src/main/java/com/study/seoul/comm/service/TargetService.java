package com.study.seoul.comm.service;

import java.util.List;

import com.study.seoul.comm.vo.TargetVO;

public interface TargetService {

	
	
	/** Inquiry Target List */
	public List<TargetVO> getTargetList(TargetVO tgtVo);
	
	/** Modify Target */
	public void modifyTargetInfo(TargetVO tgtVo);
	
	/** Get Target Data */
	public TargetVO getTargetData(TargetVO tgtVo);
	
	/** Register Target Data */
	public void registerTargetInfo(TargetVO tgtVo);
	
	/** Delete Target Data */
	public void delTargetInfo(TargetVO tgtVo);
	
}
