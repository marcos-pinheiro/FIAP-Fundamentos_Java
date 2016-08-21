package br.com.fiap.scj.q5;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Arquivo {
		
	public static void gravarArquivoDeTexto(String nomeDoArquivo, String conteudo) throws IOException {
		try(FileWriter writer = new FileWriter("src/" + nomeDoArquivo + ".txt")) {
			writer.write(conteudo);			
		}
		catch (IOException e) {
			e.printStackTrace();
			throw e;
		}		
	}	
}
