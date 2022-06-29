import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * @author Gabriel dantas de oliveira - Matricula = 121110669
 */
import EstacionAqui.EstacionAqui;

class EstacionAquiTestes {
	EstacionAqui estacionamento;
	
	@BeforeEach
    public void criaEstacionAqui(){
        this.estacionamento = new EstacionAqui();
    }

	@Test
	void adicionar_id_invalido_superior() {
		try {
			this.estacionamento.adicionarVaga(100, "Rua Disney , star wras", 10);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O ID tem que ser um número entre 0 e 99!",e.getMessage());
		}
	}
	
	@Test
	void adicionar_id_invalido_inferior() {
		try {
			this.estacionamento.adicionarVaga(-1, "Rua Disney , branca de neve", 11);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O ID tem que ser um número entre 0 e 99!",e.getMessage());
		}
	}
	
	@Test
	void adicionar_id_valido_superior() {
		this.estacionamento.adicionarVaga(99, "Rua brasilia , centro-oeste", 4.5);
	}
	
	@Test
	void adicionar_id_valido_inferior() {
		this.estacionamento.adicionarVaga(0, "Rua quente , partiu sorveteria", 43.5);
	}
	
	@Test
	void adicionar_id_valido_qualquer() {
		this.estacionamento.adicionarVaga(47, "Rua Alexandre , O GRANDE", 17.5);
	}
	
	@Test 
	void adicionar_endereco_valido() {
		this.estacionamento.adicionarVaga(98, "Rua da cebola , estou chorando", 19.1);
	}
	
	@Test
	void adicionar_endereco_invalido() {
		try {
			this.estacionamento.adicionarVaga(98, "", 21.3,"amazon.com");
			fail();
		}catch (NullPointerException e) {
			assertEquals("O endereço não pode ser nulo.",e.getMessage());
		}
	}
	
	@Test
	void adicionar_area_nula() {
		try {
			this.estacionamento.adicionarVaga(8, "Rua do planalto , Central", 0);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("A area não pode ser negativa nem nula!",e.getMessage());
		}
	}
	
	@Test 
	void adicionar_area_negativa() {
		try {
			this.estacionamento.adicionarVaga(8, "Rua do futebol , CR7", -10);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("A area não pode ser negativa nem nula!",e.getMessage());
		}
	}
	
	@Test 
	void adicionar_area_valida() {
		this.estacionamento.adicionarVaga(15, "Rua do cruxeiro , meteoror", 15.2);
	}
	
	@Test 
	void adicionar_link_valido() {
		this.estacionamento.adicionarVaga(0, "Rua dos canários , belgas", 12, "canarios.belos");
	}
	
	@Test
	void adicionar_link_invalido() {
		try {
			this.estacionamento.adicionarVaga(99, "Rua do Esterminador , futuro", 20, "   ");
			fail();
		}catch (NullPointerException e) {
			assertEquals("O Link não pode ser nulo.",e.getMessage());
		}
	}
	
	@Test 
	void mudar_status_inicial() {
		this.estacionamento.adicionarVaga(0, "Rua do prefeito , politico", 22);
		this.estacionamento.mudarStatus(0);
	}
	
	@Test
	void mudar_ocupada_para_livre() {
		this.estacionamento.adicionarVaga(0, "Rua do matadouro , alexandria", 22);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(0);
	}
	
	@Test
	void simular_preco_inferior() {
		this.estacionamento.adicionarVaga(0, "Rua do padeiro , pao", 10);
		assertEquals(13,estacionamento.simularPrecoVaga(0, 4));
	}
	
	@Test
	void simular_preco_superior() {
		this.estacionamento.adicionarVaga(99, "Rua do assalto , bombeou dançou", 21.1);
		assertEquals(38.11,estacionamento.simularPrecoVaga(99, 12));
	}
	
	@Test 
	void simular_preco_qualquer() {
		this.estacionamento.adicionarVaga(32, "Rua da pipa , vou cortar", 32);
		assertEquals(24.2,estacionamento.simularPrecoVaga(32, 7));
	}
	
