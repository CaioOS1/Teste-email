package enviando_email.enviando_email;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	/*
	 * Todas as informações sobre o smtp estão disponibilizadas na web verifique o
	 * email a ser utilizado e informe as propriedades para a conexão
	 */

	@Test
	public void testEmail() {

		EmaiConfig emailConfig = new EmaiConfig("caiosilvaa061@gmail.com", "lgzv mgvx lesw ojmn",
				"caiooliveirasilva040@gmail.com", "Caio Oliveira", "Teste Unitário", "Apenas um teste, relaxa");
		
		emailConfig.enviandoEmail();

	}

}
