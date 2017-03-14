package projeto;

import exception.DataInicioInvalidoException;
import exception.DuracaoInvalidaException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;
import exception.PesquisaInvalidaException;

public class Extensao extends Projeto {
	private int impacto;

	public Extensao(String nome, String objetivo,int impacto, String dataInicio, int duracao, String cod) throws NomeInvalidoException, DataInicioInvalidoException, DuracaoInvalidaException, ObjetivoInvalidoException {
		super(nome, objetivo, dataInicio, duracao, cod);
		this.impacto = impacto;
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
		case "impacto":
			return saida += getImpacto();
		case "participacoes":
			return getParticipantes();
		default:
			String erroMsg = String.format("Erro na consulta de projeto: Entensao nao possui %s", atributo);
			throw new PesquisaInvalidaException(erroMsg);
		}
	}
	
	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}
}