	@Test
	void sem_vaga_livre() {
		assertEquals(-1,estacionamento.proximaVagaLivre());
	}
	
	@Test
	void vaga_livre_inferior() {
		this.estacionamento.adicionarVaga(0, "Rua acabou a criatividade , cansei", 12.3);
		assertEquals(0,estacionamento.proximaVagaLivre());
	}
	
	@Test
	void vaga_livre_superior() {
		this.estacionamento.adicionarVaga(0, "Rua de diamante, ricos", 14);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.adicionarVaga(99, "Rua Ultima vaga , ralei", 10000);
		assertEquals(99,estacionamento.proximaVagaLivre());
	}
	
	@Test
	void vaga_livre_qualquer() {
		this.estacionamento.adicionarVaga(0, "Rua de diamante, ricos", 14);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.adicionarVaga(99, "Rua Ultima vaga , ralei", 10000);
		this.estacionamento.adicionarVaga(45, "Rua da usina , açucar", 18.2);
		assertEquals(45,estacionamento.proximaVagaLivre());
	}
	
	@Test
	void sem_vagas_ativas() {
		assertEquals("",estacionamento.listarVagasAtivas());
	}
	
	@Test
	void vaga_0_ativa() {
		this.estacionamento.adicionarVaga(0, "rua a", 12.2);
		assertEquals("0 - rua a - https:// - LIVRE/n",estacionamento.listarVagasAtivas());
	}
	
	@Test
	void vaga_99_ativa() {
		this.estacionamento.adicionarVaga(99, "rua b", 32.2);
		assertEquals("99 - rua b - https:// - LIVRE/n",estacionamento.listarVagasAtivas());
	}
	
	@Test
	void vagas_ativa() {
		this.estacionamento.adicionarVaga(0, "rua a", 34);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.adicionarVaga(99, "rua b", 22);
		assertEquals("0 - rua a - https:// - OCUPADA/n99 - rua b - https:// - LIVRE/n",estacionamento.listarVagasAtivas());
	}
	
	@Test
	void vagas_ativas_com_link() {
		this.estacionamento.adicionarVaga(0, "rua a", 34, "rua a.com");
		this.estacionamento.mudarStatus(0);
		this.estacionamento.adicionarVaga(99, "rua b", 22, "rua b.com");
		this.estacionamento.mudarStatus(99);
		assertEquals("0 - rua a - rua a.com - OCUPADA/n99 - rua b - rua b.com - OCUPADA/n",estacionamento.listarVagasAtivas());
	}
	
	@Test
	void vagas_ativas_com_sem_link() {
		this.estacionamento.adicionarVaga(0, "rua a", 34, "rua a.com");
		this.estacionamento.mudarStatus(0);
		this.estacionamento.adicionarVaga(99, "rua c", 22, "rua c.com");
		this.estacionamento.mudarStatus(99);
		this.estacionamento.adicionarVaga(34, "rua b", 27);
		this.estacionamento.adicionarVaga(45, "rua d", 12);
		assertEquals("0 - rua a - rua a.com - OCUPADA/n34 - rua b - https:// - LIVRE/n45 - rua d - https:// - LIVRE/n99 - rua c - rua c.com - OCUPADA/n",estacionamento.listarVagasAtivas());
	}
	
	@Test
	void vagas_ativas_0() {
		assertEquals(0,this.estacionamento.vagasAtivas());
	}
	
	@Test
	void vagas_ativas_inferior() {
		this.estacionamento.adicionarVaga(0, "Rua dos indios , pajé", 12.3);
		assertEquals(1,this.estacionamento.vagasAtivas());
	}
	
	@Test
	void vagas_ativas_superior() {
		this.estacionamento.adicionarVaga(99, "Rua dos moços , legal", 12.3);
		assertEquals(1,this.estacionamento.vagasAtivas());
	}
	
