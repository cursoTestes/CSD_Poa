package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class UnitTestCalculadoraRoyalties {

	private VendaRepository vendaRepository;
	private CalculadoraComissao calculadoraComissao;

	@Test
	public void calcula_mes_sem_vendas_retorna_zero() {
		int mes = 1;
		int ano = 2015;
		double valorEsperado = 0;
		
		double retornoAct = new CalculadoraRoyalties(vendaRepository, calculadoraComissao).calcular(mes, ano);
		
		assertEquals(valorEsperado, retornoAct, 0);
	}
	
	@Test
	public void calcula_mes_1_venda_retorna_190() {
		int mes = 2;
		int ano = 2015;
		double valorEsperado = 190;
		
		Venda oVenda = new Venda(1, 1, 2, 2015, 1000.0);
		
		Mockito.when(vendaRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(Arrays.asList(oVenda));
		Mockito.when(calculadoraComissao.calcular(oVenda.getValor())).thenReturn(50.0);
		
		double retornoAct = new CalculadoraRoyalties(vendaRepository, calculadoraComissao).calcular(mes, ano);
		
		assertEquals(valorEsperado, retornoAct, 190);
	}
	
	@Before
	public void setup() {
		vendaRepository = Mockito.mock(VendaRepository.class);
		calculadoraComissao = Mockito.mock(CalculadoraComissao.class);
	}
}
