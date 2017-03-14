package exception;

public class CpfInvalidoException extends EntradaException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3720515592303732653L;

	public CpfInvalidoException() {
		super("Erro no cadastro de pessoa: CPF invalido");
	}
	
	public CpfInvalidoException(String msg) {
		super("Erro no cadastro de pessoa: CPF " + msg);
	}

}
