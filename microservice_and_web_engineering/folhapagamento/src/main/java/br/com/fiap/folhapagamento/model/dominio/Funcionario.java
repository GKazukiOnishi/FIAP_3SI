package br.com.fiap.folhapagamento.model.dominio;

public class Funcionario {

	private String nome;
	private double salario;
	private double qtdDependentes;
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getQtdDependentes() {
		return qtdDependentes;
	}

	public void setQtdDependentes(double qtdDependentes) {
		this.qtdDependentes = qtdDependentes;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
