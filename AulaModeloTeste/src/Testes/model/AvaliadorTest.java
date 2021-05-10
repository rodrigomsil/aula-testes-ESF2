package Testes.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import model.Avaliador;
import model.Lance;
import model.Leilao;
import model.Usuario;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente(){
	Usuario joao = new Usuario("Joao");
	Usuario jose = new Usuario("José");
	Usuario maria = new Usuario("Maria");
	Leilao leilao = new Leilao("Playstation 3 Novo");
	leilao.propoe(new Lance(maria,250.0));
	leilao.propoe(new Lance(joao,300.0));
	leilao.propoe(new Lance(jose,400.0));
	
	// executando a ação
	Avaliador leiloeiro = new Avaliador();
	leiloeiro.avalia(leilao);
	
	// comparando a saída com o esperado
	double maiorEsperado = 400;
	double menorEsperado = 250;
	
	assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
	assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveEntenderLancesEmOrdemDecrescente(){
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria,250.0));
		leilao.propoe(new Lance(joao,200.0));
		leilao.propoe(new Lance(jose,100.0));
		
		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// comparando a saída com o esperado
		double maiorEsperado = 250;
		double menorEsperado = 100;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		}
	
	
	@Test
	public void lanceAleaorio(){
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(maria,250.0));
		leilao.propoe(new Lance(joao,300.0));
		leilao.propoe(new Lance(jose,100.0));
		
		// executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// comparando a saída com o esperado
		double maiorEsperado = 300;
		double menorEsperado = 100;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

	Usuario joao = new Usuario("Joao");
	Leilao leilao = new Leilao("Playstation 3 Novo");
	leilao.propoe(new Lance(joao, 1000.0));
	
	Avaliador leiloeiro = new Avaliador();
	leiloeiro.avalia(leilao);
	
	// comparando a saída com o esperado
	double maiorEsperado = 300;
	double menorEsperado = 300;
	
	assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
	assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);

	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);
	}
	
}
