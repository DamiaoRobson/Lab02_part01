package jogo;

import java.util.ArrayList;

public class Mochila {
	
	private double pesoItens;
	private double pesoMax;
	private int dano;
	private int cura;
	private ArrayList<Item> itens;

	// contrutor
	public Mochila(double pesoMax) {
		this.pesoMax = pesoMax;
		pesoItens = 0;
		itens = new ArrayList<Item>();
	}


	public boolean guardarItem(Item item){
		if((pesoItens + item.getPeso()) <= pesoMax){
			dano += item.getEfeito();
			return itens.add(item);
		}
	return false;
	}

	
	public double getPeso() {
		return pesoMax;
	}


}
