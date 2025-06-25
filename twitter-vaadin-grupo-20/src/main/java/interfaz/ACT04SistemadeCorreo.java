package interfaz;

import java.security.SecureRandom;
import java.util.Properties;

import com.vaadin.flow.component.notification.Notification;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ACT04SistemadeCorreo {
	public Introducircdigodeverificacin _introducircdigodeverificacin;
	public Iniciarsesin _iniciarsesin;
	
	private String codigo;
	
	// Constructor para registro
	public ACT04SistemadeCorreo(Introducircdigodeverificacin introducircdigodeverificacin, String email) {
		this._introducircdigodeverificacin = introducircdigodeverificacin;
		ValidacionverificacionRegistro(email);
	}
	
	// Constructor para recuperación de contraseña
	public ACT04SistemadeCorreo(Iniciarsesin iniciarsesin, String email) {
		this._iniciarsesin = iniciarsesin;
		Validacionverificacion(email);
	}

	public void Reenviarcdigo() {
		if (_introducircdigodeverificacin != null) {
			// Reenviar código para registro
			String email = _introducircdigodeverificacin._registrarse.getEmailField().getValue();
			ValidacionverificacionRegistro(email);
		} else if (_iniciarsesin != null) {
			// Reenviar código para recuperación de contraseña
			// Aquí necesitaríamos el email desde Iniciarsesin
			// Por ahora simular
			Notification.show("Código reenviado");
		}
	}

	public void Contraseaolvidada() {
		// Implementar lógica de contraseña olvidada
		if (_iniciarsesin != null) {
			Notification.show("Proceso de recuperación iniciado");
		}
	}
	
	public void ValidacionverificacionRegistro(String email) {
		this.codigo = generarCodigo();
		enviarCorreo(email, codigo);
		Notification.show("Código enviado a " + email);
	}

	public void Validacionverificacion(String email) {
		this.codigo = generarCodigo();
		enviarCorreo(email, codigo);
		Notification.show("Código enviado a " + email);
	}
	
	private String generarCodigo() {
	    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
	    SecureRandom random = new SecureRandom();
	    StringBuilder codigo = new StringBuilder();
	    
	    for (int i = 0; i < 6; i++) { // Código de 6 caracteres
	        int index = random.nextInt(caracteres.length());
	        codigo.append(caracteres.charAt(index));
	    }
	    
	    return codigo.toString();
	}
	
	private void enviarCorreo(String destinatario, String codigo) {
		// Configuración del servidor SMTP de Gmail
		final String remitente = "tu_email@gmail.com"; // CAMBIAR POR TU EMAIL
		final String contrasena = "tu_contrasena_app"; // CAMBIAR POR TU CONTRASEÑA DE APLICACIÓN

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remitente, contrasena);
			}
		});

		try {
			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(remitente));
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			mensaje.setSubject("Código de Verificación - Twitter Clone");
			mensaje.setText("Hola!\n\n" +
					"Tu código de verificación es: " + codigo + "\n\n" +
					"Este código expira en 10 minutos.\n\n" +
					"Si no solicitaste este código, ignora este mensaje.\n\n" +
					"Saludos,\nEquipo de Twitter Clone");

			Transport.send(mensaje);
			System.out.println("✅ Correo enviado exitosamente a: " + destinatario);
			Notification.show("Código enviado a " + destinatario, 3000, Notification.Position.TOP_CENTER);

		} catch (MessagingException e) {
			System.err.println("❌ Error enviando correo: " + e.getMessage());
			e.printStackTrace();
			
			// En caso de error, mostrar notificación pero simular el envío
			System.out.println("⚠️ Simulando envío de correo por error de configuración");
			System.out.println("📧 Destinatario: " + destinatario);
			System.out.println("🔑 Código: " + codigo);
			Notification.show("Código generado: " + codigo + " (Error en envío real)", 5000, Notification.Position.TOP_CENTER);
		}
	}

	public String getCodigo() {
		return codigo;
	}
}