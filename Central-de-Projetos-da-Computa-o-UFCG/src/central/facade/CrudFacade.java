package central.facade;

import java.io.IOException;

import controller.CentralProjetos;
import easyaccept.EasyAccept;
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

public class CrudFacade {

	private CentralProjetos ctProjetos;

	public CrudFacade() {
		this.ctProjetos = new CentralProjetos();
	}

	public static void main(String[] args) {
		args = new String[] { "central.facade.CrudFacade", "acceptance_test/us1_test.txt",
				"acceptance_test/us1_test_exception.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us2_test_exception.txt", "acceptance_test/us3_test.txt",
				"acceptance_test/us3_test_exception.txt" };
		EasyAccept.main(args);

	}

	public void iniciaSistema() {
		/*
		 * try { ctProjetos.inicioSistema();
		 * 
		 * } catch (IOException e) { System.out.println(e.getMessage()); } catch
		 * (ClassNotFoundException e) { System.out.println(e.getMessage()); }
		 */

	}

	public String cadastraPessoa(String cpf, String nome, String email)
			throws NomeInvalidoException, EmailInvalidoException, CpfInvalidoException {
		return ctProjetos.cadastroPessoa(cpf, nome, email);
	}

	public String getInfoPessoa(String cpf, String tipoInfo) {
		return ctProjetos.getInfoPessoa(cpf, tipoInfo);
	}

	public void editaPessoa(String cpf, String atributo, String novoAtributo) throws Exception {
		ctProjetos.editarPessoa(cpf, atributo, novoAtributo);
	}

	public void removePessoa(String cpf) {
		ctProjetos.removePessoa(cpf);
	}

	// Taste us2

	public String adicionaMonitoria(String nome, String disciplina, double rendimento, String objetivo, String periodo,
			String dataInicio, int duracao) throws Exception {
		return ctProjetos.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, dataInicio, duracao);
	}

	public String adicionaPET(String nome, String objetivo, int impacto, double rendimento, int prodTecnica,
			int prodAcademica, int patentes, String dataInicio, int duracao) throws IOException, NomeInvalidoException,
			DataInicioInvalidoException, DuracaoInvalidaException, ObjetivoInvalidoException {
		return ctProjetos.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes,
				dataInicio, duracao);
	}

	public String adicionaExtensao(String nome, String objetivo, int impacto, String dataInicio, int duracao)
			throws NomeInvalidoException, DataInicioInvalidoException, IOException, DuracaoInvalidaException,
			ObjetivoInvalidoException {
		return ctProjetos.adicionaExtensao(nome, objetivo, impacto, dataInicio, duracao);
	}

	public String adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patente,
			String objetivo, String dataInicio, int duracao) throws NomeInvalidoException, DataInicioInvalidoException,
			IOException, DuracaoInvalidaException, ObjetivoInvalidoException, CategoriaInvalidoException,
			ProdTecnicaInvalidaException, ProdAcademicaInvalidoException, PatenteInvalidaException {
		return ctProjetos.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patente, objetivo, dataInicio,
				duracao);
	}

	public String getCodigoProjeto(String nome) {
		return ctProjetos.getCodigoProjeto(nome);
	}

	public void editaProjeto(String cod, String atributo, String valor)
			throws ObjetivoInvalidoException, DuracaoInvalidaException, DataInicioInvalidoException {
		ctProjetos.editaProjeto(cod, atributo, valor);
	}

	public String getInfoProjeto(String cod, String atributo) throws PesquisaInvalidaException {
		return ctProjetos.getInfoProjeto(cod, atributo);
	}

	public void removeProjeto(String cod) {
		ctProjetos.removeProjeto(cod);
	}

	// Teste us3

	public void associaProfessor(String cpf, String codProjeto, Boolean isCoordenador, double valorHora, int qtdHora)
			throws EntradaException {
			ctProjetos.associaProfessor(cpf, codProjeto, isCoordenador, valorHora, qtdHora);
	}

	public void associaGraduando(String cpf, String codProjeto, double valorHora, int qtdHora) throws EntradaException {
		ctProjetos.associaGraduando(cpf, codProjeto, valorHora, qtdHora);
	}

	public void associaProfissional(String cpf, String codProjeto, String cargo, double valorHora, int qtdHora) throws EntradaException {
		ctProjetos.associaProfissional(cpf, codProjeto, cargo, valorHora, qtdHora);
	}

	public void removeParticipacao(String cpf, String codProjeto) {
		// try{
		ctProjetos.removeParticipacao(cpf, codProjeto);
		// }catch (Exception e){
		// System.out.println(e.getStackTrace() +"n/" + e.getMessage());
		// }
	}

	public void fechaSistema() {
		/*
		 * try{ ctProjetos.salvarSistema(); }catch(IOException e){
		 * System.out.println(e.getMessage()); }
		 */
	}

}
