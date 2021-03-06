package com.khd.jejulantis.admin.sms.Service;

import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.khd.jejulantis.admin.sms.DAO.SmsDao;
import com.khd.jejulantis.model.Member;
@Service
public class SmsServiceImpl implements SmsService {
	@Autowired
	private SmsDao smaDao;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public void mailsendAllService(List<Member> tomails, String title, String content) {
		String setfrom = "gml7814@gmail.com"; //관리자 이메일 
		System.out.println("사용자 이메일 갯수 : " + tomails.size());
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
			for(int i=0;i<tomails.size();i++) {
				String emailList = tomails.get(i).getMember_email();
				messageHelper.addTo(emailList); // 보낼 사람의 이메일 여러명
			}
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content);  // 메일 내용     
			mailSender.send(message);
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Override
	public void mailsendSelectService(List<String> smsEmail, String title, String content) {
		String setfrom = "gml7814@gmail.com"; //관리자 이메일 
		System.out.println("사용자 이메일 갯수 : " + smsEmail.size());
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
			for(int i=0;i<smsEmail.size();i++) {
				System.out.println("smsEmail : " + smsEmail.get(i));
//				messageHelper.addTo(smsEmail.get(i)); // 보낼 사람의 이메일 여러명
				
				messageHelper.addTo(smsEmail.get(i));
//				messageHelper.addTo(emailList);
			}
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content);  // 메일 내용     
			System.out.println("error");
			mailSender.send(message);
		} catch(Exception e){
			System.out.println(e);
		}
	}
	@Override
	public void mailsendService(String tomail, String title, String content) {
		String setfrom = "gml7814@gmail.com"; //관리자 이메일
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.addTo(tomail);	 // 보낼 사람의 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content);  // 메일 내용     
			mailSender.send(message);
		} catch(Exception e){
			System.out.println(e);
		}
	}
	@Override
	public List<Member> emailSenderListService() {
		return smaDao.emailSenderList();
	}
	@Override
	public List<Member> listService() {
		return smaDao.list();
	}
}
