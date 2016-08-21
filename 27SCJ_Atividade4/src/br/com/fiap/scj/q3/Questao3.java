package br.com.fiap.scj.q3;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao3 {

	public static void main(String[] args) {
		
		System.out.println("Cor\tCódigo");
		for(Cores cor : Cores.values()) {
			System.out.println(cor);
		}
		
		System.out.println("\n\n");
		System.out.println(Cores.BRANCO.getCodigo());
	}

}
