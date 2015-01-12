package com.rirs.drazba.web.mannagedbeans;

import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
@LocalBean
public class Mail {

	//@Resource(mappedName = "java:jboss/mail/SampleMS_With_GmailUser")
	//Session mailSession;

	public void posljiMail(String zadeva, String vsebina, String prejemenik) {
		/**
		try {
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress("rirsspletnadrazba@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(prejemenik));
			message.setSubject(zadeva);
			message.setContent(vsebina, "text/plain");
			Transport.send(message);

			System.out.println("Mail Sent Successfully.");
		} catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		}*/

		final String username = "rirsspletnadrazba@gmail.com";
		final String password = "RIRSspletna";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rirsspletnadrazba@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(prejemenik));
			message.setSubject(zadeva);
			message.setText(vsebina);

 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
