package EstacionAqui;

public class Vaga {
	private String endereco;
	private String localizacaoGoogleMaps;
	private double area;
	private boolean ocupada;
	
	
	public Vaga(String endereco, double area) {
		if (endereco.trim().equals("")) {
			throw new NullPointerException("O endereço não pode ser nulo.");
		}else if (area <= 0) {
			throw new IllegalArgumentException("A area não pode ser negativa nem nula!");
		}
		this.ocupada = false;
		this.endereco = endereco;
		this.area = area;
		this.localizacaoGoogleMaps = "https://";
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
		this.endereco = endereco;
		this.area = area;
		this.localizacaoGoogleMaps = link;
	}
	
	public double consultarPreco(int horas) {
		if (horas < 0) {
			throw new IllegalArgumentException("Não existem horas negativas.");
		}
		return (3 * horas) + (0.1 * this.area);
	}
	
	public void mudarStatus() {
		this.ocupada = this.ocupada == true ? false : true;
	}
	
	public String toString(int id) {
		return id + " - " + this.endereco + " - " + this.localizacaoGoogleMaps + " - " + (this.ocupada == true ? "OCUPADA" : "LIVRE");
	}
	
	public boolean estaLivre() {
		return !this.ocupada;
	}
}