package br.com.fiap.scj.q4;

/**
 * @author Marcos Pinheiro <RM30366>
 *
 */
public interface CalculadoraBasica {
	
	float somar(float op1, float op2) throws ValorZeroException;
	float subtrair(float op1, float op2) throws ValorZeroException;
	float multiplicar(float op1, float op2) throws ValorZeroException;
	float dividir(float op1, float op2) throws ValorZeroException;

}
