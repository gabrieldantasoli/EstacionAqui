package EstacionAqui;

/*
 * @author Gabriel dantas de oliveira - Matricula = 121110669
 */
public class Vaga {
	private String endereco;
	private String localizacaoGoogleMaps;
	private double area;
	private boolean ocupada;
	private int ocupacao;
	private String[] comentarios;
	private String[] autores;
	private int indiceComentario = 0;
	
	public Vaga(String endereco, double area) {
		if (endereco.trim().equals("")) {
			throw new NullPointerException("O endereço não pode ser nulo.");
		}else if (area <= 0) {
			throw new IllegalArgumentException("A area não pode ser negativa nem nula!");
		}
		this.ocupada = false;
		this.ocupacao = 0;
		this.endereco = endereco;
		this.area = area;
		this.localizacaoGoogleMaps = "https://";
		this.comentarios = new String[5];
		this.autores = new String[5];
	}
	
	public Vaga(String endereco, double area, String link) {
		if (endereco.trim().equals("")) {
			throw new NullPointerException("O endereço não pode ser nulo.");
		}else if (area <= 0) {
			throw new IllegalArgumentException("A area não pode ser negativa nem nula!");
		}if (link.trim().equals("")) {
			throw new NullPointerException("O Link não pode ser nulo.");
		}
		this.ocupada = false;
		this.ocupacao = 0;
		this.endereco = endereco;
		this.area = area;
		this.localizacaoGoogleMaps = link;
		this.comentarios = new String[5];
		this.autores = new String[5];
	}
	
	public double consultarPreco(int horas) {
		if (horas < 0) {
			throw new IllegalArgumentException("Não existem horas negativas.");
		}
		return (3 * horas) + (0.1 * this.area);
	}
	
	public void mudarStatus() {
		this.ocupada = this.ocupada == true ? false : true;
		if (this.ocupada) {
			this.ocupacao += 1;
		}
	}
	
	public int ocupacaoVaga() {
		return this.ocupacao;
	}
	
	public String toString(int id) {
		return id + " - " + this.endereco + " - " + this.localizacaoGoogleMaps + " - " + (this.ocupada == true ? "OCUPADA" : "LIVRE");
	}
	
	public boolean estaLivre() {
		return !this.ocupada;
	}
	
	public boolean vagaLivre(String endereco, double area) {
		if (this.endereco.equals(endereco) && this.area == area && this.ocupada == false) {
			return true;
		}
		return false;
	}
	
	public boolean adicionarComentario(String texto, String autor) {
		if (this.indiceComentario < 5) {
			this.comentarios[this.indiceComentario] = texto;
			this.autores[this.indiceComentario] = autor;
			this.indiceComentario += 1;
			return true;
		}
		return false;
	}
	
	public boolean adicionarComentario(String texto) {
		if (this.indiceComentario < 5) {
			this.comentarios[this.indiceComentario] = texto;
			this.autores[this.indiceComentario] = "";
			this.indiceComentario += 1;
			return true;
		}
		return false;
	}
	
	public String listarComentarios() {
		String comentarios = "";
		for (int index = 0; index < this.indiceComentario; index++) {
			String comentario = this.comentarios[index] + " (" + this.autores[index] + ")/n";
			System.out.println(comentario);
			comentarios += comentario;
		}
		return comentarios;
	}
	
	
}