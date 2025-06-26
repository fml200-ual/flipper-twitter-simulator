package interfaz;

import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servicio muy sencillo que:
 * • Genera un código aleatorio (4 dígitos)
 * • Lo envía al e-mail del usuario
 * • Lo mantiene en memoria para que la UI pueda validarlo
 *
 * *** NO USA BASE DE DATOS – SOLO MEMORIA ***
 */
public class ACT04SistemadeCorreo {

	/* ::::::::::::::::::: AJUSTA AQUÍ TUS CREDENCIALES ::::::::::::::::::: */
	private static final String SMTP_USER = "tate111104@gmail.com"; // remitente
	private static final String SMTP_PASS = "nhvflcjrelbnnbng"; // app-password de Gmail
	/* :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */

	/* ============ CONSTRUCTOR ============ */
	public ACT04SistemadeCorreo() {

	}

	/* ============ MÉTODO PARA GENERAR CÓDIGO ALEATORIO ============ */
	public String generarCodigo() {
	SecureRandom random = new SecureRandom();
	int codigo = 1000 + random.nextInt(9000); // Genera un número entre 1000 y 9999
	return String.valueOf(codigo);
	}

	public void enviarCorreo(String destinatario, String codigo) {
	Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Gmail
	prop.put("mail.smtp.port", "587");
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.starttls.enable", "true");

	Session session = Session.getInstance(prop, new Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(SMTP_USER, SMTP_PASS);
	}
	});

	try {
	Message mensaje = new MimeMessage(session);
	mensaje.setFrom(new InternetAddress(SMTP_USER));
	mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
	mensaje.setSubject("Código de Verificación");
	mensaje.setText("Tu código de verificación es: " + codigo);

	Transport.send(mensaje);
	System.out.println("Correo enviado con éxito.");
	} catch (MessagingException e) {
	e.printStackTrace();
	}

	}
}