package projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import despesa.Despesa;
import exception.DataInicioInvalidoException;
import exception.DuracaoInvalidaException;
import exception.EntradaException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;
import exception.PesquisaInvalidaException;
import pessoa.Pessoa;
import util.Validacao;

public class Projeto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7987510297396126415L;
	
	
	private String nome;
	private String objetivo;
	private String dataInicio;
	private int duracao;
	private Set<Despesa>depesas;
	private String cod;
	private List<Pessoa> participantes;
	
	public Projeto(String nome, String objetivo, String dataInicio, int duracao, String cod) throws NomeInvalidoException, DataInicioInvalidoException, DuracaoInvalidaException, ObjetivoInvalidoException{
		Validacao.VerificaNomeProjeto(nome);
		Validacao.VerificaDataInicio(dataInicio);
		Validacao.VerificacaoDuracao(duracao);
		Validacao.VerificacaoObjetivo(objetivo);
		
		this.nome = nome;
		this.objetivo = objetivo;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.cod =  cod;
		this.participantes = new ArrayList<>();
	}
	
	public String getInfo(String atributo) throws PesquisaInvalidaException {
		String saida = "";
		switch (atributo) {
		case "nome":
			return saida += this.getNome();
		case "duracao":
			return saida += this.getDuracao();
		case "data de inicio":
			return saida += this.getDataInicio();
		case "objetivo":
			return saida += this.getObjetivo();
		default:
			return saida;
		}
	}
	
	public void addParticipanteProjeto(Pessoa pessoa) throws EntradaException {
		participantes.add(pessoa);
		Collections.sort(participantes);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		Validacao.VerificaNomeProjeto(nome);
		this.nome = nome;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) throws ObjetivoInvalidoException {
		Validacao.VerificacaoObjetivo(objetivo);
		this.objetivo = objetivo;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) throws DataInicioInvalidoException {
		Validacao.VerificaDataInicio(dataInicio);
		this.dataInicio = dataInicio;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) throws DuracaoInvalidaException {
		Validacao.VerificacaoDuracao(duracao);
		this.duracao = duracao;
	}

	public Set<Despesa> getDepesas() {
		return depesas;
	}

	public void setDepesas(Set<Despesa> depesas) {
		this.depesas = depesas;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	/**
	 * Retorna a lista de participantes do projeto
	 * 
	 * @return
	 */
	public String getParticipantes() {
		String participantes = listaParticipacoes();
		return participantes;
	}

	/**
	 * Constroi a lista de participantes do projeto
	 * 
	 * @return
	 */
	private String listaParticipacoes() {
		String lista = "";
		for (int i = 0; i < participantes.size(); i++) {
			lista += participantes.get(i).getNome() + (i < participantes.size() - 1 ? ", " : "");
		}
		return lista;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Projeto))
			return false;
		Projeto other = (Projeto) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
	
}
