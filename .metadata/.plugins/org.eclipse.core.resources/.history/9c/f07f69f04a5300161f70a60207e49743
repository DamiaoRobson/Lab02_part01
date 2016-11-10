package jogo;

public class Heroi {
	
private String nome; 
private double hp;
private Mochila mochila; //== Mochila[] mochila;

public Heroi(String nome, double peso){
	this.nome = nome;
	hp = 100;
	mochila = new Mochila(peso);
}

	
public boolean criaItem(String nomeItem, double pesoItem, int danoItem,String tipoItem){
	Item item  = new Item(nomeItem, pesoItem, danoItem, tipoItem);
	return mochila.guardarItem(item);
}
	
}
