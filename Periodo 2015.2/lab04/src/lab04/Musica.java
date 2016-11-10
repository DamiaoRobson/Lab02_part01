package lab04;

public class Musica {

	private String titulo;
	private int duracao;
	private String genero;

	// Construtor
	public Musica(String nome, int duracao, String genero) throws Exception {
		testeMusica(nome, duracao, genero);
		this.titulo = nome;
		this.duracao = duracao;
		this.genero = genero;
	}

	private void testeMusica(String nome, int duracao, String genero) throws Exception {
		if (nome == null || nome.trim().equalsIgnoreCase("") || duracao <= 0 || genero == null
				|| genero.trim().equalsIgnoreCase("")) {
			throw new Exception("");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s (%s - %d minutos)", this.getTitulo(), this.getGenero(), this.getDuracao());
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setNome(String nome) {
		this.titulo = nome;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}