package br.com.fiap.scj.q4;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Calculadora {
	
	public static double calcular(Operador operador, double n1, double n2) {
		
		double resultado = 0.;
		
		switch(operador) {
			case SOMA:
				resultado = n1 + n2;
				break;
				
			case SUBTRACAO:
				resultado = n1 - n2;
				break;
				
			case MULTIPLICACAO:
				resultado = n1 * n2;
				break;
				
			default:
				resultado = n1 / n2;
				break;
		}
		
		return resultado;		
	}	
	
}
