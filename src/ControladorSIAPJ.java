
public class ControladorSIAPJ implements ValidadorProcesso{
	
	public boolean initProcesso(Processo proc){
		if(!checkProcesso(proc))
			return false;
		return true;
	}
	
	private boolean checkProcesso(Processo proc){
		return validateProcess(proc);
	}
	
	private Processo persistProcesso(Processo proc){
		return proc;
	}
	
	private void sendInfoByEmail(Processo proc, boolean statusProcesso){
		
	}
	
	public boolean validateProcess(Processo proc){
		String id = Integer.toString(proc.getId());
		//id deve ser uma string contendo apenas numeros
		if(!id.matches("[0-9]+"))
			return false;
		return true;
	}
}
