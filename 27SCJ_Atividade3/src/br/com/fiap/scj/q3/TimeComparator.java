package br.com.fiap.scj.q3;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public interface TimeComparator<T extends Number & Comparable<T>> {
	
	public String min();
	
	public String max();
	
	public void put(String key, T value);
	
	public void remove(String key);
	
	public void report(String title);
	
	
	static TimeComparator<Long> newInstance() {
		return new DefaultTimeComparator();
	}	
}
