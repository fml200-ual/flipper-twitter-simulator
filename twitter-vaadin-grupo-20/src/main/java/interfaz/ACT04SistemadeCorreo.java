package interfaz;

import java.security.SecureRandom;
import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 * Servicio muy sencillo que:
 *   • Genera un código aleatorio (4 dígitos)  
 *   • Lo envía al e-mail del usuario
 *   • Lo mantiene en memoria para que la UI pueda validarlo
 *
 *  *** NO USA BASE DE DATOS – SOLO MEMORIA ***
 */
public class ACT04SistemadeCorreo {

	/* :::::::::::::::::::  AJUSTA AQUÍ TUS CREDENCIALES  ::::::::::::::::::: */
	private static final String SMTP_USER = "tucorreo@gmail.com";    // remitente
	private static final String SMTP_PASS = "tu-app-password";       // app-password de Gmail
	/* :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */

	private final String emailDestino;    // a quién le mandamos el código
	private String codigo;                // último código generado

	/* ============ CONSTRUCTOR ============ */
	public ACT04SistemadeCorreo(String emailDestino) {
		this.emailDestino = emailDestino;
		this.codigo       = generarCodigo();
		enviarCorreo("Código de verificación", cuerpoVerificacion());
	}

	/* ============  API PÚBLICA  ============ */

	/** Devuelve el código actual para que la vista lo compare. */
	public String getCodigo() {
		return codigo;
	}

	/** Pulsado el botón “Reenviar código” en la pantalla de PIN. */
	public void Reenviarcdigo() {
		codigo = generarCodigo();
		enviarCorreo("Tu nuevo código", cuerpoVerificacion());
	}

	/** Para “Olvidé mi contraseña” (flujo de reset). */
	public void Contraseaolvidada() {
		codigo = generarCodigo();
		enviarCorreo("Restablece tu contraseña", cuerpoReset());
	}

	/* ============  HELPER PRIVADOS  ============ */

	private String generarCodigo() {
		return String.format("%04d", new SecureRandom().nextInt(10_000)); // 0000-9999
	}

	private String cuerpoVerificacion() {
		return "¡Hola!\n\nTu código de verificación es: " + codigo +
		       "\n\nSi no solicitaste el registro, simplemente ignora este mensaje.";
	}

	private String cuerpoReset() {
		return "Hemos recibido una solicitud para restablecer tu contraseña.\n\n" +
		       "Código: " + codigo +
		       "\n\nSi no fuiste tú, ignora este correo.";
	}

	private void enviarCorreo(String asunto, String cuerpo) {
		Properties p = new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");

		Session s = Session.getInstance(p, new Authenticator() {
			@Override protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SMTP_USER, SMTP_PASS);
			}
		});

		try {
			Message m = new MimeMessage(s);
			m.setFrom(new InternetAddress(SMTP_USER, "Mi Twitter Clone"));
			m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestino, false));
			m.setSubject(asunto);
			m.setText(cuerpo);
			Transport.send(m);
			System.out.println("✉ Correo enviado a " + emailDestino + " | Código = " + codigo);
		} catch (Exception e) {
			System.err.println("❌ Error enviando correo: " + e.getMessage());
		}
	}
}
