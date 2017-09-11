package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoTrintaPorCentoParaBancos implements Desconto{
	private BigDecimal percentualDeDesconto = new BigDecimal ("0.3");
	
	@Override
	public BigDecimal aplicarDescontoSobre (BigDecimal precoOriginal) {
		return precoOriginal.multiply(percentualDeDesconto);
	}

}
