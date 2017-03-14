package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.AtualizacaoInvalidaException;
import exception.CpfInvalidoException;
import exception.DataInicioInvalidoException;
import exception.EmailInvalidoException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;

public class ValidaAtualizacao {

	private static final Pattern padraoEmail1 = Pattern.compile("[A-Za-z0-9\\._-]+@\\w+\\.\\w{2,3}");
	private static final Pattern padraoEmail2 = Pattern.compile("[A-Za-z0-9\\._-]+@\\w+\\.\\w{2,3}\\.\\w{2,3}");
	private static final Pattern padraoEmail3 = Pattern.compile("[A-Za-z0-9\\._-]+@\\w+\\.\\w{2,4}\\.\\w{2,3}.\\w{2,3}");
	private static final Pattern padraoCpf = Pattern.compile("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
	private static final Pattern padraoDataInicio = Pattern.compile("\\w{1,2}\\/\\w{1,2}\\/\\w{4}");
	
	public static void VerificaCpf(String cpf) throws AtualizacaoInvalidaException {

		if (cpf == null || cpf.trim().isEmpty()) {
			throw new AtualizacaoInvalidaException("CPF nulo ou vazio");
		}

		Matcher cpfPadrao = padraoCpf.matcher(cpf);
		if (!(cpfPadrao.matches())) {
			throw new AtualizacaoInvalidaException("CPF invalido");
		}

	}

	public static void VerificaNome(String nome) throws AtualizacaoInvalidaException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new AtualizacaoInvalidaException("Nome nulo ou vazio");
		}

	}

	public static void VerificaEmail(String email) throws AtualizacaoInvalidaException {

		if (email == null || email.trim().isEmpty()) {
			throw new AtualizacaoInvalidaException("Email nulo ou vazio");
		}
		Matcher emailPadrao1 = padraoEmail1.matcher(email);
		Matcher emailPadrao2 = padraoEmail2.matcher(email);
		Matcher emailPadrao3 = padraoEmail3.matcher(email);

		if (!(emailPadrao1.matches() || emailPadrao2.matches() || emailPadrao3.matches())) {
			throw new AtualizacaoInvalidaException("Email invalido");
		}

	}

	public static void VerificacaoObjetivo(String objetivo) throws ObjetivoInvalidoException {

		if (objetivo == null || objetivo.trim().isEmpty()) {
			throw new ObjetivoInvalidoException("Erro na atualizacao de projeto: Objetivo nulo ou vazio");
		}
	}
	
	
	public static void VerificaDataInicio(String dataInicio) throws DataInicioInvalidoException {
		if (dataInicio == null || dataInicio.trim().isEmpty()) {
			throw new DataInicioInvalidoException ("Erro na atualizacao de projeto: Formato de data invalido");
		}

		Matcher dataInicioPadrão = padraoDataInicio.matcher(dataInicio);
		if (!(dataInicioPadrão.matches())) {
			throw new DataInicioInvalidoException("Erro na atualizacao de projeto: Formato de data invalido");
		}
		
		String[] partes = dataInicio.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int ano= Integer.parseInt(partes[2]);

		if (dia <= 0 || dia >= 32) {
			throw new DataInicioInvalidoException("Erro na atualizacao de projeto: Formato de data invalido");
		}
		
		if (mes <= 0 || mes >= 13) {
			throw new DataInicioInvalidoException("Erro na atualizacao de projeto: Formato de data invalido");
		}
		
		if (ano <= 1920) {
			throw new DataInicioInvalidoException("Erro na atualizacao de projeto: Formato de data invalido");
		}
	}

}
