package br.com.fiap.scj.q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public final class DefaultTimeComparator implements TimeComparator<Long> {

	private final Map<String, Long> map = new HashMap<>();

	@Override
	public String min() {

		Entry<String, Long> entry = map.entrySet().stream()
				.min((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
				.get();

		return entry.toString();
	}

	@Override
	public String max() {
		
		Entry<String, Long> entry = map.entrySet().stream()
				.max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
				.get();

		return entry.toString();
	}

	@Override
	public void report(String title) {
		System.out.println("---------> " + title + " <---------\n");
		System.out.println("+ Eficiente: " + min());
		System.out.println("- Eficiente: " + max());
		System.out.println("\n TABELA:" + map.toString() + "\n\n");
	}	
	
	@Override
	public void put(String key, Long value) {
		map.put(key, value);		
	}
	
	@Override
	public void remove(String key) {
		map.remove(key);
	}
}
