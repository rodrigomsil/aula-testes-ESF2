package Testes.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

import model.Avaliador;
import model.Leilao;
import model.Usuario;

public class LeilaoTest {

		private Usuario joao;
		private Usuario jose;
		private Usuario maria;
		private Leilao leilao;
		private int cont = 0;
		
		
		@BeforeEach
		private void instanciarObjetos() {
			joao = new Usuario("Joao");
			jose = new Usuario("José");
			maria = new Usuario("Maria");
			leilao = new Leilao("Playstation 3 Novo");
		}
		
		@Test
		public void naoAceitaLancesEmSequenciaDeUsuario() {
			leilao.propoe(new Lance(joao,1000));
			leilao.propoe(new Lance(joao,2000));
			
			assertEquals(1, leilao.getLances().size());
			assertEquals(1000, leilao.getLances().get(0).getValor(), 0.000001);
		}
		
		@Test
		public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario()
		{

			leilao.propoe(new Lance(joao,1000));
			leilao.propoe(new Lance(maria,1000));
			leilao.propoe(new Lance(joao,2000));
			leilao.propoe(new Lance(maria,2000));
			leilao.propoe(new Lance(joao,3000));
			leilao.propoe(new Lance(maria,3000));
			leilao.propoe(new Lance(joao,4000));
			leilao.propoe(new Lance(maria,4000));
			leilao.propoe(new Lance(joao,5000));
			leilao.propoe(new Lance(maria,5000));

		
		// deve ser ignorado
			leilao.propoe(new Lance(joao,6000));
		
		assertEquals(10, leilao.getLances().size(), "Quantidade de elementos incorreta");
		assertEquals(5000.0, leilao.ultimoLanceDado().getValor(), 0.00001, "Valor do ultimo lance incorreto");
		}
		
		@Test
		public void naoDeveAceitar()
		{
			
			
		}
}
