/* No programa desenvolvido no primeiro exercício, modifique para que seja
 * realizado o devido tratamento de erros para entrada indevida de dados. Por
 * exemplo, ao invés de entrar com um número, o usuário entre com um texto.
 * Utilize o modificador throws e trate os erros apenas na classe Main, caso seja
 * necessário, modifique também a interface. Ajuste o programa para gerar um erro
 * toda vez que o operador 1 seja igual a 0
 */

package br.com.fiap.scj.q4;

import java.util.Objects;

import javax.swing.JOptionPane;

import br.com.fiap.scj.q4.Calculadora;
import br.com.fiap.scj.q4.CalculadoraBasica;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao4 {

	public static void main(String[] args) {
		
		try {
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
		catch (NumberFormatException | ValorZeroException e) {
			System.out.println(e.getMessage());
		}
	}

}
