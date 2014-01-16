package com.gceylan.rentacar.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage alertMailMessage;
	
	public void sendMail(String from, String to, String subject, String htmlBody) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");

			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			mimeMessage.setContent(htmlBody, "text/html; charset=UTF-8");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		mailSender.send(mimeMessage);
	}
	
	public void sendAlertMail(String alert) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
		mailMessage.setText(alert);
		mailSender.send(mailMessage);
		
	}

}
