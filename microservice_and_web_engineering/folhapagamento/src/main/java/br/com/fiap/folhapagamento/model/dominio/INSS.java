package br.com.fiap.folhapagamento.model.dominio;

import java.util.List;

public class INSS extends Imposto {

	public INSS(List<FaixaImposto> faixas) {
		super(faixas);
	}

	@Override
	public double calcularDesconto(double salario) {
		FaixaImposto faixa = procurarFaixa(salario);
		return salario * faixa.getAliquota();
	}

}
