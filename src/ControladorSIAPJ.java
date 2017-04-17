
public class ControladorSIAPJ{
	private ValidadorProcesso validator = new ValidadorProcesso();
	private MailFactory factory = new MailFactory();
	
	public boolean initProcesso(Processo proc){
		return initProcesso(proc, false);
	}
	
	public boolean initProcesso(Processo proc, boolean useLetter)
	{
		if(!checkProcesso(proc)){
			sendInfo(proc, false, "email");
			if (useLetter){
				sendInfo(proc, false, "letter");
			}
			return false;
		}
		
		persistProcesso(proc);
		sendInfo(proc, true, "email");
		if (useLetter){
			sendInfo(proc, true, "letter");
		}
		
		return true;
	}
	
	private boolean checkProcesso(Processo proc){
		return validator.validateProcess(proc);
	}
	
	private Processo persistProcesso(Processo proc){
		return proc;
	}
	
	private void sendInfo(Processo proc, boolean statusProcesso, String channel){
		ServiceMail mail = factory.getServiceMail(channel);
		
		if (statusProcesso)
		{
			mail.defineContent(proc.getContent());
			mail.defineSender("default_sender");
			mail.send("Juiz");
		}
		else
		{
			mail.defineContent("Erro");
			mail.defineSender("default_sender");
			mail.send(proc.getNomeReclamante());
		}
	}
}
