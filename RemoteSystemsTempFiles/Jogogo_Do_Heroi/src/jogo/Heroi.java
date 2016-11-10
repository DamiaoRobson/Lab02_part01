package jogo;

public class Heroi {

	private String nome;
	private double HP;

	
	private Mochila mochila; // == Mochila[] mochila;

//	 construtor heroi
	public Heroi(String nome, double peso) {
		this.nome = nome;
		HP = 100;
		mochila = new Mochila(peso);
	}

//	 criar item
	public boolean criaItem(String nomeItem, double pesoItem, int danoItem, String tipoItem) {
		Item item = new Item(nomeItem, pesoItem, danoItem, tipoItem);
		return mochila.guardarItem(item);
	}

//	ataque
	public void ataca(String nome){
		
	}

	
	public String getNome() {
		return nome;
	}

	public double getHp() {
		return HP;
	}

	public Mochila getMochila() {
		return mochila;
	}

}
