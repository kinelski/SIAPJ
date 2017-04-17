
public abstract class ServiceMail {
	protected String subject;
	protected String content;
	protected String sender;
	protected String password;
	
	abstract boolean send(String address);
	
	public String defineSubject(String subject) {
		this.subject = subject;
		return this.subject;
	}

	public String defineContent(String content) {
		this.content = content;
		return this.content;
	}
	
	public String defineSender(String sender) {
		this.sender= sender;
		return this.sender;
	}
	
	public String definePassword(String password) {
		this.password= password;
		return this.password;
	}
}
