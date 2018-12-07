package com.auth.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
	private JavaMailSenderImpl mail;
	private boolean isSent;
	public boolean sendMail(String email, String message,String subject) 
	{
		
		try {
			MimeMessage mime_message = mail.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mime_message,false);
			helper.setTo(email);
			helper.setCc("naveenachari39@gmail.com");
			helper.setSubject("Registration");
			helper.setText("<b>YOU ARE SUCCESSFULLY REGISTERED..<b>",true);
			/*FileSystemResource file = new FileSystemResource("F:\\krish.jpg");
			helper.addAttachment("krish.jpg", file);*/
			mail.send(mime_message);
			System.out.println("email sent successfully");
		    isSent = true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSent;
		
	}

}
