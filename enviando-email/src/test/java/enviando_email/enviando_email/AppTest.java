package enviando_email.enviando_email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private String email = "devcaio@gmailcom";
	private String senha = "Caio123@";
	/*
	 * Todas as informações sobre o smtp estão disponibilizadas na web verifique o
	 * email a ser utilizado e informe as propriedades para a conexão
	 */

	@Test
    public void testEmail() {
    	
    	try {
    		Properties properties = new Properties();
    		
    		properties.put("mail.smtp.auth", "true"); //Autorização
    		properties.put("mail.smtp.starttls", "true"); //Autenticação
    		properties.put("mail.smtp.host", "smtp.gmail.com"); // Servidor Gmail
    		properties.put("mail.smtp.port", "465"); //Porta padrão Google
    		properties.put("mail.smtp.socketFactory.port", "465");// Expecificação da porta pelo socket
    		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexão ao SMTP 
			
    		Session session = Session.getInstance(properties, new Authenticator() {
    			@Override
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(email, senha);
    			};
			});
    		
    		System.out.println(senha);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }

}
