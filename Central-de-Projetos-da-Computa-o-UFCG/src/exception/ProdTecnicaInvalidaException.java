package exception;

public class ProdTecnicaInvalidaException extends EntradaException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5460111751340105827L;
	
	public ProdTecnicaInvalidaException() {
		super("Producao tecnica invalida!");
	}
	
	public ProdTecnicaInvalidaException(String msg) {
		super(msg);
	}
	
}
