package controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exception.CategoriaInvalidoException;
import exception.CpfInvalidoException;
import exception.DataInicioInvalidoException;
import exception.DuracaoInvalidaException;
import exception.EmailInvalidoException;
import exception.EntradaException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;
import exception.PatenteInvalidaException;
import exception.PesquisaInvalidaException;
import exception.PesquisaRunTimeException;
import exception.ProdAcademicaInvalidoException;
import exception.ProdTecnicaInvalidaException;
import participacao.ParticipacaoPessoa;
import pessoa.*;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import util.ValidaAtualizacao;
import util.Validacao;
import persistencia.*;

public class CentralProjetos {

	private List<Pessoa> pessoas;
	private Set<Projeto> projetos;

	public CentralProjetos() {
		this.pessoas = new ArrayList<>();
		this.projetos = new HashSet<>();
	}

	public String cadastroPessoa(String cpf, String nome, String email)
			throws NomeInvalidoException, EmailInvalidoException, CpfInvalidoException {
		Pessoa novaPessoa = new Pessoa(cpf, nome, email);
		verificarCadastroExistente(novaPessoa);
		if (pessoas.contains(novaPessoa))
			throw new CpfInvalidoException("Erro no cadastro de pessoa: Pessoa com mesmo CPF ja cadastrada");
		pessoas.add(novaPessoa);
		return novaPessoa.getCpf();
	}

	private void verificarCadastroExistente(Pessoa novaPessoa) {
		if (pessoas.contains(novaPessoa))
			throw new PesquisaRunTimeException("Erro no cadastro de pessoa: Pessoa com mesmo CPF ja cadastrada");

	}

	public String getInfoPessoa(String cpf, String tipoInfo) {
		Pessoa pessoa = pesquisaPessoa(cpf);
		if (tipoInfo.equalsIgnoreCase("nome"))
			return pessoa.getNome();
		else if (tipoInfo.equalsIgnoreCase("email"))
			return pessoa.getEmail();
		else if (tipoInfo.equalsIgnoreCase("participacoes"))
			return pessoa.getParticipacao();
		throw new PesquisaRunTimeException("Tipo de informacao solicitada nao existe!");
	}

