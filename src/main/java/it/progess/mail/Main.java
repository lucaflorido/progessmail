package it.progess.mail;

import it.progess.mail.config.SMTPServerConfiguration;
import it.progess.mail.message.EMailMessage;
import it.progess.mail.runner.EMailSender;

import javax.mail.MessagingException;



public class Main {
	public static void main(String[] args){
		System.out.println("Email sender");
		/*EMailMessage message = new EMailMessage("info@qgenerate.com","lucaflorido@gmail.com","Test Email","Test email tester");
		SMTPServerConfiguration config = new SMTPServerConfiguration("true","true","mail.qgenerate.com");
		try{
			EMailSender.send(message, config, "qgenerateinfo");
			System.out.println("Email success");
		}catch(MessagingException ex){
			System.out.println(ex.getMessage());
		}*/
		EMailMessage message = new EMailMessage("lucaflorido@hotmail.com","lucaflorido@gmail.com","Test Email","Test email tester");
		SMTPServerConfiguration config = new SMTPServerConfiguration("true","true","smtp.live.com");
		config.setPort("587");
		try{
			EMailSender.send(message, config, "svnf0rl0s",false);
			System.out.println("Email success");
		}catch(MessagingException ex){
			System.out.println(ex.getMessage());
		}
		/*EMailMessage message = new EMailMessage("lucaflorido@pec.it","lucaflorido@gmail.com","Test Email","Test email tester");
		SMTPServerConfiguration config = new SMTPServerConfiguration("true","true","smtps.pec.aruba.it");
		config.setPort("465");
		try{
			EMailSender.sendpec(message, config, "svnf0rl0s");
			System.out.println("Email success");
		}catch(MessagingException ex){
			System.out.println(ex.getMessage());
		}*/
		
	}
}
