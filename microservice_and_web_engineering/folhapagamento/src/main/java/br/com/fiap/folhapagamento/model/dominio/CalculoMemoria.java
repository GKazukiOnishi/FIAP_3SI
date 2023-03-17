package br.com.fiap.folhapagamento.model.dominio;

import java.time.LocalDate;

public class CalculoMemoria {

	private INSS inss;
	private IRRF irrf;
	private double valorDependente;
	
	private Funcionario funcionario;
	private double salarioBruto;
	private double inssCalculado;
	private double irrfCalculado;
	private double aliquotaIrrf;
	private double aliquotaInss;
	private double salarioBase;
	private double salarioLiquido;
	private double bonus;
	private double descontoOutros;
	private LocalDate dataCalculo;
	private int mesReferencia;

	public CalculoMemoria(Funcionario funcionario, INSS inss, IRRF irrf, double valorDependente) {
		this.funcionario = funcionario;
		this.inss = inss;
		this.irrf = irrf;
		this.valorDependente = valorDependente;
	}

	private double calcularDescontoDependente() {
		return funcionario.getQtdDependentes() * valorDependente;
	}

	public double calcularSalarioLiquido() {
		dataCalculo = LocalDate.now();
		mesReferencia = dataCalculo.getMonthValue();

		salarioBruto = funcionario.getSalario();

		FaixaImposto faixaInss = inss.procurarFaixa(salarioBruto);
		inssCalculado = inss.calcularDesconto(salarioBruto);
		aliquotaInss = faixaInss.getAliquota();

		salarioLiquido = salarioBruto - inssCalculado;

		double descontoDosDependentes = calcularDescontoDependente();
		salarioBase = salarioBruto - inssCalculado - descontoDosDependentes;

		FaixaImposto faixaIrrf = irrf.procurarFaixa(salarioBase);
		irrfCalculado = irrf.calcularDesconto(salarioBase);
		aliquotaIrrf = faixaIrrf.getAliquota();

		salarioLiquido -= irrfCalculado;

		salarioLiquido += bonus;
		salarioLiquido -= descontoOutros;

		return salarioLiquido;
	}

	public INSS getInss() {
		return inss;
	}

	public void setInss(INSS inss) {
		this.inss = inss;
	}

	public IRRF getIrrf() {
		return irrf;
	}

	public void setIrrf(IRRF irrf) {
		this.irrf = irrf;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getInssCalculado() {
		return inssCalculado;
	}

	public void setInssCalculado(double inssCalculado) {
		this.inssCalculado = inssCalculado;
	}

	public double getIrrfCalculado() {
		return irrfCalculado;
	}

	public void setIrrfCalculado(double irrfCalculado) {
		this.irrfCalculado = irrfCalculado;
	}

	public double getAliquotaIrrf() {
		return aliquotaIrrf;
	}

	public void setAliquotaIrrf(double aliquotaIrrf) {
		this.aliquotaIrrf = aliquotaIrrf;
	}

	public double getAliquotaInss() {
		return aliquotaInss;
	}

	public void setAliquotaInss(double aliquotaInss) {
		this.aliquotaInss = aliquotaInss;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getDescontoOutros() {
		return descontoOutros;
	}

	public void setDescontoOutros(double descontoOutros) {
		this.descontoOutros = descontoOutros;
	}

	public LocalDate getDataCalculo() {
		return dataCalculo;
	}

	public void setDataCalculo(LocalDate dataCalculo) {
		this.dataCalculo = dataCalculo;
	}

	public int getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(int mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

}
