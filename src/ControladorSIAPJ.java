
public class ControladorSIAPJ{
	private ValidadorProcesso validator = new ValidadorProcesso();
	
	
	public boolean initProcesso(Processo proc){
		if(!checkProcesso(proc))
			return false;
		return true;
	}
	
	private boolean checkProcesso(Processo proc){
		return validator.validateProcess(proc);
	}
	
	private Processo persistProcesso(Processo proc){
		return proc;
	}
	
	private void sendInfoByEmail(Processo proc, boolean statusProcesso){
		
	}
}
