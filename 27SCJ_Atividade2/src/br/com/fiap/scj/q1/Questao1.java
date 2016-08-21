/* Crie uma classe que terá o comportamento de uma calculadora. Essa classe
 * deverá ter a interface CalculadoraBasica a seguir. Depois de desenvolver a
 * classe, teste o seu funcionamento, verificando todos os métodos da interface.
 * Utilize a saída em console para informar o resultado e o
 * JOptionPane.showInputDialog para a entrada de dados do usuário.
 */

package br.com.fiap.scj.q1;

import java.util.Objects;

import javax.swing.JOptionPane;


/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao1 {

	public static void main(String[] args) {	

		String input1 = JOptionPane.showInputDialog("Digite o primeiro número");
		if(Objects.isNull(input1)) {
			return;
		}

		String input2 = JOptionPane.showInputDialog("Digite o segundo número");
		if(Objects.isNull(input2)) {
			return;
		}

		float valor1 = Float.parseFloat(input1);
		float valor2 = Float.parseFloat(input2);

		CalculadoraBasica calculadora = new Calculadora();

		//@Teste
		System.out.println(calculadora.somar(valor1, valor2));
		System.out.println(calculadora.subtrair(valor1, valor2));
		System.out.println(calculadora.multiplicar(valor1, valor2));
		System.out.println(calculadora.dividir(valor1, valor2));
	}

}
