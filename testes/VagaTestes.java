import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import EstacionAqui.Vaga;;

/*
 * @author Gabriel dantas de oliveira - Matricula = 121110669
 */
class VagaTestes {
	Vaga vaga;
	
	@Test
	void testa_Vaga_Com_Endereco_Area() {
		this.vaga = new Vaga("Rua marechal , estação",100);
	}
	
	@Test
	void testa_Vaga_Com_EnderecoArea_Link() {
		this.vaga = new Vaga("Rua Presidente , João pessoa",10.4,"Vagaliberada.com");
	}
	
	@Test
	void testa_liberada_quando_criada() {
		this.vaga = new Vaga("Rua Gabriel Dantas , javeiro",14.27);
		assertEquals(true,vaga.estaLivre());
	}
	
	@Test
	void testa_vaga_ocupada() {
		this.vaga = new Vaga("Rua rio de janeiro , janeiro",14.27);
		this.vaga.mudarStatus();
		assertEquals(false,vaga.estaLivre());
	}
	
	@Test
	void testa_mudarStatus() {
		this.vaga = new Vaga("Rua do amor , caramelo",21.8);
		this.vaga.mudarStatus();
		this.vaga.mudarStatus();
		assertEquals(true,vaga.estaLivre());
	}
	
	@Test
	void testa_preco_hora_maior0() {
		this.vaga = new Vaga("Rua 19 de março , centro",20);
		assertEquals(11,vaga.consultarPreco(3));
	}
	
	@Test
	void testa_preco_hora_0() {
		this.vaga = new Vaga("Rua 19 de março , centro",100,"centro.com");
		assertEquals(10,vaga.consultarPreco(0));
	}
	
	@Test
	void testa_preco_hora_menor0() {
		this.vaga = new Vaga("Rua 19 de março , centro",100,"centro.com");
		try {
			assertEquals(10,vaga.consultarPreco(-1));
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("Não existem horas negativas.",e.getMessage());
		}
		
	}
	
	@Test 
	void testa_toString_comLink_Livre() {
		this.vaga = new Vaga("Rua sou patriota , Brasil",200,"Brasil.com");
		assertEquals("0 - Rua sou patriota , Brasil - Brasil.com - LIVRE",vaga.toString(0));
	}
	
	@Test 
	void testa_toString_semLink_Livre() {
		this.vaga = new Vaga("Rua da UFCG , perto da reitoria",100);
		assertEquals("99 - Rua da UFCG , perto da reitoria - https:// - LIVRE",vaga.toString(99));
	}
	
	@Test 
	void testa_toString_comLink_Ocupada() {
		this.vaga = new Vaga("Rua materia lp2 , java",23,"labp2.com");
		this.vaga.mudarStatus();
		assertEquals("45 - Rua materia lp2 , java - labp2.com - OCUPADA",vaga.toString(45));
	}
	
	@Test 
	void testa_toString_semLink_Ocupada() {
		this.vaga = new Vaga("Rua florentina , catedral",56);
		this.vaga.mudarStatus();
		assertEquals("5 - Rua florentina , catedral - https:// - OCUPADA",vaga.toString(5));
	}
	
	@Test 
	void testa_endereco_nulo() {
		try {
			this.vaga = new Vaga("    ",10);
			fail();
		}catch (NullPointerException e) {
			assertEquals("O endereço não pode ser nulo.",e.getMessage());
		}
	}
	
	@Test
	void testa_area_nula() {
		try {
			this.vaga = new Vaga("Rua dos coqueiros , cocada",0);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("A area não pode ser negativa nem nula!",e.getMessage());
		}
	}
	
	@Test
	void testa_area_negativa() {
		try {
			this.vaga = new Vaga("Rua do tiktok , joga de ladin",-8);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("A area não pode ser negativa nem nula!",e.getMessage());
		}
	}

	@Test
	void testa_link_nulo() {
		try {
			this.vaga = new Vaga("Rua dos coqueiros , cocada",18.2,"     ");
			fail();
		}catch (NullPointerException e) {
			assertEquals("O Link não pode ser nulo.",e.getMessage());
		}
	}
}
