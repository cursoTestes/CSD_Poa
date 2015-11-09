package br.com.k21;

public class CalculadoraComissao {

	private static final double PERCENTUAL_FAIXA_1 = 0.05;

	public double calcular(double valorEntrada) {
		if (valorEntrada <= 10000)
			return valorEntrada * PERCENTUAL_FAIXA_1;
		else {
			return valorEntrada * 0.06;
		}
	}

}
