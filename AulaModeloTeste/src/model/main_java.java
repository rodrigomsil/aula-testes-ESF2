package model;

public abstract class main_java {

	public static void main(String[] args) {

			Usuario joao = new Usuario("Joao");
			Usuario jose = new Usuario("Jos�");
			Usuario maria = new Usuario("Maria");
			
			Leilao leilao = new Leilao("Playstation 3 Novo");
			
			leilao.propoe(new Lance(maria,250.0));
			leilao.propoe(new Lance(joao,300.0));
			leilao.propoe(new Lance(jose,400.0));
			leilao.propoe(new Lance(joao,300.0));
			leilao.propoe(new Lance(jose,400.0));
			leilao.propoe(new Lance(maria,250.0));
			
			Avaliador leiloeiro = new Avaliador();
			leiloeiro.avalia(leilao);
			
			// imprime 400.0
			System.out.println(leiloeiro.getMaiorLance());
			
			// imprime 250.0
			System.out.println(leiloeiro.getMenorLance());

	}

}
