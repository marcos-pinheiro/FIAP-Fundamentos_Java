package br.com.fiap.scj.q4;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Pessoa implements Comparable<Pessoa> {
	
	private String nome;
	private int idade;
	private char sexo;
	private String empresa;
	
	
	public Pessoa(String nome, int idade, char sexo, String empresa) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.empresa = empresa;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	@Override
	public int compareTo(Pessoa outraPessoa) {
		
		//Ordenação baseada no nome e comparação em ordem decrescente
		return nome.compareTo(outraPessoa.getNome()) * -1;
	}


	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", empresa=" + empresa + "]";
	}
}
