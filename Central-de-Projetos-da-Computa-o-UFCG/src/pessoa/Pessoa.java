package pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.CpfInvalidoException;
import exception.EmailInvalidoException;
import exception.NomeInvalidoException;
import exception.PesquisaRunTimeException;
import participacao.ParticipacaoPessoa;
import util.Validacao;

public class Pessoa implements Serializable, Comparable<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5767020956806359855L;

	private String cpf;
	private String nome;
	private String email;
	private List<ParticipacaoPessoa> participacao;

	public Pessoa(String cpf, String nome, String email)
			throws NomeInvalidoException, EmailInvalidoException, CpfInvalidoException {
		Validacao.VerificaCpf(cpf);
		Validacao.VerificaNome(nome);
		Validacao.VerificaEmail(email);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.participacao = new ArrayList<>();
	}

	public void addParticipacao(ParticipacaoPessoa participacao) {
		this.participacao.add(participacao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participante [cpf=" + cpf + ", nome=" + nome + ", email=" + email + "]";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws CpfInvalidoException {
		Validacao.VerificaCpf(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {
		Validacao.VerificaNome(nome);
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailInvalidoException {
		Validacao.VerificaEmail(email);
		this.email = email;
	}

	public String getParticipacao() {
		String participacao = listaParticipacao();
		return participacao;
	}

	private String listaParticipacao() {
		String lista = "";
		for (int i = 0; i < participacao.size(); i++) {
			lista += participacao.get(i).getProjeto().getNome() + (i < participacao.size() - 1 ? ", " : "");
		}
		return lista;
	}

	/**
	 * Remove a participacao no projeto cadastrado
	 * 
	 * @param codProjeto
	 */
	public void removerParticipacao(String codProjeto) {
		ParticipacaoPessoa participacao = null;
		for (ParticipacaoPessoa participacaoPessoa : this.participacao) {
			if (codProjeto.equalsIgnoreCase(participacaoPessoa.getProjeto().getCod())) {
				participacao = participacaoPessoa;
				break;
			}
		}
		if (participacao != null)
			this.participacao.remove(participacao);
		else
			throw new PesquisaRunTimeException("Projeto nao encontrado!");
	}

	public void setParticipacao(List<ParticipacaoPessoa> participacao) {
		this.participacao = participacao;
	}

	@Override
	public int compareTo(Pessoa pessoa) {
		return this.getNome().compareTo(pessoa.getNome());
	}

}
