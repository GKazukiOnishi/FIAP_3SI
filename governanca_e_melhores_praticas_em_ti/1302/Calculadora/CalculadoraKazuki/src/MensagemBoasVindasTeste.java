import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MensagemBoasVindasTeste {

	//preparação de testes
	String usuario = "Gabriel";
	MensagemBoasVindas m = new MensagemBoasVindas(usuario); 
	
	@Test
	//simulação do teste de boas vindas
	public void t01MensagemBoasVindas() {
		//valida o teste
		assertEquals("Seja bem vindo à sua calculadora digital, ", m.dizerBoasVindas());
	}
	
	@Test
	//simulação do teste de complemento
	public void t02Complemento() {
		//valida o teste
		assertEquals("Gabriel! Confira os resultados dos testes no painel da JUNIT!", m.dizerComplemento());
	}

}
