package participacao;

import exception.EntradaException;
import projeto.Projeto;
import util.Validacao;

public class ParticipacaoPessoa {

	private Projeto projeto;
	private String tipoParticipacao;
	private double valorHora;
	private int qtdHora;

	public ParticipacaoPessoa(Projeto projeto, Boolean isCoordenador, double valorHora, int qtdHora) throws EntradaException {
		Validacao.VerificaHora(qtdHora);
		if (isCoordenador)
			Validacao.VerificaValorHoraProfessor(valorHora);
		else
			Validacao.VerificaValorHora(valorHora);
		this.projeto = projeto;
		this.tipoParticipacao = isCoordenador ? "Coordenador" : "Professor";
		this.valorHora = valorHora;
		this.qtdHora = qtdHora;
	}

	public ParticipacaoPessoa(Projeto projeto, double valorHora, int qtdHora) throws EntradaException {
		Validacao.VerificaHora(qtdHora);
		Validacao.VerificaValorHora(valorHora);
		this.projeto = projeto;
		this.tipoParticipacao = "Graduando";
		this.valorHora = valorHora;
		this.qtdHora = qtdHora;
	}

	public ParticipacaoPessoa(Projeto projeto, String Cargo, double valorHora, int qtdHora) throws EntradaException {
		Validacao.VerificaHora(qtdHora);
		Validacao.VerificaValorHora(valorHora);
		this.projeto = projeto;
		this.tipoParticipacao = Cargo;
		this.valorHora = valorHora;
		this.qtdHora = qtdHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
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
		ParticipacaoPessoa other = (ParticipacaoPessoa) obj;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participacao [projeto=" + projeto + ", tipoParticipacao=" + tipoParticipacao + ", valorHora="
				+ valorHora + ", qtdHora=" + qtdHora + "]";
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public String getTipoParticipacao() {
		return tipoParticipacao;
	}

	public void setTipoParticipacao(String tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public int getQtdHora() {
		return qtdHora;
	}

	public void setQtdHora(int qtdHora) {
		this.qtdHora = qtdHora;
	}

}
