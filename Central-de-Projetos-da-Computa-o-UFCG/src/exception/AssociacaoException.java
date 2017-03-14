package exception;

public class AssociacaoException extends EntradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8563264991776118312L;

	public AssociacaoException() {
		super("Erro na associacao de pessoa a projeto: ");
	}
	
	public AssociacaoException(String msg) {
		super("Erro na associacao de pessoa a projeto: " + msg);
	}

}
