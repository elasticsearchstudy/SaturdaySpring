package com.study.seoul.comm.vo;

public class SendMailVO extends COMMVO{
	private int mailSeq;
	private String sendDate;
	private String recvMailAddr;
	private String mailSubject;
	private String mailText;
	public int getMailSeq() {
		return mailSeq;
	}
	public void setMailSeq(int mailSeq) {
		this.mailSeq = mailSeq;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getRecvMailAddr() {
		return recvMailAddr;
	}
	public void setRecvMailAddr(String recvMailAddr) {
		this.recvMailAddr = recvMailAddr;
	}
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public String getMailText() {
		return mailText;
	}
	public void setMailText(String mailText) {
		this.mailText = mailText;
	}
	
}
