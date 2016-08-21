/*
 * Desenvolva um sistema baseado em criptografia que tem o objetivo de codificar
 * e decodificar um arquivo texto. A regra de codificação é incrementar o código
 * ASCII de cada caractere, de forma que o código 1, representado pela letra A
 * seria alterado para 2 (1+2), representado pela letra B e assim por diante. O
 * sistema deve funcionar da seguinte forma: 1) solicitar uma mensagem ao usuário
 * a ser codificada; 2) codificar e salvar o arquivo “mensagemCodificada.txt” e por
 * fim 3) salvar o arquivo decodificado no arquivo “mesagemDecodificada.txt”.
 * Utilize o StringBuilder para alterar os valores caractere a caractere, utilizando o
 * método setChar(int, char).
 */
package br.com.fiap.scj.q5;

import javax.swing.JOptionPane;
import static java.util.Objects.nonNull;

import java.io.IOException;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao5 {

	public static void main(String[] args) {
		
		String mensagem = JOptionPane.showInputDialog("Insira uma mensagem a ser codificada");
		if(nonNull(mensagem)) {
			
			String mensagemCodificada 	= Codificador.codificar(mensagem);
			String mensagemDecodificada	= Codificador.decodificar(mensagemCodificada);
			
			try {
				Arquivo.gravarArquivoDeTexto("mensagemCodificada", mensagemCodificada);
				Arquivo.gravarArquivoDeTexto("mensagemDecodificada", mensagemDecodificada);				
			} 
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Houve um erro ao gravar os arquivos codificados e decodificados.\nVerifique se os mesmos não estão em uso");
			}			
		}
	}

}
