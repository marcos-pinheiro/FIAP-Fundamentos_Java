/* Crie um programa que leia a seqüência de um determinado vetor (array) e
 * depois escreva, em seqüência inversa, em outro vetor. Por exemplo, se o vetor A
 * = {1,2,3}, então vetor B = {3,2,1}.
 */

package br.com.fiap.scj.q1;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao1 {
	
	public static void main(String[] args) {
		
		int[] array 		= {100,11,22,33,99};
		int[] inverseArray 	= new int[array.length];
		
		
		for(int i = 0; i < array.length; i++) {
			inverseArray[array.length - (i+1)] = array[i];
		}
		

		
		//@Teste
		for(int element : inverseArray) {
			System.out.println(element);
		}
	}	
}
