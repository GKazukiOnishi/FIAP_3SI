package br.com.fiap.folhapagamento.model.dominio;

import java.util.ArrayList;
import java.util.List;

public class teste {

	public static void main(String[] args) {
		List<FaixaImposto> faixasInss = new ArrayList<FaixaImposto>();
		List<FaixaImposto> faixasIrrf = new ArrayList<FaixaImposto>();
		
		faixasInss.add(new FaixaImposto(0, 1302, 0.075));
		faixasInss.add(new FaixaImposto(1302.01, 2571.29, 0.09));
		faixasInss.add(new FaixaImposto(2571.30, 3856.94, 0.12));
		faixasInss.add(new FaixaImposto(3856.95, 7507.49, 0.14));
		
		faixasIrrf.add(new FaixaImposto(0, 1903.98, 0, 0));
		faixasIrrf.add(new FaixaImposto(1903.99, 2826.65, 0.075, 142.80));
		faixasIrrf.add(new FaixaImposto(2826.66, 3751.05, 0.15, 354.80));
		faixasIrrf.add(new FaixaImposto(3751.06, 4664.68, 0.225, 636.13));
		faixasIrrf.add(new FaixaImposto(4664.69, 0, 0.275, 869.36));
		
		Funcionario f = new Funcionario();
	}

}
