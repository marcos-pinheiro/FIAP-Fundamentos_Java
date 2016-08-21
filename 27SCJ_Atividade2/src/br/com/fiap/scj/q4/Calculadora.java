package br.com.fiap.scj.q4;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Calculadora implements CalculadoraBasica {

	@Override
	public float somar(float op1, float op2) throws ValorZeroException {
		requireNonZero(op1);
		return op1 + op2;
	}

	@Override
	public float subtrair(float op1, float op2) throws ValorZeroException  {
		requireNonZero(op1);
		return op1 - op2;
	}

	@Override
	public float multiplicar(float op1, float op2) throws ValorZeroException  {
		requireNonZero(op1);
		return op1 * op2;
	}

	@Override
	public float dividir(float op1, float op2) throws ValorZeroException  {
		requireNonZero(op1);
		requireNonZero(op2); //Divisão por zero
		
		return op1 / op2;
	}
	
	private static void requireNonZero(float value) throws ValorZeroException {
		if(value == 0) {
			throw new ValorZeroException("Operador não pode conter valor zero");
		}
	}
}
