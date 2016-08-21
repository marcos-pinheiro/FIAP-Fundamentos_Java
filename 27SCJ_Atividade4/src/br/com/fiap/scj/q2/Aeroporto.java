package br.com.fiap.scj.q2;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Aeroporto extends Thread {
	
	private boolean pistaDisponivel = true;
	private final String nome;
	
	public Aeroporto(String nome) {
		this.nome = nome.toUpperCase();
	}

	public synchronized void aguardarPistaDisponivel() throws InterruptedException {
		if(! pistaDisponivel) {
			System.out.println("*** AVISO DE " + nome + " =>  Pista indisponível... Aguarde...");
			wait();
		}
	}
	
	public synchronized void alterarEstadoDaPista() {
		this.pistaDisponivel = !this.pistaDisponivel;
		System.out.println("*** AVISO DE " + nome + " =>  Status da pista = " + (pistaDisponivel ? "disponível" : "indisponível"));
		notifyAll();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
				this.alterarEstadoDaPista();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
