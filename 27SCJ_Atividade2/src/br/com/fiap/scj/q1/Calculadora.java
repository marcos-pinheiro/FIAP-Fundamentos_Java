package br.com.fiap.scj.q1;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public class Calculadora implements CalculadoraBasica {

	@Override
	public float somar(float op1, float op2) {
		return op1 + op2;
	}

	@Override
	public float subtrair(float op1, float op2) {
		return op1 - op2;
	}

	@Override
	public float multiplicar(float op1, float op2) {
		return op1 * op2;
	}

	@Override
	public float dividir(float op1, float op2) {
		return op1 / op2;
	}

}
