package br.com.fiap.folhapagamento.model.dominio;

public class FaixaImposto {

	private double inicio;
	private double fim;
	private double aliquota;
	private double parcelaADeduzir;
	
	public FaixaImposto(double inicio, double fim, double aliquota) {
		this.inicio = inicio;
		this.fim = fim;
		this.aliquota = aliquota;
	}

	public FaixaImposto(double inicio, double fim, double aliquota, double parcelaADeduzir) {
		this.inicio = inicio;
		this.fim = fim;
		this.aliquota = aliquota;
		this.parcelaADeduzir = parcelaADeduzir;
	}

	public double getInicio() {
		return inicio;
	}

	public void setInicio(double inicio) {
		this.inicio = inicio;
	}

	public double getFim() {
		return fim;
	}

	public void setFim(double fim) {
		this.fim = fim;
	}

	public double getAliquota() {
		return aliquota;
	}

	public void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}

	public double getParcelaADeduzir() {
		return parcelaADeduzir;
	}

	public void setParcelaADeduzir(double parcelaADeduzir) {
		this.parcelaADeduzir = parcelaADeduzir;
	}

}