	@Test
	void vagas_ativas_quaisquer1() {
		this.estacionamento.adicionarVaga(0, "Rua dos indios , pajé", 12.3);
		this.estacionamento.adicionarVaga(34, "Rua a , a", 10);
		this.estacionamento.adicionarVaga(48, "Rua a , a", 10);
		this.estacionamento.adicionarVaga(79, "Rua a , a", 10);
		this.estacionamento.adicionarVaga(99, "Rua a , a", 10);
		assertEquals(5,this.estacionamento.vagasAtivas());
	}
	
	@Test
	void vagas_ativas_quaisquer2() {
		this.estacionamento.adicionarVaga(0, "Rua dos indios , pajé", 12.3);
		this.estacionamento.adicionarVaga(34, "Rua a , a", 10);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.adicionarVaga(48, "Rua b , b", 10);
		this.estacionamento.adicionarVaga(79, "Rua c , c", 10);
		this.estacionamento.mudarStatus(79);
		assertEquals(4,this.estacionamento.vagasAtivas());
	}
	
	@Test 
	void vagas_livres_dados_inferior() {
		this.estacionamento.adicionarVaga(0, "Rua do samba , tocar",12.3);
		assertEquals(0,this.estacionamento.vagaLivre_Dados("Rua do samba , tocar", 12.3));
	}
	
	@Test 
	void vagas_livres_dados_superior() {
		this.estacionamento.adicionarVaga(99, "Rua da capoeira , berimbal",15.3);
		assertEquals(99,this.estacionamento.vagaLivre_Dados("Rua da capoeira , berimbal", 15.3));
	}
	
	@Test 
	void vagas_livres_dados_notFind() {
		this.estacionamento.adicionarVaga(0, "Rua da capoeira , berimbal",15.3);
		this.estacionamento.mudarStatus(0);
		assertEquals(-1,this.estacionamento.vagaLivre_Dados("Rua da capoeira , berimbal", 15.3));
	}
	
	@Test 
	void vagas_livres_dados_notIn() {
		this.estacionamento.adicionarVaga(99, "Rua da capoeira , berimbal",15.3);
		this.estacionamento.adicionarVaga(0, "Rua da capoeira , berimbal",15.3);
		this.estacionamento.mudarStatus(0);
		assertEquals(-1,this.estacionamento.vagaLivre_Dados("Rua de mocambique , africa", 15.3));
	}
	
	@Test
	void relatoria_vagas1() {
		this.estacionamento.adicionarVaga(0, "Rua da matemática , cosseno",12.4);
		assertEquals("Vaga 0 - 0/n",estacionamento.relatorioVagas());
	}
	
	@Test
	void relatoria_vagas2() {
		this.estacionamento.adicionarVaga(0, "Rua da matemática , cosseno",12.4);
		this.estacionamento.mudarStatus(0);
		assertEquals("Vaga 0 - 1/n",estacionamento.relatorioVagas());
	}
	
	@Test
	void relatoria_vagas3() {
		this.estacionamento.adicionarVaga(0, "Rua da matemática , cosseno",12.4);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(0);
		assertEquals("Vaga 0 - 1/n",estacionamento.relatorioVagas());
	}
	
	@Test
	void relatoria_vagas4() {
		this.estacionamento.adicionarVaga(0, "Rua da matemática , cosseno",12.4);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(0);
		assertEquals("Vaga 0 - 2/n",estacionamento.relatorioVagas());
	}
	
	@Test
	void relatoria_vagas5() {
		this.estacionamento.adicionarVaga(0, "Rua da matemática , cosseno",12.4);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(0);
		assertEquals("Vaga 0 - 2/n",estacionamento.relatorioVagas());
	}
	
