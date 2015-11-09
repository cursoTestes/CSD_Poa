package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnitTestCalculadoraComissao {
	
	@Test
	public void valor10000D00_Retorna500D00() {
		double valorEntrada = 10000.0;
		double valorEsperado = 500.0;
		
		double retornoAct = new CalculadoraComissao().calcular(valorEntrada);  
		
		assertEquals(valorEsperado, retornoAct, 0);
	}
	
	@Test
	public void valor20000D00_Retorna1200D00() {
		double valorEntrada = 20000.0;
		double valorEsperado = 1200.0;
		
		double retornoAct = new CalculadoraComissao().calcular(valorEntrada);  
		
		assertEquals(valorEsperado, retornoAct, 0);
	}
	
	@Test
	public void valor10001D00_Retorna600D06() {
		double valorEntrada = 10001.0;
		double valorEsperado = 600.06;
		
		double retornoAct = new CalculadoraComissao().calcular(valorEntrada);  
		
		assertEquals(valorEsperado, retornoAct, 0);
	}
		
}

