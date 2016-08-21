package br.com.fiap.scj.q4;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public enum Operador {
	
	SOMA('+'), SUBTRACAO('-'), DIVISAO('/'), MULTIPLICACAO('*');
	
	private final char simbolo;	
	
	private Operador(char simbolo) {
		this.simbolo = simbolo;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
}
