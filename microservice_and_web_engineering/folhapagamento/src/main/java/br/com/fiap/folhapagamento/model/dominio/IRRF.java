package br.com.fiap.folhapagamento.model.dominio;

import java.util.List;

public class IRRF extends Imposto {

	public IRRF(List<FaixaImposto> faixas) {
		super(faixas);
	}

	@Override
	public double calcularDesconto(double salario) {
		FaixaImposto faixa = procurarFaixa(salario);
		return salario * faixa.getAliquota() - faixa.getParcelaADeduzir();
	}

}
