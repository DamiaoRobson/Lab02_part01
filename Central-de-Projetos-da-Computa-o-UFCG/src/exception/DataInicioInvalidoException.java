package exception;

public class DataInicioInvalidoException extends EntradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -16400244717746504L;

	public DataInicioInvalidoException() {
		super("Data Invalida!");
	}
	
	public DataInicioInvalidoException(String message) {
		super(message);
	}	
}
