package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaRepository vendaRepository;
	private CalculadoraComissao calculadoraComissao;
	
	public CalculadoraRoyalties(VendaRepository vendaRepository, CalculadoraComissao calculadoraComissao){
		this.vendaRepository = vendaRepository;
		this.calculadoraComissao = calculadoraComissao;
	}

	public double calcular(int mes, int ano) {
		
		List<Venda> lista = vendaRepository.obterVendasPorMesEAno(ano, mes);
		double valorTotalRoyalties = 0;
		
		for (Venda venda : lista) {
			double valorLiquidoComissao = calculadoraComissao.calcular(venda.getValor());
			valorTotalRoyalties += venda.getValor() - valorLiquidoComissao;
		}
		
		return valorTotalRoyalties * 0.2;
	}

}
