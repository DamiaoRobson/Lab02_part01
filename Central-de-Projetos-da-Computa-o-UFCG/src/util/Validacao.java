package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import exception.ProdAcademicaInvalidoException;
import exception.ProdTecnicaInvalidaException;
import exception.ValorHoraException;

public class Validacao {

	private static final Pattern padraoEmail1 = Pattern.compile("[A-Za-z0-9\\._-]+@\\w+\\.\\w{2,3}");
	private static final Pattern padraoEmail2 = Pattern.compile("[A-Za-z0-9\\._-]+@\\w+\\.\\w{2,3}\\.\\w{2,3}");
	private static final Pattern padraoEmail3 = Pattern
			.compile("[A-Za-z0-9\\._-]+@\\w+\\.\\w{2,4}\\.\\w{2,3}.\\w{2,3}");
	private static final Pattern padraoCpf = Pattern.compile("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
	private static final Pattern padraoDataInicio = Pattern.compile("\\w{1,2}\\/\\w{1,2}\\/\\w{4}");
	private static String[] atributosValidos = { "nome", "duracao", "data de inicio", "objetivo", "disciplina",
			"periodo", "rendimento", "producao tecnica", "producao academica", "patente", "categoria", "impacto",
			"participacoes" };

	public static void VerificaCpf(String cpf) throws CpfInvalidoException {

		if (cpf == null || cpf.trim().isEmpty()) {
			throw new CpfInvalidoException("nulo ou vazio");
		}

		Matcher cpfPadrao = padraoCpf.matcher(cpf);
		if (!(cpfPadrao.matches())) {
			throw new CpfInvalidoException();
		}

	}

	public static void VerificaNome(String nome) throws NomeInvalidoException {

		if (nome == null || nome.trim().isEmpty())
			throw new NomeInvalidoException();
	}

	public static void VerificaEmail(String email) throws EmailInvalidoException {

		if (email == null || email.trim().isEmpty()) {
			throw new EmailInvalidoException("nulo ou vazio");
		}
		Matcher emailPadrao1 = padraoEmail1.matcher(email);
		Matcher emailPadrao2 = padraoEmail2.matcher(email);
		Matcher emailPadrao3 = padraoEmail3.matcher(email);

		if (!(emailPadrao1.matches() || emailPadrao2.matches() || emailPadrao3.matches())) {
			throw new EmailInvalidoException();
		}

	}

	public static void VerificaValorHoraProfessor(double valorHora) throws EntradaException {
		if (valorHora < 0)
			throw new ValorHoraException("Erro na associacao de pessoa a projeto: Valor da hora invalido");
	}
	
	public static void VerificaValorHora(double valorHora) throws EntradaException {
		if (valorHora <= 0)
			throw new ValorHoraException("Erro na associacao de pessoa a projeto: Valor da hora invalido");
	}
	
	public static void VerificaHora(int hora) throws EntradaException {
		if (hora <= 0)
			throw new ValorHoraException("Erro na associacao de pessoa a projeto: Quantidade de horas invalida");
	}

	public static void VerificaDataInicio(String dataInicio) throws DataInicioInvalidoException {
		String[] partes = dataInicio.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int ano = Integer.parseInt(partes[2]);

		if (dataInicio == null || dataInicio.trim().isEmpty()) {
			throw new DataInicioInvalidoException("Formato de data invalido");
		}

		Matcher dataInicioPadrão = padraoDataInicio.matcher(dataInicio);
		if (!(dataInicioPadrão.matches())) {
			throw new DataInicioInvalidoException("Formato de data invalido");
		}

		if (dia <= 0 || dia >= 32) {
			throw new DataInicioInvalidoException("Formato de data invalido");
		}

		if (mes <= 0 || mes >= 13) {
			throw new DataInicioInvalidoException("Formato de data invalido");
		}

		if (ano <= 1920) {
			throw new DataInicioInvalidoException("Formato de data invalido");
		}
	}

	public static void VerificacaoDuracao(int duracao) throws DuracaoInvalidaException {

		if (duracao <= 0) {
			throw new DuracaoInvalidaException("Duracao invalida");
		}
	}

	public static void VerificacaoObjetivo(String objetivo) throws ObjetivoInvalidoException {

		if (objetivo == null || objetivo.trim().isEmpty()) {
			throw new ObjetivoInvalidoException("Objetivo nulo ou vazio");
		}
	}

	public static void VerificaNomeProjeto(String nome) throws NomeInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new NomeInvalidoException("Nome nulo ou vazio");
		}

	}

	public static void VerificaCategoria(String categoria) throws CategoriaInvalidoException {
		String cat = categoria.toLowerCase();

		if (categoria == null || categoria.trim().isEmpty()) {
			throw new CategoriaInvalidoException("Categoria invalida");
		}
		if (!(cat.equals("pivic")) && !(cat.equals("pibic")) && !(cat.equals("pibiti")) && !(cat.equals("coop"))) {
			throw new CategoriaInvalidoException("Categoria invalida");
		}

	}

	public static void VerificaProdTecnica(int prodTecnica) throws ProdTecnicaInvalidaException {
		if (prodTecnica <= 0) {
			throw new ProdTecnicaInvalidaException("Numero de producoes tecnicas invalido");
		}
	}

	public static void VerificaProdAcademica(int prodAcademica) throws ProdAcademicaInvalidoException {
		if (prodAcademica <= 0) {
			throw new ProdAcademicaInvalidoException("Numero de producoes academicas invalido");
		}
	}

	public static void VerificaPatente(int patente) throws PatenteInvalidaException {
		if (patente <= 0) {
			throw new PatenteInvalidaException("Numero de patentes invalido");
		}
	}

	public static void VerificaAtributo(String atributo) throws PesquisaInvalidaException {
		boolean invalido = true;

		for (String atr : atributosValidos) {
			if (atr.equals(atributo)) {
				invalido = false;
			}
		}
		if (invalido) {
			throw new PesquisaInvalidaException("Erro na consulta de projeto: Atributo nulo ou invalido");
		}
	}

}
