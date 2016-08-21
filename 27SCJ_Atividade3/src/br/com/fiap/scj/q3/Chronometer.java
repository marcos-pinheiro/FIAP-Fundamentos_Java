package br.com.fiap.scj.q3;

import static java.util.Objects.isNull;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public final class Chronometer {
	
	public static long startCounting(Activity activity) {
		
		if(isNull(activity))
			throw new IllegalArgumentException("Atividade a ser monitorada não pode ser nula");
		
		Instant start = Instant.now();		
		activity.execute();
		
		return ChronoUnit.MILLIS.between(start, Instant.now());
	}
}
