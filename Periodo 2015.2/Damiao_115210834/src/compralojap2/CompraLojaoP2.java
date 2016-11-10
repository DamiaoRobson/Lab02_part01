package compralojap2;
import java.util.Scanner;


public class CompraLojaoP2 {

//Atribuindo variavel de entrada global
public static Scanner sc = new Scanner(System.in);
private static double valorProduto = 1.99;
	
public static void compra(){
	//Variaveis
	int qtdProduto;
	int totalProd = 0;
	
	//Cabecalho nota
	System.out.print("Bem vindo ao Lojão LP2!\nDigite a quantidade de produtos diferentes que será comprada: ");
	qtdProduto = sc.nextInt();
	System.out.println("-- Cadastro de Produtos --");

	//Declaracao array
	String[] produto = new String[qtdProduto];
	int[] qtd = new int[qtdProduto];
			
	//Solicitacao de dados
	for(int i = 0; i < qtdProduto; i++){
		sc.nextLine();
		System.out.printf("Nome do produto %d: ", (i + 1));
		produto[i] = sc.nextLine();
		System.out.printf("Quantidade de %s: ", produto[i]);
		qtd[i] = sc.nextInt();
		totalProd += qtd[i];
	}

	//Final da nota	
	System.out.println("-- Cadastro Concluнdo --\nA sua compra foi:");
	
	for(int j = 0; j < qtdProduto; j++){
		System.out.printf("%d %s (%.0f%%)\n", qtd[j], produto[j], ((qtd[j] * 100.0) / totalProd));
	}
	
	System.out.printf("Total de produtos: %d\nTotal gasto: R$ %.2f\n", totalProd, (totalProd * valorProduto));
	return;
}


public static void preco() {
	System.out.print("Alterar valor de Produtos para: ");
	double valor = sc.nextFloat();
	valorProduto = valor;
}
}

