/* Construa um programa que crie um vetor para coletar informações de salários de
 * determinados funcionários. O programa inicialmente deverá questionar a
 * quantidade de funcionários que servirá para determinar o tamanho do vetor.
 * Após isso, será questionado o salário para cada funcionário deste vetor. Ao final,
 * o programa deverá informar a média salarial da empresa.
 * Nota: utilize o comando JOptionPane.showInputDialog para a entrada de dados.
 * Como este comando retorna o tipo String, faça a conversão de tipos apropriada
 * (classes wrappers).
 */

package br.com.fiap.scj.q3;

import javax.swing.JOptionPane;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao3 {

	public static void main(String[] args) {
		
		int quantidadeFuncionarios = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de funcionários?"));
		double[] salarios = new double[quantidadeFuncionarios];
		double soma = 0.;
		
		for(int i = 0; i < quantidadeFuncionarios; i++) {			
			String input = JOptionPane.showInputDialog(String.format("Informe o salário do funcionário %d... ex: 2500.00 ", i+1));
			if(input == null) {
				break;
			}
			salarios[i] = Double.parseDouble(input);
			soma+= salarios[i]; 
		}
		
		//@Teste
		System.out.println((double) soma / quantidadeFuncionarios);
	}

}
