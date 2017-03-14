package controller.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;

import org.junit.Before;
import org.junit.Test;

import controller.CentralProjetos;
import exception.CategoriaInvalidoException;
import exception.DataInicioInvalidoException;
import exception.DuracaoInvalidaException;
import exception.NomeInvalidoException;
import exception.ObjetivoInvalidoException;
import exception.PatenteInvalidaException;
import exception.PesquisaInvalidaException;
import exception.ProdAcademicaInvalidoException;
import exception.ProdTecnicaInvalidaException;
import persistencia.GeradorDeCodigo;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;

public class CentralProjetosTest {

	private String cod1;
	private String cod2;
	private String cod3;
	private String cod4;
	private String cod5;
	private final CentralProjetos central = new CentralProjetos(); 
	
	
	@Before
	public void CriaProjeto() throws NomeInvalidoException, DataInicioInvalidoException, DuracaoInvalidaException,
	ObjetivoInvalidoException, IOException, CategoriaInvalidoException, ProdTecnicaInvalidaException, 
	ProdAcademicaInvalidoException, PatenteInvalidaException {
		
		GeradorDeCodigo.reiniciarCodigo();
		
		cod1 = central.adicionaMonitoria("Monitoria de P2", "Programacao 2", 100, "Auxiliar no ensino da disciplina de Programacao 2",
				"2016.2", "01/01/2017", 6);
		cod2 = central.adicionaPET("PET Computacao", "Objetivo generico", 1, 80, 1, 2, 0, "03/02/2017", 12);
		cod3 = central.adicionaExtensao("Projeto olimpico", "Ganhar medalhas de ouro", 4, "02/03/2017", 16);
		cod4 = central.adicionaPED("APLICACAO DA MINERACAO DE DADOS EM REPOSITORIOS DINAMICOS", "PIBIT", 2, 4, 1,
			"Desenvolvimento tecnologico e inovacao", "01/01/2017",24);	 
	}
	

	@Test
	public void testGetInfoProjeto() throws PesquisaInvalidaException {
		//assertEquals("Monitoria de P2", central.getInfoProjeto(cod1, "Nome"));
		assertEquals("01/01/2017", central.getInfoProjeto(cod1, "Data de inicio"));
		
//		assertEquals("PIBIT", central.getInfoProjeto(cod1, "categoria"));
//		System.out.println(cod2);
//		assertTrue(central.removeProjeto(cod2));
//		try {
//			central.removeProjeto(cod2);
//			System.out.println("esse");
//		} catch (Exception e) {
//			assertEquals("Erro na consulta de projeto: Projeto nao encontrado", e.getMessage());
//		}
	
	}
	
	
}
