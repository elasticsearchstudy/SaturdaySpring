package com.study.seoul.comm.service;

import com.study.seoul.comm.vo.SendMailVO;

public interface SendNoticeService {

	public void sendEmail(SendMailVO sendVO);
	
	public Integer selectMaxSeq();
}
