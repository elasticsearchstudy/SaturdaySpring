package com.study.seoul.comm.vo;

public class TargetStsVO extends COMMVO{

	private int seq;
	private String tgSite;
	private String trnDt;
	private String siteStatus;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTgSite() {
		return tgSite;
	}
	public void setTgSite(String tgSite) {
		this.tgSite = tgSite;
	}
	public String getTrnDt() {
		return trnDt;
	}
	public void setTrnDt(String trnDt) {
		this.trnDt = trnDt;
	}
	public String getSiteStatus() {
		return siteStatus;
	}
	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}


	
}
