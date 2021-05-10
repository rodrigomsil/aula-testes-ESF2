package Testes.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

public class AvaliadorTest {
	
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Avaliador leiloeiro;
	private Leilao leilao;
	
	
	@BeforeEach
	private void instanciarObjetos() {
		joao = new Usuario("Joao");
		jose = new Usuario("Jos�");
		maria = new Usuario("Maria");
		leiloeiro = new Avaliador();
		leilao = new Leilao("Playstation 3 Novo");
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente(){
	leilao.propoe(new Lance(maria,250.0));
	leilao.propoe(new Lance(joao,300.0));
	leilao.propoe(new Lance(jose,400.0));
	
	// executando a a��o
	leiloeiro.avalia(leilao);
	
	// comparando a sa�da com o esperado
	double maiorEsperado = 400;
	double menorEsperado = 250;
	
	assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
	assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente(){
		leilao.propoe(new Lance(maria,250.0));
		leilao.propoe(new Lance(joao,200.0));
		leilao.propoe(new Lance(jose,100.0));
		
		// executando a a��o
		leiloeiro.avalia(leilao);
		
		// comparando a sa�da com o esperado
		double maiorEsperado = 250;
		double menorEsperado = 100;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		}
	
	
	@Test
	public void lanceAleaorio(){
		leilao.propoe(new Lance(maria,250.0));
		leilao.propoe(new Lance(joao,300.0));
		leilao.propoe(new Lance(jose,100.0));
		
		// executando a a��o
		leiloeiro.avalia(leilao);
		
		// comparando a sa�da com o esperado
		double maiorEsperado = 300;
		double menorEsperado = 100;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		
	leilao.propoe(new Lance(joao, 100.0));
	
	leiloeiro.avalia(leilao);
	
	// comparando a sa�da com o esperado
	double maiorEsperado = 100;
	double menorEsperado = 100;
	
	assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
	assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);
	}
	
	@Test
	public void deveEncontrarMaioresLancesListaVazia() {

				//execu��o
				leiloeiro.avalia(leilao);
				
				//avalia��o
				List<Lance> maiores = leiloeiro.getTresMaiores();
				assertEquals(0, maiores.size());
	}
	
	@Test
	public void deveEncontrarMaioresLancesListaComUm() {
		//entrada
		leilao.propoe(new Lance(maria, 400.0));

		//execu��o
		leiloeiro.avalia(leilao);
		
		//avalia��o
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(1, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {

		try {
				leiloeiro.avalia(leilao);
			} catch (Exception e) {
				// tudo ok;
			}
	}
	
	
	
	
	
}
