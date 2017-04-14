
public class ControladorSIAPJ{
	private ValidadorProcesso validator = new ValidadorProcesso();
	
	public boolean initProcesso(Processo proc){
		return initProcesso(proc, false);
	}
	
	public boolean initProcesso(Processo proc, boolean useLetter)
	{
		if(!checkProcesso(proc)){
			sendInfoByEmail(proc, false);
			if (useLetter){
				sendInfoByLetter(proc, false);
			}
			return false;
		}
		
		persistProcesso(proc);
		sendInfoByEmail(proc, true);
		if (useLetter){
			sendInfoByLetter(proc, true);
		}
		
		return true;
	}
	
	private boolean checkProcesso(Processo proc){
		return validator.validateProcess(proc);
	}
	
	private Processo persistProcesso(Processo proc){
		return proc;
	}
	
	private void sendInfoByLetter(Processo proc, boolean statusProcesso){
		DefaultSender mail = new DefaultSender();
		
		if (statusProcesso)
		{
			mail.defineContent(proc.getContent());
			mail.defineSender("default_sender");
			mail.sendMail("Juiz");
		}
		else
		{
			mail.defineContent("Erro");
			mail.defineSender("default_sender");
			mail.sendMail(proc.getNomeReclamante());
		}
	}
	
	private void sendInfoByEmail(Processo proc, boolean statusProcesso){
		DefaultSender mail = new DefaultSender();
		
		if (statusProcesso)
		{
			mail.defineContent(proc.getContent());
			mail.defineSender("default_sender");
			mail.sendEmail("juiz@ita.com");
		}
		else
		{
			mail.defineContent("Erro");
			mail.defineSender("default_sender");
			mail.sendEmail(proc.getEmail());
		}
	}
}
