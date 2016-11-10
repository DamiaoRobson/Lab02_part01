package jogo;

public class Mochila {
	
	private double pesoItens;
	private double peso;
	private Item[] itens;

	// inticiar variaveis
	public Mochila(double peso) {
		this.peso = peso;
		pesoItens = 0;
		itens = new Item[5];
	}


	public boolean guardarItem(Item item){
		itens[0] = item;
		pesoItens += item.getPeso();
		if ((item.getPeso() + pesoItens) > peso){
			return false;
		}
		return true;
	}

	
	public double getPeso() {
		return peso;
	}


}
