package exception;

public class CategoriaInvalidoException extends EntradaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -491815434707773154L;

	public CategoriaInvalidoException() {
		super("Cadegoria invalida");
	}
	
	public CategoriaInvalidoException(String msg) {
		super(msg);
	}
}
