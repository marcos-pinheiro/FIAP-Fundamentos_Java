/*
 * Desenvolva um sistema que imprima em tela a data e hora atual nos seguintes
 * formatos, considerando a data 10/09/2012 12:00:
 * a. 2012-09-10 12:00
 * b. 10-09-12 12:00:00
 * c. Monday (dia da semana)
 * d. 2012 (ano)
 * e. AD (era)
 * Utilize apenas formatadores baseado no DateTimeFormatter para cada tipo de
 * formato.
 */
package br.com.fiap.scj.q2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao2 {

	public static void main(String[] args) {
		
		final LocalDateTime dataHora = LocalDateTime.of(2012, 9, 10, 12, 0);
		
		
		//2012-09-10 12:00
		System.out.println(dataHora.format(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		
		//10-09-12 12:00:00
		System.out.println(dataHora.format(
				DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss")));
		
		//Monday (dia da semana)
		System.out.println(dataHora.format(
				DateTimeFormatter.ofPattern("E")));
		
		//2012 (ano)
		System.out.println(dataHora.format(
				DateTimeFormatter.ofPattern("yyyy")));
		
		//AD (era)
		System.out.println(dataHora.format(
				DateTimeFormatter.ofPattern("G")));
		
	}

}
