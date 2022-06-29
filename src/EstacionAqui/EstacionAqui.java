package EstacionAqui;

/*
 * @author Gabriel dantas de oliveira - Matricula = 121110669
 */
public class EstacionAqui {
	private Vaga[] vagas;
	private int vagasAtivas;
	
	public EstacionAqui() {
		this.vagas = new Vaga[100];
	}

	public void adicionarVaga(int id, String endereco, double area) {
		verificaIndiceValido(id);
		this.vagas[id] = new Vaga(endereco, area);
		this.vagasAtivas += 1;
	}

	public void adicionarVaga(int id, String endereco, double area, String link) {
		verificaIndiceValido(id);
		this.vagas[id] = new Vaga(endereco, area, link);
		this.vagasAtivas += 1;
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
	
	public int vagasAtivas() {
		return this.vagasAtivas;
	}
	
	public int vagaLivre_Dados(String endereco, double area) {
		if (endereco.trim().equals("")) {
			throw new NullPointerException("O endereco não pode ser nulo!");
		}
		for (int i = 0; i < 100; i++) {
			if (this.vagas[i] != null) {
				if (this.vagas[i].vagaLivre(endereco, area)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public String relatorioVagas() {
		String ocupacaoVagas = "";
		for (int indice = 0; indice < 100; indice++) {
			if (this.vagas[indice] != null) {
				String vaga = "Vaga " + indice + " - " + this.vagas[indice].ocupacaoVaga() + "/n";
				ocupacaoVagas += vaga;
			}
		}
		return ocupacaoVagas;
	}
	
	public boolean adicionarComentario(int id, String texto, String autor) {
		verificaIndiceValido(id);
		if (texto.trim().equals("")) {
			throw new NullPointerException("O comentário não pode ser nulo!");
		}
		return this.vagas[id].adicionarComentario(texto,autor);
	}
	
	public boolean adicionarComentario(int id, String texto) {
		verificaIndiceValido(id);
		if (texto.trim().equals("")) {
			throw new NullPointerException("O comentário não pode ser nulo!");
		}
		return this.vagas[id].adicionarComentario(texto);
	}
	
	public String listarComentarios(int id) {
		verificaIndiceValido(id);
		String comentarios = this.vagas[id].listarComentarios();
		return comentarios;
	}
}
