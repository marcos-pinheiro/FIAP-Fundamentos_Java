package br.com.fiap.scj.q1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao1 {

	public static void main(String[] args) {
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		
		final Thread threadMensagens = new Thread(new ProdutorDeMensagens());
		threadMensagens.setName("Produtor de mensanges");
		
		
		final Thread threadHorarios = new Thread(() -> {
			try {
				while(true) {
					Thread.sleep(TimeUnit.SECONDS.toMillis(10));
					System.out.println("Horarios -> " + LocalDateTime.now().format(formatter));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		});
		threadHorarios.setName("Produtor de horarios");
		
		
		final Thread threadMonitor = new Thread(() -> {
			try {
				Thread.sleep(12000);

				while(true) {
					System.out.println(threadMensagens.getName() + "  <=>   Alive? = " + threadMensagens.isAlive() + "  State = " + threadMensagens.getState());
					System.out.println(threadHorarios.getName()  + "   <=>   Alive? = " + threadHorarios.isAlive() + "  State = " + threadHorarios.getState());
					System.out.println();
					Thread.sleep(5000);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		
		threadMensagens.start();
		threadHorarios.start();		
		threadMonitor.start();
		
		System.out.println("AGUARDE ALGUNS SEGUNDOS!");
	}

}
