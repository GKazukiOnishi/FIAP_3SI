package br.com.fiap.folhapagamento.model.dominio;

import java.util.List;

public abstract class Imposto {

	protected List<FaixaImposto> faixas;
	
	public Imposto(List<FaixaImposto> faixas) {
		this.faixas = faixas;
	}

	protected FaixaImposto procurarFaixa(double salario) {
		return faixas.stream().filter(f -> valorPertenceAFaixa(salario, f)).findFirst().orElse(faixas.get(faixas.size() - 1));
	}

	private boolean valorPertenceAFaixa(double salario, FaixaImposto f) {
		return f.getInicio() <= salario && f.getFim() >= salario;
	}

	public abstract double calcularDesconto(double salario);

	public List<FaixaImposto> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<FaixaImposto> faixas) {
		this.faixas = faixas;
	}

}
