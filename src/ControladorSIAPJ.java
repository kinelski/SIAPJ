
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
		String nome = proc.getNomeReclamante();
		String tel = proc.getTelefone();
		//id deve ser uma string contendo apenas numeros
		if(!id.matches("[0-9]+"))
			return false;
		//nome deve conter apenas letras e espaços
		if(!nome.matches("[a-zA-Z ]+"))
			return false;
		//Telefone deve ser da forma (xx)xxxxx-xxxx
		if(!tel.matches("[(][0-9]{2}[)][0-9]{5}-[0-9]{4}"))
			return false;
		return true;
	}
}
