/* Construa um programa que solicite um número e retorne o cálculo de seu
 * número fatorial. Exemplo do cálculo 5!=5.4.3.2.1.
 */

package br.com.fiap.scj.q5;

import java.util.Scanner;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao5 {

	public static void main(String[] args) {
		
		System.out.println("=> Informe o valor para se calcular o fatorial:");

		Scanner scanner = new Scanner(System.in);
		int fator = scanner.nextInt();
		scanner.close();
		

		//@Test
		System.out.println("=> " + fatorial(fator));
	}
	
	private static int fatorial(int numero) {		
		if(numero <= 1) {
			return numero;
		}
		return numero * fatorial(--numero);
	}
}
