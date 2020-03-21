package com.study.seoul.comm.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.seoul.comm.dao.SendNoticeDao;
import com.study.seoul.comm.service.SendNoticeService;
import com.study.seoul.comm.vo.SendMailVO;

@Service("sendNoticeImpl")
public class SendNoticeServiceImpl implements SendNoticeService{

	@Autowired
	private SendNoticeDao sendMail;
	
//	devstudyseoul@gmail.com		
	@Override
	public void sendEmail(SendMailVO sendVO) {
		// User info 
		final String user = "devstudyseoul@gmail.com";
		final String password = "dgqpemucudhgvllh";
		// gamil SMTP setting
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// Session 인스턴스 생성
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		
		// Transport 클래스를 사용하여 작성한 메시지 전달
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			// 수신자 메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendVO.getRecvMailAddr()));
			
			// subject
			message.setSubject(sendVO.getMailSubject());
			
			// Text
			message.setText(sendVO.getMailText());

			// send the message
			Transport.send(message);
			System.out.println("message sent Successfully....");
			
			sendMail.insertSendMail(sendVO);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public Integer selectMaxSeq() {
		// TODO Auto-generated method stub
		return sendMail.selectMaxSeq();
	}
	
}
