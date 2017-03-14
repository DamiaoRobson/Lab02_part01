package exception;

public class PatenteInvalidaException extends EntradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3547322522206316640L;

	public PatenteInvalidaException() {
		super("Patente invalida!");
	}
	
	public PatenteInvalidaException(String msg) {
		super(msg);
	}
}
