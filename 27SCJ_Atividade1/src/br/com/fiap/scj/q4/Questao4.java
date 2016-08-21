/* Construa um programa que funcione como uma calculadora. Este programa
 * deverá conter as operações soma, divisão, multiplicação e subtração. Os
 * operadores deverão ser informados via parâmetros nos métodos. O programa
 * deverá aceitar realizar operações do tipo inteiro (int) e duplo (double).
 */

package br.com.fiap.scj.q4;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
import static br.com.fiap.scj.q4.Operador.*;

public class Questao4 {

	public static void main(String[] args) {
		
		//@Teste
		System.out.println(Calculadora.calcular(SOMA, 			10.5, 2.4));
		System.out.println(Calculadora.calcular(SUBTRACAO, 		10.5, 2));
		System.out.println(Calculadora.calcular(MULTIPLICACAO, 	10, 2.1));
		System.out.println(Calculadora.calcular(DIVISAO, 		10, 2));
	}

}
