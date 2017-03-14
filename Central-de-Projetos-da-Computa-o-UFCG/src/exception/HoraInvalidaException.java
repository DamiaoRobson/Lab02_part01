package exception;

public class HoraInvalidaException extends EntradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6571979472945514775L;

	public HoraInvalidaException() {
		super("Hora invalida");
	}
	
	public HoraInvalidaException(String msg) {
		super(msg);
	}

}
