package br.com.fiap.scj.q3;

public enum Cores {
	
	BRANCO("Branco", 21), PRETO("Preto", 22), VERMELHO("Vermelho", 23), AMARELO("Amarelo", 24), AZUL("Azul", 25);
	
	private final String nome;
	private final int codigo;
	
	private Cores(final String nome, final int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return this.nome + "\t" + this.codigo;
	}
}
