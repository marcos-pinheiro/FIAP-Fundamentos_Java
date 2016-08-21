package br.com.fiap.scj.q1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class ProdutorDeMensagens implements Runnable {

	private final Deque<String> deque = new ArrayDeque<>();
	
	public ProdutorDeMensagens() {
		//Preenchimento da colecao em formato de pilha
		IntStream.rangeClosed(1, 3).forEach(i -> deque.push("Valor de número " + i));
	}
	
	@Override
	public void run() {
		while(! deque.isEmpty()) {
			
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(20));
				System.out.println("Mensagens -> " + deque.pop());
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
