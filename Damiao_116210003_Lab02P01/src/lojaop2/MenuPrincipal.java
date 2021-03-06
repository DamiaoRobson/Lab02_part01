package lojaop2;

import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int COMPRA = 1;
		final int MUDAR_PRECO = 2;
		final int SAIR = 3;

		System.out.print(
				"Bem vindo ao Lojão LP2!\nMenu Inicial: Digite uma das opções abaixo:\n\n1 - Realizar compra.\n2 - Mudar preço base de produtos.\n3 - Sair\n\n ");

		int opcao;
		do {
			System.out.println("Opção: ");
			opcao = sc.nextInt();sc.nextLine();
			switch (opcao) {
			case COMPRA:
				ComprasLojaoP2.main(args);
				break;
			
			case MUDAR_PRECO:
				System.out.print("Digite o novo preço dos produtos: ");
				double novoPreco = sc.nextDouble();sc.nextLine();
				ComprasLojaoP2.mudarPreco(novoPreco);
				break;
		
			case SAIR:
				System.out.println("Programa finalizado");
				System.exit(0);
				
			default:
				System.out.print("Opcao invalida! Tente novamente.\nOpcao: ");
				break;
			}
		} while (opcao != SAIR);
		
		
		sc.close();

	}

}
