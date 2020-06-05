package com.study.seoul.comm.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class COMMVO {
	private transient SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public COMMVO(){
		Date dt = new Date();
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		trxId = dtFormat.format(dt) + n; 
		regDate = dtFormat.format(dt).substring(0, 8);
		regTime = dtFormat.format(dt).substring(8);
		chgDate = dtFormat.format(dt).substring(0, 8);
		chgTime = dtFormat.format(dt).substring(8);
	}
	
	private String trxId;
	private String regDate;
	private String regTime;
	private String chgDate;
	private String chgTime;
	public String getTrxId() {
		return trxId;
	}
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getChgDate() {
		return chgDate;
	}
	public void setChgDate(String chgDate) {
		this.chgDate = chgDate;
	}
	public String getChgTime() {
		return chgTime;
	}
	public void setChgTime(String chgTime) {
		this.chgTime = chgTime;
	}
	

}
