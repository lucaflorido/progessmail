package it.progess.mail.runner;

import it.progess.mail.config.SMTPServerConfiguration;
import it.progess.mail.message.EMailMessage;

import java.util.Properties;













import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




public class EMailSender {
	public static void send(EMailMessage email,SMTPServerConfiguration config,String password,boolean html) throws MessagingException{
		  // Get system properties
	      Properties props = new Properties();
			props.put("mail.smtp.auth", config.getAuth());
			props.put("mail.smtp.starttls.enable", config.getStarttls());
			props.put("mail.smtp.host", config.getHost());
			props.put("mail.smtp.ssl.trust", config.getHost());
			if (config.getPort() != null && config.getPort().equals("") == false){
				props.put("mail.smtp.port", config.getPort());
			}else{
				props.put("mail.smtp.port", "25");
			}
			final String passwordAuth = password;
			final String userid = email.getFrom();
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userid, passwordAuth);
				}
			  });
		
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(email.getFrom()));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(email.getTo()));

	         // Set Subject: header field
	         message.setSubject(email.getSubject());

	         // Now set the actual message
	         if (html == false){
	        	 message.setText(email.getBody());
	         }else{
	        	 message.setText(email.getBody(),"utf-8","html");
	         }
	         // Send message
	        
	         Transport t = session.getTransport("smtp");
	         t.connect();
	         t.sendMessage(message, message.getAllRecipients());
	         
	         System.out.println("Sent message successfully....");
	      
	}
	public static void send(EMailMessage email,SMTPServerConfiguration config,String password,String attachment,boolean html) throws MessagingException{
		  // Get system properties
	      Properties props = new Properties();
			props.put("mail.smtp.auth", config.getAuth());
			props.put("mail.smtp.starttls.enable", config.getStarttls());
			props.put("mail.smtp.host", config.getHost());
			props.put("mail.smtp.ssl.trust", config.getHost());
			if (config.getPort() != null && config.getPort().equals("") == false){
				props.put("mail.smtp.port", config.getPort());
			}else{
				props.put("mail.smtp.port", "25");
			}
						/*
			mail.smtp.host=smtps.aruba.pec.it
					mail.smtp.socketFactory.port=465
					mail.smtp.socketFactory.class=javax.net.ssl.SSLSoc ketFactory
					mail.smtp.auth=true
					mail.smtp.port=465
					mail.mime.charset=ISO-8859-15
					nomeutente=miauser
					password=miapassword
					from-address=mio indirizzo
					from-name=mio nome
*/
			//props.put("mail.smtp.port", "587");
			final String passwordAuth = password;
			final String userid = email.getFrom();
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userid, passwordAuth);
				}
			  });
		
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(email.getFrom()));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(email.getTo()));

	         // Set Subject: header field
	         message.setSubject(email.getSubject());

	         // Now set the actual message
	      // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         
	         if (html == false){
	        	// message.setText(email.getBody());
	        	 messageBodyPart.setText(email.getBody());
	         }else{
	        	// message.setText(email.getBody(),"utf-8","html");
	        	messageBodyPart.setContent(email.getBody(), "text/html");
	        	//message.saveChanges();
	         }
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = attachment;
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         Transport t = session.getTransport("smtp");
	         t.connect();
	         t.sendMessage(message, message.getAllRecipients());
	         
	         System.out.println("Sent message successfully....");
	      
	}
	public static void sendpec(EMailMessage email,SMTPServerConfiguration config,String password,boolean html) throws MessagingException{
		  // Get system properties
	      Properties props = new Properties();
	      props.put("mail.smtp.host", config.getHost());
	      props.put("mail.smtp.socketFactory.port", config.getPort());
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", config.getAuth());
		  props.put("mail.smtp.port", config.getPort());
		  props.put("mail.mime.charset","ISO-8859-15");
		  final String passwordAuth = password;
			final String userid = email.getFrom();
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userid, passwordAuth);
				}
			  });
		
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(email.getFrom()));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(email.getTo()));

	         // Set Subject: header field
	         message.setSubject(email.getSubject());

	         // Now set the actual message
	         if (html == false){
	        	 message.setText(email.getBody());
	         }else{
	        	 message.setText(email.getBody(),"utf-8","html");
	        	
	         }

	         // Send message
	        
	         Transport t = session.getTransport("smtps");
	         t.connect(config.getHost(),userid,password);
	         t.sendMessage(message, message.getAllRecipients());
	         
	         System.out.println("Sent message successfully....");
	      
	}
	public static void sendpec(EMailMessage email,SMTPServerConfiguration config,String password,String attachment,boolean html) throws MessagingException{
		  // Get system properties
	      Properties props = new Properties();
	      props.put("mail.smtp.host", config.getHost());
	      props.put("mail.smtp.socketFactory.port", config.getPort());
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", config.getAuth());
		  props.put("mail.smtp.port", config.getPort());
		  props.put("mail.mime.charset","ISO-8859-15");
			
						/*
			mail.smtp.host=smtps.aruba.pec.it
					mail.smtp.socketFactory.port=465
					mail.smtp.socketFactory.class=javax.net.ssl.SSLSoc ketFactory
					mail.smtp.auth=true
					mail.smtp.port=465
					mail.mime.charset=ISO-8859-15
					nomeutente=miauser
					password=miapassword
					from-address=mio indirizzo
					from-name=mio nome
*/
			//props.put("mail.smtp.port", "587");
			final String passwordAuth = password;
			final String userid = email.getFrom();
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userid, passwordAuth);
				}
			  });
		
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(email.getFrom()));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(email.getTo()));

	         // Set Subject: header field
	         message.setSubject(email.getSubject());

	         // Now set the actual message
	      // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();
	         if (html == false){
	        	 message.setText(email.getBody());
	         }else{
	        	 message.setText(email.getBody(),"utf-8","html");
	        	
	         }
	         // Now set the actual message
	         messageBodyPart.setText(email.getBody());

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = attachment;
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         Transport t = session.getTransport("smtps");
	         t.connect(config.getHost(),userid,password);
	         t.sendMessage(message, message.getAllRecipients());
	         
	         System.out.println("Sent message successfully....");
	      
	}
}
