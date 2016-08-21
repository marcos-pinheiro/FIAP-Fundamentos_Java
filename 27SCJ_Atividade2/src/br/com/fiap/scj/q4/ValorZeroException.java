package br.com.fiap.scj.q4;

public class ValorZeroException extends Exception {
	
	public ValorZeroException() {
		super("Valor zero não é permitido");
	}
	
	public ValorZeroException(String mensagem) {
		super(mensagem);
	}
}
