package projeto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import projeto.Projeto;

public class ProjetoTest {

	@Test
	public void testProjeto() {
		try {
			new Projeto("  ","Auxiliar no ensino da disciplina de Programacao 2", "01/01/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Nome nulo ou vazio", e.getMessage());
		}
		try {
			new Projeto(null,"Auxiliar no ensino da disciplina de Programacao 2", "01/01/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Nome nulo ou vazio", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","", "01/01/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2",null, "01/01/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Objetivo nulo ou vazio", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","Auxiliar no ensino da disciplina de Programacao 2", "001/01/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","Auxiliar no ensino da disciplina de Programacao 2", "01/001/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","Auxiliar no ensino da disciplina de Programacao 2", "01/01/217", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","Auxiliar no ensino da disciplina de Programacao 2", "45/01/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","Auxiliar no ensino da disciplina de Programacao 2", "01/34/2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","Auxiliar no ensino da disciplina de Programacao 2", "01/01/-2017", 6, "cod1");
		} catch (Exception e) {
			assertEquals("Formato de data invalido", e.getMessage());
		}
		try {
			new Projeto("Monitoria de P2","Auxiliar no ensino da disciplina de Programacao 2", "01/01/2017", -6, "cod1");
		} catch (Exception e) {
			assertEquals("Duracao invalida", e.getMessage());
		}
	}

}


