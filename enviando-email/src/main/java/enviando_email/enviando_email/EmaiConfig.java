package enviando_email.enviando_email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmaiConfig {

	private String email = "caiosilvaa061@gmail.com";
	private String senha = "lgzv mgvx lesw ojmn";

	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";

	public void enviandoEmail() {

		try {
			Properties properties = estabelecendoConexao();

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email, senha);
				};
			});

			Address[] toUser = InternetAddress.parse(listaDestinatarios);

			if (toUser != null) {
				Message message = montandoEmail(session, toUser);
				Transport.send(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Properties estabelecendoConexao() {
		Properties properties = new Properties();

		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "true"); // Autorização
		properties.put("mail.smtp.starttls", "true"); // Autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Servidor Gmail
		properties.put("mail.smtp.port", "465"); // Porta padrão Google
		properties.put("mail.smtp.socketFactory.port", "465");// Expecificação da porta pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// Classe socket de
																							// conexão ao SMTP
		return properties;
	}

	private Message montandoEmail(Session session, Address[] toUser)
			throws MessagingException, UnsupportedEncodingException {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email, nomeRemetente)); // Quem está enviando
		message.setRecipients(Message.RecipientType.TO, toUser);// Quem irá enviar
		message.setSubject(assuntoEmail); // Assunto do Email
		message.setText(textoEmail); // Mensagema a ser enviada

		return message;
	}

	public EmaiConfig(String email, String senha, String listaDestinatarios, String nomeRemetente, String assuntoEmail,
			String textoEmail) {
		this.email = email;
		this.senha = senha;
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}

}
