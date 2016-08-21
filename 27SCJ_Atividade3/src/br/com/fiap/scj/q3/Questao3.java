/*
 * Crie um sistema que seja responsável por medir a eficiência de busca de alguns
 * tipos de objetos da classe de coleções do Java. O sistema deverá incluir nos
 * determinados tipos de coleções 1.000.000 entradas do tipo inteiro de números
 * seqüenciais. Utilize um laço para efetuar a inserção dos valores. Depois dos
 * dados estarem nas coleções, deverá ser solicitado a busca da entrada 500.000.
 * Para coleções que necessitam de uma chave, utilize o mesmo valor da entrada,
 * por exemplo, para o valor de entrada 1, a chave também será 1.
 * Compare o tempo tanto de inserção de dados quanto de busca para cada tipo de
 * coleção que será solicitada abaixo. Para a comparação de tempo, utilize sempre
 * na unidade de milissegundos.
 * Por meio deste aplicativo, indique quais são os melhores tipos de coleções para
 * inserção e busca de informação.
 * a. ArrayList e LinkedList
 * b. Stack e HashSet
 * c. HashMap e WeakHashMap
 */
package br.com.fiap.scj.q3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Questao3 {
	
	private static final int MAX_VALUE = 1_000_000;
	private static final int VALUE = 500_000;


	public static void main(String[] args) {
		testeGrupoA();		
		testeGrupoB();
		testeGrupoC();
	}	
	
	static void testeGrupoA() {
		
		TimeComparator<Long> writingComparator = TimeComparator.newInstance();
		TimeComparator<Long> readingComparator = TimeComparator.newInstance();
		
		final List<Integer> arrayList = new ArrayList<>();
		final List<Integer> linkedList = new LinkedList<>();
		
		writingComparator.put("ARRAY_LIST",   Chronometer.startCounting(() -> preencher(arrayList)));
		writingComparator.put("LINKED_LIST",  Chronometer.startCounting(() -> preencher(linkedList)));		
		
		readingComparator.put("ARRAY_LIST",   Chronometer.startCounting(() -> arrayList.get(VALUE)));
		readingComparator.put("LINKED_LIST",  Chronometer.startCounting(() -> linkedList.get(VALUE)));
		
		writingComparator.report("ADIÇÃO NO GRUPO A");
		readingComparator.report("LEITURA DO GRUPO A");
	}
	
	static void testeGrupoB() {
		
		TimeComparator<Long> writeComparator = TimeComparator.newInstance();
		TimeComparator<Long> readComparator = TimeComparator.newInstance();
		
		final Stack<Integer> stack = new Stack<>();
		final HashSet<Integer> hashSet = new HashSet<>();
		
		writeComparator.put("STACK",   Chronometer.startCounting(() -> preencher(stack)));
		writeComparator.put("HASH_SET",  Chronometer.startCounting(() -> preencher(hashSet)));		
		
		readComparator.put("STACK",   Chronometer.startCounting(() -> {
			while(! stack.isEmpty()) {
				if(stack.pop() == VALUE) {
					return;
				}
			}
		}));
		readComparator.put("HASH_SET",  Chronometer.startCounting(() -> {
			for (Integer number : hashSet) {
				if(number == VALUE) {
					return;
				}
			}
		}));
		
		writeComparator.report("ADIÇÃO NO GRUPO B");
		readComparator.report("LEITURA DO GRUPO B");
	}
	
	static void testeGrupoC() {
		
		TimeComparator<Long> writeComparator = TimeComparator.newInstance();
		TimeComparator<Long> readComparator = TimeComparator.newInstance();
		
		final Map<Integer, Integer> hashMap = new HashMap<>();
		final Map<Integer, Integer> weakHashMap = new WeakHashMap<>();
		
		writeComparator.put("HASH_MAP",   Chronometer.startCounting(() -> preencher(hashMap)));
		writeComparator.put("WEAK_HASH_MAP",  Chronometer.startCounting(() -> preencher(weakHashMap)));		
		
		readComparator.put("HASH_MAP",   Chronometer.startCounting(() -> hashMap.get(VALUE)));
		readComparator.put("WEAK_HASH_MAP",  Chronometer.startCounting(() -> weakHashMap.get(VALUE)));
		
		writeComparator.report("ADIÇÃO NO GRUPO C");
		readComparator.report("LEITURA DO GRUPO C");
	}
	
		
	private static void preencher(Collection<Integer> list) {
		for(int i = 0; i < MAX_VALUE; i++) {
			list.add(i);
		}
	}
	
	private static void preencher(Stack<Integer> list) {
		for(int i = 0; i < MAX_VALUE; i++) {
			list.push(i);
		}
	}
	
	private static void preencher(Map<Integer, Integer> list) {
		for(int i = 0; i < MAX_VALUE; i++) {
			list.put(i, i);
		}
	}
}
