/*Damiгo Robson Domiciano, 2015.2 UFCG 
 * Laboratуrio de Programaзгo 2
 * Lab02*/

package compralojap2;
import java.util.Scanner;

public class Menu {
	public static void main(String[] arg){
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do{
		System.out.print("Bem vindo ao Lojão LP2!\nMenu Inicial: Digite uma das opções abaixo:\n\n"
				+ "1 - Realizar compra.\n"
				+ "2 - Mudar preço base de produtos.\n"
				+ "3 - Sair\n\n");
			System.out.print("Opção: ");
			opcao = sc.nextInt();
			switch(opcao){
			case 1:
				CompraLojaoP2.compra();
			case 2:
				CompraLojaoP2.preco();
			}

		}while(opcao != 3);
		System.out.println("-- Fim da execução --");
	sc.close();
	}
}
