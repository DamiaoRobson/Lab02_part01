package exception;

public class EmailInvalidoException extends EntradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6714055897274410140L;

	public EmailInvalidoException() {
		super("Erro no cadastro de pessoa: Email invalido");
	}

	public EmailInvalidoException(String msg) {
		super("Erro no cadastro de pessoa: Email " + msg);
	}

}
