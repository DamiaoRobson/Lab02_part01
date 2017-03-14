package projeto;

import exception.CategoriaInvalidoException;
import exception.DataInicioInvalidoException;
import exception.DuracaoInvalidaException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;
import exception.PatenteInvalidaException;
import exception.PesquisaInvalidaException;
import exception.PesquisaRunTimeException;
import exception.ProdAcademicaInvalidoException;
import exception.ProdTecnicaInvalidaException;
import util.Validacao;

public class PED extends Projeto {
	private String categoria;
	private int prodAcademica;
	private int prodTecnica;
	private int patente;

	public PED(String nome, String categoria, int prodTecnica, int prodAcademica, int patente, String objetivo,
			String dataInicio, int duracao, String cod)
			throws NomeInvalidoException, DataInicioInvalidoException, DuracaoInvalidaException, ObjetivoInvalidoException, CategoriaInvalidoException, ProdTecnicaInvalidaException, ProdAcademicaInvalidoException, PatenteInvalidaException {
		super(nome, objetivo, dataInicio, duracao, cod);
		Validacao.VerificaCategoria(categoria);
		Validacao.VerificaProdTecnica(prodTecnica);
		Validacao.VerificaProdAcademica(prodAcademica);
		Validacao.VerificaPatente(patente);
		
		this.categoria = categoria;
		this.prodTecnica = prodTecnica;
		this.prodAcademica = prodAcademica;
		this.patente = patente;
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
			return saida += getPatente();
		case "categoria":
			return saida += getCategoria();
		case "participacoes":
			return getParticipantes();
		default:
			String erroMsg = String.format("Erro na consulta de projeto: PED nao possui %s", atributo);
			throw new PesquisaInvalidaException(erroMsg);
		}
	}

	public int getProdAcademica() {
		return this.prodAcademica;
	}

	public int getProdTecnica() {
		return this.prodTecnica;
	}

	public int getPatente() {
		return this.patente;
	}

	public String getCategoria() {
		return this.categoria;
	}
}


