package lab04;

import java.util.HashMap;

public class Album {
	
	private String tituloAlbum;
	private String artista;
	private int ano;
	private HashMap<String, Musica> album;
	
	public Album(String titulo, String artista, int ano){
		this.tituloAlbum = titulo;
		this.artista = artista;
		this.ano = ano;
		this.album = new HashMap<String, Musica>();
	}

	public String getTituloAlbum() {
		return tituloAlbum;
	}

	public void setTituloAlbum(String tituloAlbum) {
		this.tituloAlbum = tituloAlbum;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public HashMap<String, Musica> getAlbum() {
		return album;
	}

	public void setAlbum(HashMap<String, Musica> album) {
		this.album = album;
	}

	
}