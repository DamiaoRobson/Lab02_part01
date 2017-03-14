package exception;

public class NomeInvalidoException extends EntradaException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7161861505814726678L;

	public NomeInvalidoException() {
		super("Erro no cadastro de pessoa: Nome nulo ou vazio");
	}
	
	public NomeInvalidoException(String msg) {
		super(msg);
	}

}
