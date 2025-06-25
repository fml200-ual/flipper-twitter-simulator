package interfaz;

import vistas.VistaRestablecercontrasea;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Restablecercontrasea extends VistaRestablecercontrasea{
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Introducircdigodeverificacin _introducircdigodeverificacin;
	public ACT04SistemadeCorreo _aCT04SistemadeCorreo; // Para enviar el correo de verificación
	
	// Campo temporal para almacenar el correo electrónico del usuario
	private String correoElectronico;
	private Button cancelarButton;
	private Button aceptarButton;
	private boolean solicitandoCorreo = true; // Estado para saber qué estamos pidiendo
	
	public Restablecercontrasea(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		
		// Configurar funcionalidad de restablecimiento
		configurarEventos();
		agregarBotones();
		configurarVistaInicial();
	}
	
	public Restablecercontrasea(Introducircdigodeverificacin _introducircdigodeverificacin, String correoElectronico) {
		super();
		this._introducircdigodeverificacin = _introducircdigodeverificacin;
		this.correoElectronico = correoElectronico;
		this.solicitandoCorreo = false; // Ya tenemos el correo
		
		// Configurar funcionalidad de restablecimiento
		configurarEventos();
		agregarBotones();
		configurarVistaContrasena();
	}
	
	private void configurarVistaInicial() {
		// Configurar la vista para solicitar correo electrónico
		this.getMessageBox().removeAll();
		this.getMessageBox().add(new com.vaadin.flow.component.html.Paragraph("Introduce tu correo electrónico para restablecer tu contraseña."));
		
		// Cambiar el tipo de campo a email
		this.getPasswordField().setLabel("Correo electrónico");
		this.getPasswordField().getElement().setProperty("type", "email");
		this.getPasswordField().setPlaceholder("ejemplo@correo.com");
	}
	
	private void configurarVistaContrasena() {
		// Configurar la vista para solicitar nueva contraseña
		this.getMessageBox().removeAll();
		this.getMessageBox().add(new com.vaadin.flow.component.html.Paragraph("Introduce tu nueva contraseña."));
		this.getMessageBox().add(new com.vaadin.flow.component.html.Paragraph("Y asegúrate de no olvidarla..."));
		
		// Asegurar que el campo sea de tipo password
		this.getPasswordField().setLabel("Nueva Contraseña");
		this.getPasswordField().getElement().setProperty("type", "password");
		this.getPasswordField().setPlaceholder("");
	}
	
	private void agregarBotones() {
		// Crear botones
		cancelarButton = new Button("Cancelar");
		aceptarButton = new Button("Aceptar");
		
		// Configurar estilos de los botones
		cancelarButton.getStyle().set("background-color", "#666");
		cancelarButton.getStyle().set("color", "#fff");
		cancelarButton.getStyle().set("border", "2px solid #888");
		
		aceptarButton.getStyle().set("background-color", "#00FFFF");
		aceptarButton.getStyle().set("color", "#000");
		aceptarButton.getStyle().set("border", "2px solid #00FFFF");
		
		// Configurar eventos de los botones
		cancelarButton.addClickListener(event -> cancelar());
		aceptarButton.addClickListener(event -> validarDatos());
		
		// Crear layout horizontal para los botones
		HorizontalLayout botonesLayout = new HorizontalLayout(cancelarButton, aceptarButton);
		botonesLayout.setSpacing(true);
		
		// Agregar los botones al contenedor principal
		this.getResetPasswordContainer().appendChild(botonesLayout.getElement());
	}
	private void cancelar() {
		// Si estamos en el segundo paso (solicitando contraseña), volver al primer paso
		if (!solicitandoCorreo && _introducircdigodeverificacin == null) {
			// Volver al paso de solicitar correo
			this.correoElectronico = null;
			this.solicitandoCorreo = true;
			configurarVistaInicial();
			this.getPasswordField().clear();
			return;
		}
		
		// Volver a la vista anterior completamente
		if (_introducircdigodeverificacin != null) {
			// Si viene del código de verificación, volver a esa vista
			if (_introducircdigodeverificacin._registrarse != null) {
				if (_introducircdigodeverificacin._registrarse._aCT01UsuarioNoRegistrado != null) {
					_introducircdigodeverificacin._registrarse._aCT01UsuarioNoRegistrado
						.getVerticalLayoutCentralNoRegistrado()
						.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
						.removeAll();
					_introducircdigodeverificacin._registrarse._aCT01UsuarioNoRegistrado
						.getVerticalLayoutCentralNoRegistrado()
						.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
						.add(_introducircdigodeverificacin);
				}
			}
		} else if (_aCT01UsuarioNoRegistrado != null) {
			// Volver a la vista de login (crear nueva instancia de Iniciarsesin)
			Iniciarsesin loginVista = new Iniciarsesin(_aCT01UsuarioNoRegistrado);
			_aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
				.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
				.removeAll();
			_aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
				.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
				.add(loginVista);
		}
	}
	
	private void configurarEventos() {
		// Configurar evento para el campo de contraseña (Enter para enviar)
		this.getPasswordField().addKeyPressListener(event -> {
			if (event.getKey().getKeys().contains("Enter")) {
				validarDatos();
			}
		});
		
		// Si no hay botones en la vista, podemos agregar uno programáticamente
		// o usar el evento de presionar Enter en el campo de contraseña
	}
		public void validarDatos() {
		if (solicitandoCorreo) {
			// Validar correo electrónico
			validarCorreoElectronico();
		} else {
			// Validar nueva contraseña
			validarNuevaContrasena();
		}
	}
	
	private void validarCorreoElectronico() {
		String correo = this.getPasswordField().getValue();
		
		if (correo == null || correo.trim().isEmpty()) {
			mostrarMensajeError("El correo electrónico no puede estar vacío");
			return;
		}
		
		// Validar formato de correo electrónico
		if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			mostrarMensajeError("Por favor introduce un correo electrónico válido");
			return;
		}
		
		// Verificar que el correo existe en la base de datos
		verificarCorreoYContinuar(correo);
	}
		private void verificarCorreoYContinuar(String correo) {
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado usuario = bd.validacionCorreo(correo);
			// Generar y mandar el PIN (re-utiliza la misma clase)


			if (usuario != null) {

				ACT04SistemadeCorreo mailer = new ACT04SistemadeCorreo(correo);
				this._introducircdigodeverificacin = null;   // si tu flujo lo necesita
				// Guarda mailer en un atributo si vas a validarlo después
				this._aCT04SistemadeCorreo = mailer;
				// Correo válido, pasar al siguiente paso
				this.correoElectronico = correo;
				this.solicitandoCorreo = false;
				configurarVistaContrasena();
				this.getPasswordField().clear(); // Limpiar el campo
			} else {
				// No cambiar el estado solicitandoCorreo para que se pueda cancelar correctamente
				mostrarMensajeError("No se encontró una cuenta asociada a este correo electrónico");
			}
		} catch (Exception e) {
			System.err.println("Error al verificar correo: " + e.getMessage());
			// No cambiar el estado solicitandoCorreo para que se pueda cancelar correctamente
			mostrarMensajeError("Error interno del sistema. Inténtelo de nuevo más tarde.");
		}
	}
	
	private void validarNuevaContrasena() {
		String nuevaContrasena = this.getPasswordField().getValue();
		
		// Validar formato de contraseña usando regex
		String regex = "^(?=.*[A-Z])(?=.*[¡!¿?@#$%^_\\+=;`<>&]).{8,14}$";
		
		if (nuevaContrasena == null || nuevaContrasena.trim().isEmpty()) {
			mostrarMensajeError("La contraseña no puede estar vacía");
			return;
		}
		
		if (!nuevaContrasena.matches(regex)) {
			mostrarMensajeError("La contraseña debe tener entre 8-14 caracteres, al menos una mayúscula y un carácter especial");
			return;
		}
		
		// Proceder con el restablecimiento
		restablecerContrasena(nuevaContrasena);
	}
	private void restablecerContrasena(String nuevaContrasena) {
		try {
			// Buscar usuario por correo electrónico
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Si tenemos el correo, intentar cambiar la contraseña
			if (correoElectronico != null && !correoElectronico.trim().isEmpty()) {
				// Buscar usuario por correo
				basededatos.Usuario_Registrado usuario = bd.validacionCorreo(correoElectronico);
				
				if (usuario != null) {
					// Cambiar contraseña usando el ID del usuario
					bd.cambiarContrasena(usuario.getId_usuario(), nuevaContrasena);
					mostrarMensajeExito();
				} else {
					mostrarMensajeError("No se encontró una cuenta asociada a este correo electrónico");
				}
			} else {
				mostrarMensajeError("No se pudo identificar la cuenta del usuario");
			}
			
		} catch (Exception e) {
			System.err.println("Error al restablecer contraseña: " + e.getMessage());
			mostrarMensajeError("Error interno del sistema. Inténtelo de nuevo más tarde.");
		}
	}
	
	private void mostrarMensajeError(String mensaje) {
		// Actualizar el messageBox con el error
		this.getMessageBox().removeAll();
		this.getMessageBox().add(new com.vaadin.flow.component.html.Paragraph(mensaje));
		this.getMessageBox().getStyle().set("background-color", "#ff4444");
		this.getMessageBox().getStyle().set("color", "#fff");
		
		// También mostrar notificación
		Notification.show(mensaje, 5000, Notification.Position.TOP_CENTER);
	}
		private void mostrarMensajeExito() {
		// Mostrar mensaje de éxito
		this.getMessageBox().removeAll();
		this.getMessageBox().add(new com.vaadin.flow.component.html.Paragraph("Contraseña restablecida exitosamente"));
		this.getMessageBox().getStyle().set("background-color", "#44ff44");
		this.getMessageBox().getStyle().set("color", "#000");
		
		Notification.show("Contraseña cambiada exitosamente", 3000, Notification.Position.TOP_CENTER);
		
		// Volver al login después de un breve delay
		com.vaadin.flow.component.UI.getCurrent().getPage().executeJs(
			"setTimeout(() => { " +
			"document.querySelector('vaadin-notification').style.display = 'none'; " +
			"}, 2000);"
		);
		
		// Navegar de vuelta al login después del delay
		new Thread(() -> {
			try {
				Thread.sleep(2500); // Esperar 2.5 segundos
				com.vaadin.flow.component.UI.getCurrent().access(() -> {
					if (_aCT01UsuarioNoRegistrado != null) {
						Iniciarsesin loginVista = new Iniciarsesin(_aCT01UsuarioNoRegistrado);
						_aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
							.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
							.removeAll();
						_aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
							.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
							.add(loginVista);
					}
				});
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}).start();
	}
	
	public void mensajeDeErrorRestablecimiento() {
		mostrarMensajeError("Error al procesar el restablecimiento de contraseña");
	}
}