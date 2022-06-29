package EstacionAqui;

public class EstacionAqui {
	private Vaga[] vagas;
	
	public EstacionAqui() {
		this.vagas = new Vaga[100];
	}

	public void adicionarVaga(int id, String endereco, double area) {
		verificaIndiceValido(id);
		this.vagas[id] = new Vaga(endereco, area);
	}

	public void adicionarVaga(int id, String endereco, double area, String link) {
		verificaIndiceValido(id);
		this.vagas[id] = new Vaga(endereco, area, link);
	}
	
	public double simularPrecoVaga(int id, int horas) {
		verificaIndiceValido(id);
		return this.vagas[id].consultarPreco(horas);
	}
	
	public void verificaIndiceValido(int indice) {
		if (!(indice >= 0 && indice <= 99)) {
			throw new IllegalArgumentException("O ID tem que ser um número entre 0 e 99!");
		}
	}
	
	public int proximaVagaLivre() {
		for (int indice = 0; indice < 100; indice++) {
			if (this.vagas[indice] != null && this.vagas[indice].estaLivre()) {
				return indice;
			}
		}
		return -1;
	}
	
	public void mudarStatus(int id) {
		verificaIndiceValido(id);
		this.vagas[id].mudarStatus();
	}
	
	public String listarVagasAtivas() {
		String ativas = "";
		for (int indice = 0; indice < 100; indice++) {
			if (this.vagas[indice] != null) {
				System.out.println(this.vagas[indice].toString(indice));
				ativas += this.vagas[indice].toString(indice) + "/n";
			}
		}
		return ativas;
	}
}
