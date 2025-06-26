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

	// ============ ALMACENAMIENTO DEL CÓDIGO EN MEMORIA ============
	private String codigoGenerado;
	private String emailDestinatario;
	private long tiempoGeneracion;
	private static final long TIEMPO_EXPIRACION = 5 * 60 * 1000; // 5 minutos en milisegundos

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
		// Almacenar el código y datos para validación posterior
		this.codigoGenerado = codigo;
		this.emailDestinatario = destinatario;
		this.tiempoGeneracion = System.currentTimeMillis();

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

	/* ============ MÉTODO PARA VALIDAR CÓDIGO ============ */
	public boolean validarCodigo(String codigoIngresado) {
		// Verificar si hay un código generado
		if (this.codigoGenerado == null || codigoIngresado == null) {
			return false;
		}

		// Verificar expiración (5 minutos)
		long tiempoActual = System.currentTimeMillis();
		if (tiempoActual - this.tiempoGeneracion > TIEMPO_EXPIRACION) {
			System.out.println("Código expirado");
			return false;
		}

		// Verificar que el código coincida
		boolean esValido = this.codigoGenerado.equals(codigoIngresado.trim());
		System.out.println("Validando código: " + codigoIngresado + " vs " + this.codigoGenerado + " = " + esValido);

		if (esValido) {
			// Limpiar el código después de usarlo (uso único)
			this.codigoGenerado = null;
			this.emailDestinatario = null;
			this.tiempoGeneracion = 0;
		}

		return esValido;
	}

	/* ============ MÉTODO PARA OBTENER EL ÚLTIMO CÓDIGO GENERADO ============ */
	public String obtenerCodigoGenerado() {
		return this.codigoGenerado;
	}

	/* ============ MÉTODO PARA VERIFICAR SI HAY UN CÓDIGO ACTIVO ============ */
	public boolean hayCodigoActivo() {
		if (this.codigoGenerado == null) {
			return false;
		}

		long tiempoActual = System.currentTimeMillis();
		return (tiempoActual - this.tiempoGeneracion) <= TIEMPO_EXPIRACION;
	}

	/* ============ MÉTODO MAIN PARA PRUEBAS ============ */
	public static void main(String[] args) {
		System.out.println("=== PRUEBA DEL SISTEMA DE CORREO ===");

		// Crear una instancia del sistema de correo
		ACT04SistemadeCorreo sistemaCorreo = new ACT04SistemadeCorreo();

		// Generar un código aleatorio
		String codigo = sistemaCorreo.generarCodigo();
		System.out.println("Código generado: " + codigo);

		// Email de destino para la prueba
		String emailDestino = "bezzaza4@gmail.com"; // Cambia esto por tu email real

		System.out.println("Enviando correo a: " + emailDestino);
		System.out.println("Por favor espera...");

		try {
			// Enviar el correo
			sistemaCorreo.enviarCorreo(emailDestino, codigo);
			System.out.println("✅ Proceso completado. Revisa tu bandeja de entrada.");
		} catch (Exception e) {
			System.err.println("❌ Error al enviar el correo:");
			e.printStackTrace();
		}

		System.out.println("=== FIN DE LA PRUEBA ===");
	}
}
