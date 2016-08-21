package br.com.fiap.scj.q2;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Aviao extends Thread {
	
	private final String nomeDoVoo;
	private final Aeroporto aeroporto;
	
	public Aviao(String nomeVoo, Aeroporto aeroporto) {
		this.nomeDoVoo = nomeVoo;
		this.aeroporto = aeroporto;
	}	
	
	public void voar() throws InterruptedException {
		System.out.println("-> " + nomeDoVoo + " voando...!");
		Thread.sleep(2000);
	}
	
	public void decolar() throws InterruptedException {
		System.out.println("-> " + nomeDoVoo + " aguardando permssão para decolar!");
		aeroporto.aguardarPistaDisponivel();
		System.out.println("-> " + nomeDoVoo + " decolando...");
	}
	
	public void aterrisar() throws InterruptedException {
		System.out.println("-> " + nomeDoVoo + " aguardando permissão para aterrissar!");
		aeroporto.aguardarPistaDisponivel();
		System.out.println("-> " + nomeDoVoo + " aterrissando...");
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				this.decolar();
				this.voar();
				this.aterrisar();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
