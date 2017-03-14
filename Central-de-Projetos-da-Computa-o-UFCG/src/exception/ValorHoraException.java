package exception;

public class ValorHoraException extends EntradaException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1602898480920881273L;

	public ValorHoraException() {
		super("Valor da Hora menor ou igual a zero!");
	}
	
	public ValorHoraException(String msg) {
		super(msg);
	}

}
