package exception;

public class AtualizacaoInvalidaException extends EntradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1022938055736568369L;
	
	public AtualizacaoInvalidaException(String msg) {
		super("Erro na atualizacao de pessoa: " + msg);
	}

}