	@Test
	void relatoria_vagas6() {
		this.estacionamento.adicionarVaga(0, "Rua da matemática , cosseno",12.4);
		this.estacionamento.adicionarVaga(99, "Rua da matemática , tangente",12.4);
		this.estacionamento.adicionarVaga(47, "Rua da matemática , seno",12.4);
		this.estacionamento.mudarStatus(0);
		this.estacionamento.mudarStatus(47);
		this.estacionamento.mudarStatus(47);
		this.estacionamento.mudarStatus(99);
		this.estacionamento.mudarStatus(99);
		this.estacionamento.mudarStatus(99);
		this.estacionamento.mudarStatus(99);
		this.estacionamento.mudarStatus(99);
		assertEquals("Vaga 0 - 1/nVaga 47 - 1/nVaga 99 - 3/n",estacionamento.relatorioVagas());
	}
	
	@Test
	void adicionar_Comentario1() {
		this.estacionamento.adicionarVaga(0, "Rua a , a", 8.6);
		assertEquals(true,this.estacionamento.adicionarComentario(0, "A vaga foi pequena."));
	}
	
	@Test
	void adicionar_Comentario2() {
		this.estacionamento.adicionarVaga(0, "Rua a , ", 8.6);
		this.estacionamento.adicionarComentario(0, "a");
		this.estacionamento.adicionarComentario(0, "b");
		this.estacionamento.adicionarComentario(0, "c");
		this.estacionamento.adicionarComentario(0, "d");
		assertEquals(true,this.estacionamento.adicionarComentario(0, "A vaga foi pequena."));
	}
	
	@Test
	void adicionar_Comentario3() {
		this.estacionamento.adicionarVaga(0, "Rua a , ", 8.6);
		this.estacionamento.adicionarComentario(99, "a");
		this.estacionamento.adicionarComentario(99, "b");
		this.estacionamento.adicionarComentario(99, "c");
		this.estacionamento.adicionarComentario(99, "d");
		assertEquals(true,this.estacionamento.adicionarComentario(99, "A vaga foi pequena."));
	}
	
	@Test
	void adicionar_Comentario4() {
		this.estacionamento.adicionarVaga(0, "Rua a , a", 8.6);
		assertEquals(true,this.estacionamento.adicionarComentario(0, "A vaga foi pequena.","Gabriel"));
	}
	
	@Test
	void adicionar_Comentario5() {
		this.estacionamento.adicionarVaga(0, "Rua a , ", 8.6);
		this.estacionamento.adicionarComentario(0, "a","Gabriel");
		this.estacionamento.adicionarComentario(0, "b","Gabriel");
		this.estacionamento.adicionarComentario(0, "c","Gabriel");
		this.estacionamento.adicionarComentario(0, "d","Gabriel");
		assertEquals(true,this.estacionamento.adicionarComentario(0, "A vaga foi pequena.","Gabriel"));
	}
	
	@Test
	void adicionar_Comentario6() {
		this.estacionamento.adicionarVaga(99, "Rua a , ", 8.6);
		this.estacionamento.adicionarComentario(99, "a","Gabriel");
		this.estacionamento.adicionarComentario(99, "b","Gabriel");
		this.estacionamento.adicionarComentario(99, "c","Gabriel");
		this.estacionamento.adicionarComentario(99,"d","gabriel");
		assertEquals(true,this.estacionamento.adicionarComentario(99,"A vaga foi pequena","Gabriel"));
	}
	
	@Test
	void listarComentario1() {
		this.estacionamento.adicionarVaga(0,"Rua a , ", 8.6);
		assertEquals("", this.estacionamento.listarComentarios(0));
	}
	
	@Test
	void listarComentario2() {
		this.estacionamento.adicionarVaga(99,"Rua a ,a ", 93.2);
		this.estacionamento.adicionarComentario(99, "a,Gabriel");
		this.estacionamento.adicionarComentario(99, "b,Gabriel","link");
		this.estacionamento.adicionarComentario(99, "c,Gabriel","link");
		this.estacionamento.adicionarComentario(99,"d,gabriel");
		assertEquals("a,Gabriel ()/nb,Gabriel (link)/nc,Gabriel (link)/nd,gabriel ()/n",this.estacionamento.listarComentarios(99));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}