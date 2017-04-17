
public class MailFactory {
	public ServiceMail getServiceMail(String service)
	{
		if (service == "mail" || service == "letter")
		{
			return new MailSender();
		}
		if (service == "email")
		{
			return new EmailSender();
		}
		return null;
	}
}
