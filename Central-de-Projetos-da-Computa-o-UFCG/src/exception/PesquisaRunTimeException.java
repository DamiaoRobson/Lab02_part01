package exception;

public class PesquisaRunTimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4701998696080345893L;
	
	public PesquisaRunTimeException(){
		super("Item nao encontrado!");
	}
	
	public PesquisaRunTimeException(String msg){
		super(msg);
	}

}
