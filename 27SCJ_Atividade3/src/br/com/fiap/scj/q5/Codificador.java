package br.com.fiap.scj.q5;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Codificador {
	
	public static String codificar(String texto) {
		
		StringBuilder builder = new StringBuilder(texto);

		for(int i = 0; i < builder.length(); i++) {
			builder.setCharAt(i, (char) (texto.charAt(i) + 1));
		}
		
		return builder.toString();
	}
	
	public static String decodificar(String texto) {
		
		StringBuilder builder = new StringBuilder(texto);
		
		for(int i = 0; i < texto.length(); i++) {
			builder.setCharAt(i, (char) (texto.charAt(i) - 1));
		}
		
		return builder.toString();		
	}	
}
