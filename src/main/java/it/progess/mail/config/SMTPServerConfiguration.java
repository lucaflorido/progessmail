package it.progess.mail.config;

public class SMTPServerConfiguration {
	private String auth;
	private String starttls;
	private String host;
	private String port;
	public SMTPServerConfiguration(){
		
	}
	public SMTPServerConfiguration(String auth,String starttls,String host){
		this.auth = auth;
		this.starttls = starttls;
		this.host = host;
	}
	public SMTPServerConfiguration(String auth,String starttls,String host,String port){
		this.auth = auth;
		this.starttls = starttls;
		this.host = host;
		this.port = port;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getStarttls() {
		return starttls;
	}
	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
}
