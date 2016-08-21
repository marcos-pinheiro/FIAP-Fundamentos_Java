/*
 * Desenvolva um aplicativo onde deverá ser criada uma classe chamada Pessoa
 * com os seguintes atributos: nome (String), idade (int), sexo (char) e empresa
 * (String). Depois crie uma coleção do tipo ArrayList de 5 objetos desta classe
 * conforme tabela abaixo. Mostre como resultado em console, as seguintes
 * informações solicitadas, utilizando a classe utilitária Collections (pode ser
 * necessário alguma implementação na classe Pessoa para a execução de
 * determinados itens):
 * a. Sortear a lista e retirar uma pessoa;
 * b. Ordenação da lista baseado no atributo nome;
 * c. Inverter a ordem da lista baseado no atributo nome;
 */
package br.com.fiap.scj.q4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao4 {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("João Garcia", 20, 'M', "AIK Enterprises"),
				new Pessoa("Maria Martins", 44, 'F', "Simples"),
				new Pessoa("Henrique Fernando", 43, 'M', "AIK Enterprises"),
				new Pessoa("Inácio Luís", 33, 'M', "Magazine André"),
				new Pessoa("Fernando Ferreira", 87, 'M', "Casas Recife"));
		

		//Comparable implementado na classe Pessoa com comparação do atributo nome em ordem decrescente
		Collections.sort(pessoas);
		
		//@Teste
		pessoas.forEach(System.out::println);
		
	}

}
