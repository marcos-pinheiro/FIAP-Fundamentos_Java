package br.com.fiap.scj.q2;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Aeroporto aeroporto = new Aeroporto("Congonhas");
		aeroporto.start();
		
		Aviao aviao1 = new Aviao("TAN 123", aeroporto);
		Aviao aviao2 = new Aviao("OLÉ 111", aeroporto);
		Aviao aviao3 = new Aviao("LINHA 222", aeroporto);
		
		
		aviao1.start();
		Thread.sleep(1000); //Colocado apenas para melhorar o teste
		
		aviao2.start();
		Thread.sleep(2000); //Colocado apenas para melhorar o teste
		
		aviao3.start();
	}

}
