package com.study.seoul.comm.dao;

import com.study.seoul.comm.vo.SendMailVO;

public interface SendNoticeDao {

	public void insertSendMail(SendMailVO vo);
	
	public Integer selectMaxSeq();
}
