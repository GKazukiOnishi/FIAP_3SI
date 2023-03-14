//Classe que gera mensagens de boas vindas ao usuário
public class MensagemBoasVindas {

	//atributo do nome do usuário
	private String nome;
	
	//construtor que inicializa o nome do usuário
	public MensagemBoasVindas(String nome) {
		this.nome = nome;
	}
	
	//método que diz boas vindas e retorna a mensagem
	public String dizerBoasVindas() {
		String mensagem = "Seja bem vindo à sua calculadora digital, ";
		System.out.print(mensagem);
		return mensagem;
	}
	
	//método que diz o complemento da mensagem e retorna ela
	public String dizerComplemento() {
		String mensagem = nome + "! Confira os resultados dos testes no painel da JUNIT!";
		System.out.println(mensagem);
		return mensagem;
	}
	
}
