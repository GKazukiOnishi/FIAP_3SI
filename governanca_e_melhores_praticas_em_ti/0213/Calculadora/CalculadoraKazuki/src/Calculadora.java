//Classe que faz cálculos aritméticos simples sobre números inteiros
public class Calculadora {

	//atributo de resultado de cálculos
	private int valorResultado = 0;
	
	//método que realiza a soma de dois números
	public int somar(int variavel1, int variavel2) {
		valorResultado = variavel1 + variavel2;
		return valorResultado;
	}
	
	//método que realiza a subtração de dois números
	public int subtrair(int variavel1, int variavel2) {
		valorResultado = variavel2 - variavel1;
		return valorResultado;
	}

	//método que realiza a multiplicação de dois números
	public int dividir(int variavel1, int variavel2) {
		valorResultado = variavel1 / variavel2; 
		return valorResultado;
	}
	
	//método que realiza a divisão de dois números
	public int multiplicar(int variavel1, int variavel2) {
		valorResultado = variavel1 * variavel2;
		return valorResultado;
	}
	
}
