package pessoa.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pessoa.Pessoa;

public class PessoaTest {

	private Pessoa pessoa;
	private String cpf = "024.685.014-52";
	private String nome = "Matheus Aldeyncio";
	private String email = "matheus.aldencio@computacao.ufcg.edu.br";

	@Before
	public void setUp() throws Exception {
		pessoa = new Pessoa(cpf, nome, email);
	}

	@Test
	public void CpfException() {

		try {
			Pessoa pessoa = new Pessoa("", nome, email);
			fail("cpf nulo");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de pessoa: CPF nulo ou vazio", e.getMessage());
		}

		try {
			Pessoa pessoa = new Pessoa(null, nome, email);
			fail("cpf null");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de pessoa: CPF nulo ou vazio", e.getMessage());
		}

		try {
			Pessoa pessoa = new Pessoa("024.685.i75-54", nome, email);
			fail("cpf invalido");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de pessoa: CPF invalido", e.getMessage());
		}

	}

	@Test
	public void NomeException() {
		try {
			pessoa = new Pessoa(cpf, null, email);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de pessoa: Nome nulo ou vazio", e.getMessage());
		}

		try {
			pessoa = new Pessoa(cpf, " ", email);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de pessoa: Nome nulo ou vazio", e.getMessage());
		}
	}

	@Test
	public void EmailException() {
		try {
			pessoa = new Pessoa(cpf, nome, " ");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de pessoa: Email nulo ou vazio", e.getMessage());
		}
		try {
			pessoa = new Pessoa(cpf, nome, null);
		} catch (Exception e) {
			assertEquals("Erro no cadastro de pessoa: Email nulo ou vazio", e.getMessage());
		}
	}

}
