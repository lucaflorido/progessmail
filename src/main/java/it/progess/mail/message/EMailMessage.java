package it.progess.mail.message;

import java.util.ArrayList;

public class EMailMessage {
	private String subject;
	private String body;
	private ArrayList<String> addresses;
	private String cc;
	private String to;
	private String cn;
	private String from;
	public EMailMessage(){
		
	}
	public EMailMessage(String from,String to,String subject,String body){
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	public EMailMessage(String from,String to,String cn,String subject,String body){
		this.from = from;
		this.to = to;
		this.cn = cn;
		this.subject = subject;
		this.body = body;
	}
	public EMailMessage(String from,ArrayList<String> addresses,String subject,String body){
		this.from = from;
		this.addresses = addresses;
		this.subject = subject;
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public ArrayList<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(ArrayList<String> addresses) {
		this.addresses = addresses;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String a) {
		this.to = a;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
}
