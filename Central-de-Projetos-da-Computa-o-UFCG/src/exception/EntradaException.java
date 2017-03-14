package exception;

public class EntradaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2092520226713795751L;

	public EntradaException() {
		super("Entrada Invalida!");
	}
	
	public EntradaException(String msg) {
		super(msg);
	}

}
