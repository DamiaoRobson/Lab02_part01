package projeto;

import exception.DataInicioInvalidoException;
import exception.DuracaoInvalidaException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;
import exception.PesquisaInvalidaException;

public class PET extends Projeto {
	private int impacto;
	private double rendimento;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	

	public PET(String nome, String objetivo, int impacto, double rendimento, int prodTecnica, int prodAcademica, int patentes, String dataInicio, int duracao, String cod) throws NomeInvalidoException, DataInicioInvalidoException, DuracaoInvalidaException, ObjetivoInvalidoException {
		super(nome, objetivo, dataInicio, duracao, cod);
		
		this.impacto = impacto;
		this.prodAcademica = prodAcademica;
		this.prodTecnica = prodTecnica;
		this.rendimento = rendimento;
		this.patentes = patentes;
	}


	@Override
	public String getInfo(String atributo) throws PesquisaInvalidaException {
		String saida = "";
		String atr = atributo.toLowerCase();
		
		switch (atr) {
		case "nome":
		case "duracao":
		case "data de inicio":
		case "objetivo":
			return super.getInfo(atr);
		case "producao tecnica":
			return saida += getProdTecnica();
		case "producao academica":
			return saida += getProdAcademica();
		case "patente":
			return saida += getPatentes();
		case "impacto":
			return saida += getImpacto();
		case "rendimento":
			return saida += getRendimento();
		case "participacoes":
			return getParticipantes();
		default:
			String erroMsg = String.format("Erro na consulta de projeto: PET nao possui %s", atributo);
			throw new PesquisaInvalidaException(erroMsg);
		}
	}	
	
	public int getImpacto() {
		return impacto;
	}


	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}


	public double getRendimento() {
		return rendimento;
	}


	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}


	public int getProdTecnica() {
		return prodTecnica;
	}


	public void setProdTecnica(int prodTecnica) {
		this.prodTecnica = prodTecnica;
	}


	public int getProdAcademica() {
		return prodAcademica;
	}


	public void setProdAcademica(int prodAcademica) {
		this.prodAcademica = prodAcademica;
	}


	public int getPatentes() {
		return patentes;
	}


	public void setPatentes(int patentes) {
		this.patentes = patentes;
	}
	
	

}