	private Pessoa pesquisaPessoa(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equalsIgnoreCase(cpf))
				return pessoa;
		}
		throw new PesquisaRunTimeException("Erro na consulta de pessoa: Pessoa nao encontrada");
	}

	public void editarPessoa(String cpf, String atributo, String novoAtributo) throws Exception {
		if (atributo.equalsIgnoreCase("cpf")) {
			throw new Exception("Erro na atualizacao de pessoa: CPF nao pode ser alterado");
		}
		ValidaAtualizacao.VerificaCpf(cpf);
		Pessoa pessoa = pesquisaPessoa(cpf);
		if (atributo.equalsIgnoreCase("Nome")) {
			ValidaAtualizacao.VerificaNome(novoAtributo);
			pessoa.setNome(novoAtributo);
		}
		if (atributo.equalsIgnoreCase("Email")) {
			ValidaAtualizacao.VerificaEmail(novoAtributo);
			pessoa.setEmail(novoAtributo);
		}
	}

	public void removePessoa(String cpf) {
		Pessoa pessoa = pesquisaPessoa(cpf);
		pessoas.remove(pessoa);
	}

	/**
	 * Adicionar a participacao do professor no projeto como coordenador ou nao
	 * 
	 * @param cpf
	 * @param codProjeto
	 * @param isCoordenador
	 * @param valorHora
	 * @param qtdHora
	 * @throws EntradaException
	 */
	public void associaProfessor(String cpf, String codProjeto, Boolean isCoordenador, double valorHora, int qtdHora)
			throws EntradaException {
		Pessoa pessoa = pesquisaPessoaParticipar(cpf);
		Projeto projeto = pesquisaProjeto(codProjeto);
		ParticipacaoPessoa participacao = new ParticipacaoPessoa(projeto, isCoordenador, valorHora, qtdHora);
		pessoa.addParticipacao(participacao);
		projeto.addParticipanteProjeto(pessoa);
	}

	/**
	 * Adiciona a participacao do Graduando ao projeto
	 * 
	 * @param cpf
	 * @param codProjeto
	 * @param valorHora
	 * @param qtdHora
	 * @throws EntradaException 
	 */
	public void associaGraduando(String cpf, String codProjeto, double valorHora, int qtdHora) throws EntradaException {
		Pessoa pessoa = pesquisaPessoaParticipar(cpf);
		Projeto projeto = pesquisaProjeto(codProjeto);
		ParticipacaoPessoa participacao = new ParticipacaoPessoa(projeto, valorHora, qtdHora);
		pessoa.addParticipacao(participacao);
		projeto.addParticipanteProjeto(pessoa);
	}

	/**
	 * Adiciona a participacao do profissional ao projeto
	 * 
	 * @param cpf
	 * @param codProjeto
	 * @param cargo
	 * @param valorHora
	 * @param qtdHora
	 * @throws EntradaException 
	 */
	public void associaProfissional(String cpf, String codProjeto, String cargo, double valorHora, int qtdHora) throws EntradaException {
		Pessoa pessoa = pesquisaPessoaParticipar(cpf);
		Projeto projeto = pesquisaProjeto(codProjeto);
		ParticipacaoPessoa participacao = new ParticipacaoPessoa(projeto, cargo, valorHora, qtdHora);
		pessoa.addParticipacao(participacao);
		projeto.addParticipanteProjeto(pessoa);
	}

	/**
	 * Realiza pesquisa para associar pessoa ao projeto
	 * 
	 * @param cpf
	 * @return
	 */
	private Pessoa pesquisaPessoaParticipar(String cpf) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equalsIgnoreCase(cpf))
				return pessoa;
		}
		throw new PesquisaRunTimeException("Erro na associacao de pessoa a projeto: Pessoa nao encontrada");
	}

	/**
	 * Remove a participacao em uma projeto
	 * 
	 * @param cpf
	 * @param codProjeto
	 */
	public void removeParticipacao(String cpf, String codProjeto) {
		pesquisaPessoa(cpf).removerParticipacao(codProjeto);
	}

	// Verificar metodos de inicialiaza e fechar programa
	/**
	 * Le o arquivo no HD caso o mesmo exista, se nou houver arquiva inicia o a
	 * lista de pessoas vazia
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void inicioSistema() throws IOException, ClassNotFoundException {
		ObjectInputStream arqObjectos = null;
		try {
			arqObjectos = new ObjectInputStream(new FileInputStream("arquivoPessoa.bin"));
			pessoas.add((Pessoa) arqObjectos.readObject());
		} catch (EOFException e) {
			this.pessoas = new ArrayList<>();
		} finally {
			if (arqObjectos != null)
				arqObjectos.close();
		}
	}

	/**
	 * Salva a lista de pessoas ja cadastradas no HD para serem recuparadas
	 * posteriormente
	 * 
	 * @throws IOException
	 */
	public void salvarSistema() throws IOException {
		ObjectOutputStream arqObjectos = null;
		try {
			arqObjectos = new ObjectOutputStream(new FileOutputStream("arquivoPessoa.bin"));
			for (Pessoa pessoa : pessoas) {
				arqObjectos.writeObject(pessoa);
			}
		} finally {
			if (arqObjectos != null)
				arqObjectos.close();

		}
	}

	public String adicionaMonitoria(String nome, String disciplina, double rendimento, String objetivo, String periodo,
			String dataInicio, int duracao) throws NomeInvalidoException, DataInicioInvalidoException, IOException,
			DuracaoInvalidaException, ObjetivoInvalidoException {
		try {
			String cod = GeradorDeCodigo.geraCodigo();
			Projeto projeto = new Monitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao, cod);
			projetos.add(projeto);
			return cod;
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DataInicioInvalidoException e) {
			throw new DataInicioInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DuracaoInvalidaException e) {
			throw new DuracaoInvalidaException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (ObjetivoInvalidoException e) {
			throw new ObjetivoInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	public String adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patente,
			String objetivo, String dataInicio, int duracao) throws NomeInvalidoException, DataInicioInvalidoException,
			IOException, DuracaoInvalidaException, ObjetivoInvalidoException, CategoriaInvalidoException,
			ProdTecnicaInvalidaException, ProdAcademicaInvalidoException, PatenteInvalidaException {
		try {
			String cod = GeradorDeCodigo.geraCodigo();
			Projeto projeto = new PED(nome, categoria, prodTecnica, prodAcademica, patente, objetivo, dataInicio,
					duracao, cod);
			projetos.add(projeto);
			return cod;
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (ProdTecnicaInvalidaException e) {
			throw new ProdTecnicaInvalidaException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (ProdAcademicaInvalidoException e) {
			throw new ProdAcademicaInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (PatenteInvalidaException e) {
			throw new PatenteInvalidaException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (CategoriaInvalidoException e) {
			throw new CategoriaInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DataInicioInvalidoException e) {
			throw new DataInicioInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DuracaoInvalidaException e) {
			throw new DuracaoInvalidaException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (ObjetivoInvalidoException e) {
			throw new ObjetivoInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	public String adicionaPET(String nome, String objetivo, int impacto, double rendimento, int prodTecnica,
			int prodAcademica, int patentes, String dataInicio, int duracao) throws IOException, NomeInvalidoException,
			DataInicioInvalidoException, DuracaoInvalidaException, ObjetivoInvalidoException {
		try {
			String cod = GeradorDeCodigo.geraCodigo();
			Projeto p = new PET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes, dataInicio,
					duracao, cod);
			projetos.add(p);
			return cod;
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DataInicioInvalidoException e) {
			throw new DataInicioInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DuracaoInvalidaException e) {
			throw new DuracaoInvalidaException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (ObjetivoInvalidoException e) {
			throw new ObjetivoInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	public String adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao)
			throws NomeInvalidoException, DataInicioInvalidoException, IOException, DuracaoInvalidaException,
			ObjetivoInvalidoException {
		try {
			String cod = GeradorDeCodigo.geraCodigo();
			Projeto p = new Extensao(nome, objetivo, impacto, dataInicio, duracao, cod);
			projetos.add(p);
			return cod;
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DataInicioInvalidoException e) {
			throw new DataInicioInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (DuracaoInvalidaException e) {
			throw new DuracaoInvalidaException("Erro no cadastro de projeto: " + e.getMessage());
		} catch (ObjetivoInvalidoException e) {
			throw new ObjetivoInvalidoException("Erro no cadastro de projeto: " + e.getMessage());
		}

	}

	public boolean removeProjeto(String cod) {
		Projeto p = pesquisaProjeto(cod);

		projetos.remove(p);
		return true;
	}

	public String getInfoProjeto(String cod, String atributo) throws PesquisaInvalidaException {
		Projeto p = pesquisaProjeto(cod);
		String atr = atributo.toLowerCase();
		Validacao.VerificaAtributo(atr);

		return p.getInfo(atributo);

	}

	public String getCodigoProjeto(String nome) {
		for (Projeto projeto : projetos) {
			if (nome.equals(projeto.getNome())) {
				return projeto.getCod();
			}
		}
		throw new PesquisaRunTimeException("Erro na obtencao de codigo de projeto: Projeto nao encontrado");
	}

	public void editaProjeto(String cod, String atributo, String valor)
			throws ObjetivoInvalidoException, DuracaoInvalidaException, DataInicioInvalidoException {
		Projeto projeto = pesquisaProjeto(cod);
		if (atributo.equalsIgnoreCase("Objetivo")) {
			ValidaAtualizacao.VerificacaoObjetivo(valor);
			projeto.setObjetivo(valor);
		}

		if (atributo.equalsIgnoreCase("Duracao")) {
			int duracao = Integer.parseInt(valor);
			projeto.setDuracao(duracao);
		}

		if (atributo.equalsIgnoreCase("Data de Inicio")) {
			ValidaAtualizacao.VerificaDataInicio(valor);
			projeto.setDataInicio(valor);
		}

	}

	public Projeto pesquisaProjeto(String cod) {
		for (Projeto p : projetos) {
			if (cod.equals(p.getCod())) {
				return p;
			}
		}
		throw new PesquisaRunTimeException("Erro na consulta de projeto: Projeto nao encontrado");

	}

}
