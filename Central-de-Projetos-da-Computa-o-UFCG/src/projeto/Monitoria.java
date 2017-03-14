package projeto;

import exception.DataInicioInvalidoException;
import exception.DuracaoInvalidaException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;
import exception.PesquisaInvalidaException;
import exception.PesquisaRunTimeException;

public class Monitoria extends Projeto {
	private String disciplina;
	private String periodo;
	private double rendimento;
	
	public Monitoria(String nome, String disciplina, double rendimento, String objetivo,String periodo, String dataInicio, int duracao, String cod) throws NomeInvalidoException, DataInicioInvalidoException, DuracaoInvalidaException, ObjetivoInvalidoException {
		super(nome, objetivo, dataInicio, duracao, cod);
		this.disciplina = disciplina;
		this.periodo = periodo;
		this.rendimento = rendimento;
		
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
		case "disciplina":
			return saida += getDisciplina();
		case "periodo":
			return saida += getPeriodo();
		case "rendimento":
			return saida += getRendimento();
		case "participacoes":
			return getParticipantes();
		default:
			String erroMsg = String.format("Erro na consulta de projeto: Monitoria nao possui %s", atributo);
			throw new PesquisaInvalidaException(erroMsg);
		}
	}
	
	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	
}
