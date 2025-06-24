package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaRegistrarse;
import basededatos.BDPrincipal;
import java.util.Date;

public class Registrarse extends VistaRegistrarse {
	// private event _mensajedeerrorregistro;
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Iniciarsesin _iniciarsesin;
	public Introducircdigodeverificacin _introducircdigodeverificacin;
	public ACT05Google _aCT05Google;
	public IniciarsesinconGoogle _iniciarsesinconGoogle;

	public Registrarse(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		// Ensamblado dinámico - Configurar listeners para todos los botones y campos
		setupRegisterButtons();
		setupFormValidation();
		setupFieldListeners();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT01UsuarioNoRegistrado);
		});
	}

	public Registrarse(Iniciarsesin _iniciarsesin) {
		super();
		this._iniciarsesin = _iniciarsesin;
		// Ensamblado dinámico - Configurar listeners para todos los botones y campos
		setupRegisterButtons();
		setupFormValidation();
		setupFieldListeners();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_iniciarsesin);
		});
	}

	private void setupRegisterButtons() {
		// Configurar botón de registro principal
		this.getRegisterButton().addClickListener(event -> {
			if (validarTodosLosCampos()) {
				procesarRegistro();
			}
		});

		// Configurar botón de Google
		this.getGoogleLoginButton().addClickListener(event -> {
			IniciarsesinconGoogle();
		});
	}

	private void setupFormValidation() {
		// Marcar campos obligatorios
		this.getNameField().setRequired(true);
		this.getLastNameField().setRequired(true);
		this.getEmailField().setRequired(true);
		this.getNickField().setRequired(true);
		this.getPasswordField().setRequired(true);
		this.getAtSignField().setRequired(true);

		// Configurar placeholders
		this.getNameField().setPlaceholder("Ingresa tu nombre");
		this.getLastNameField().setPlaceholder("Ingresa tu apellido");
		this.getEmailField().setPlaceholder("ejemplo@correo.com");
		this.getNickField().setPlaceholder("nombre_usuario");
		this.getPasswordField().setPlaceholder("Mínimo 8 caracteres");
		this.getAtSignField().setPlaceholder("@usuario");
		this.getProfilePhotoUrlField().setPlaceholder("URL de foto opcional");
		this.getBackgroundUrlField().setPlaceholder("URL de fondo opcional");
		this.getDescriptionField().setPlaceholder("Cuéntanos algo sobre ti...");
	}

	private void setupFieldListeners() {
		// Listener para validación de email en tiempo real
		this.getEmailField().addValueChangeListener(event -> {
			String email = event.getValue();
			if (email != null && !email.isEmpty()) {
				if (isValidEmail(email)) {
					this.getEmailField().setInvalid(false);
				} else {
					this.getEmailField().setInvalid(true);
					this.getEmailField().setErrorMessage("Formato de email inválido");
				}
			}
		});

		// Listener para validación de contraseña
		this.getPasswordField().addValueChangeListener(event -> {
			String password = event.getValue();
			if (password != null && !password.isEmpty()) {
				if (password.length() >= 8) {
					this.getPasswordField().setInvalid(false);
				} else {
					this.getPasswordField().setInvalid(true);
					this.getPasswordField().setErrorMessage("La contraseña debe tener al menos 8 caracteres");
				}
			}
		});

		// Listener para validación de nick
		this.getNickField().addValueChangeListener(event -> {
			String nick = event.getValue();
			if (nick != null && !nick.isEmpty()) {
				if (isValidNick(nick)) {
					this.getNickField().setInvalid(false);
				} else {
					this.getNickField().setInvalid(true);
					this.getNickField().setErrorMessage("El nick solo puede contener letras, números y guiones");
				}
			}
		});

		// Listener para sincronizar @ con nick
		this.getNickField().addValueChangeListener(event -> {
			String nick = event.getValue();
			if (nick != null && !nick.isEmpty()) {
				this.getAtSignField().setValue("@" + nick);
			}
		});

		// Listeners para preview de imágenes (simulado)
		this.getProfilePhotoUrlField().addValueChangeListener(event -> {
			updateImagePreview(event.getValue(), "profile");
		});

		this.getBackgroundUrlField().addValueChangeListener(event -> {
			updateImagePreview(event.getValue(), "background");
		});
	}

	private boolean validarTodosLosCampos() {
		boolean isValid = true;

		// Validar nombre
		if (this.getNameField().getValue() == null || this.getNameField().getValue().trim().isEmpty()) {
			this.getNameField().setInvalid(true);
			this.getNameField().setErrorMessage("El nombre es obligatorio");
			isValid = false;
		}

		// Validar apellido
		if (this.getLastNameField().getValue() == null || this.getLastNameField().getValue().trim().isEmpty()) {
			this.getLastNameField().setInvalid(true);
			this.getLastNameField().setErrorMessage("El apellido es obligatorio");
			isValid = false;
		}

		// Validar email
		String email = this.getEmailField().getValue();
		if (email == null || email.trim().isEmpty()) {
			this.getEmailField().setInvalid(true);
			this.getEmailField().setErrorMessage("El email es obligatorio");
			isValid = false;
		} else if (!isValidEmail(email)) {
			this.getEmailField().setInvalid(true);
			this.getEmailField().setErrorMessage("Formato de email inválido");
			isValid = false;
		}

		// Validar nick
		String nick = this.getNickField().getValue();
		if (nick == null || nick.trim().isEmpty()) {
			this.getNickField().setInvalid(true);
			this.getNickField().setErrorMessage("El nick es obligatorio");
			isValid = false;
		} else if (!isValidNick(nick)) {
			this.getNickField().setInvalid(true);
			this.getNickField().setErrorMessage("El nick solo puede contener letras, números y guiones");
			isValid = false;
		}

		// Validar contraseña
		String password = this.getPasswordField().getValue();
		if (password == null || password.trim().isEmpty()) {
			this.getPasswordField().setInvalid(true);
			this.getPasswordField().setErrorMessage("La contraseña es obligatoria");
			isValid = false;
		} else if (password.length() < 8) {
			this.getPasswordField().setInvalid(true);
			this.getPasswordField().setErrorMessage("La contraseña debe tener al menos 8 caracteres");
			isValid = false;
		}

		return isValid;
	}

	private boolean isValidEmail(String email) {
		return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
	}

	private boolean isValidNick(String nick) {
		return nick != null && nick.matches("^[a-zA-Z0-9_-]+$");
	}

	private void updateImagePreview(String url, String type) {
		// Simular actualización de preview de imagen
		if (url != null && !url.trim().isEmpty()) {
			System.out.println("Actualizando preview de " + type + " con URL: " + url);
			// Aquí se podría implementar lógica para mostrar preview real
		}
	}	private void procesarRegistro() {
		try {
			// Declaración del atributo IActor como en el patrón del diagrama de secuencia
			BDPrincipal iactor = new BDPrincipal();
			
			// Obtener los valores de los campos siguiendo el patrón
			String email = this.getEmailField().getValue().trim();
			String nick = this.getNickField().getValue().trim();
			String password = this.getPasswordField().getValue();
			String descripcion = this.getDescriptionField().getValue();
			String fotoPerfilURL = this.getProfilePhotoUrlField().getValue();
			String imagenFondoURL = this.getBackgroundUrlField().getValue();
			
			// Usar valores por defecto si están vacíos
			if (descripcion == null || descripcion.trim().isEmpty()) {
				descripcion = "Nuevo usuario de Twitter";
			}
			if (fotoPerfilURL == null || fotoPerfilURL.trim().isEmpty()) {
				fotoPerfilURL = "default-profile.jpg";
			}
			if (imagenFondoURL == null || imagenFondoURL.trim().isEmpty()) {
				imagenFondoURL = "default-background.jpg";
			}
			
			System.out.println("Procesando registro para usuario: " + nick);
			
			// Seguir el patrón del diagrama: actor = iactor.Join(FirstName, LastName,...)
			basededatos.Usuario_Registrado nuevoUsuario = iactor.registrar(
				nick, 
				descripcion, 
				imagenFondoURL, 
				fotoPerfilURL, 
				email, 
				password, 
				new Date()
			);
			
			if (nuevoUsuario != null) {
				System.out.println("Registro exitoso para usuario: " + nick);
				
				// Almacenar el usuario registrado para el flujo de verificación
				// Esto simula el envío del código de verificación por email
				storeUserForVerification(nuevoUsuario);
				
				// Navegar a la vista de código de verificación siguiendo el flujo
				System.out.println("Navegando a código de verificación...");
				Introducircdigodeverificacin();
			} else {
				System.err.println("Error durante el registro - posiblemente el usuario ya existe");
				// Mostrar mensaje de error apropiado
				Mensajedeerrorregistro();
			}
			
		} catch (Exception e) {
			System.err.println("Error durante el registro: " + e.getMessage());
			e.printStackTrace();
			// Mostrar mensaje de error genérico
			Mensajedeerrorregistro();
		}
	}
	
	// Método para almacenar temporalmente el usuario para verificación
	private void storeUserForVerification(basededatos.Usuario_Registrado usuario) {
		// En una implementación real, aquí se enviaría el email de verificación
		// y se almacenaría temporalmente el estado del registro
		System.out.println("Almacenando usuario para verificación: " + usuario.getNickname());
		System.out.println("Simulando envío de código de verificación a: " + usuario.getCorreoElectronico());
		
		// Simular generación y envío de código
		String codigoVerificacion = generateVerificationCode();
		System.out.println("Código de verificación generado: " + codigoVerificacion);
		
		// En una implementación real, se guardaría en una tabla temporal o cache		// y se enviaría por email usando el ACT04SistemadeCorreo
	}
	
	// Método para generar código de verificación
	private String generateVerificationCode() {
		// Generar código de 4 dígitos aleatorio
		return String.format("%04d", (int)(Math.random() * 10000));
	}

	public void Mensajedeerrorregistro() {
		// Mostrar mensajes de error en los campos relevantes
		this.getEmailField().setInvalid(true);
		this.getNickField().setInvalid(true);
		this.getEmailField().setErrorMessage("Este email ya está registrado");
		this.getNickField().setErrorMessage("Este nick ya está en uso");

		// También se podría mostrar una notificación general
		System.out.println("Error: Datos duplicados encontrados");
	}
	public void Introducircdigodeverificacin() {
		// Navegar directamente a la vista de código de verificación
		System.out.println("Navegando a introducir código de verificación...");
		System.out.println("_aCT01UsuarioNoRegistrado es null: " + (_aCT01UsuarioNoRegistrado == null));
		System.out.println("_iniciarsesin es null: " + (_iniciarsesin == null));

		_introducircdigodeverificacin = new Introducircdigodeverificacin(this);

		// Navegar a la vista de código de verificación
		if (_aCT01UsuarioNoRegistrado != null) {
			_aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
					.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class).removeAll();
			_aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
					.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
					.add(_introducircdigodeverificacin);
		} else if (_iniciarsesin != null) {
			_iniciarsesin._aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
					.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class).removeAll();
			_iniciarsesin._aCT01UsuarioNoRegistrado.getVerticalLayoutCentralNoRegistrado()
					.as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
					.add(_introducircdigodeverificacin);
		}
	}

	public boolean Comprobarnoduplicadodedatos() {
		// Simular comprobación de datos duplicados
		String email = this.getEmailField().getValue();
		String nick = this.getNickField().getValue();

		System.out.println("Comprobando datos duplicados para email: " + email + " y nick: " + nick);

		// Simulación: devolver false si el email es "test@test.com" o nick es "admin"
		if ("test@test.com".equals(email) || "admin".equals(nick)) {
			return false; // Datos duplicados encontrados
		}

		return true; // No hay duplicados
	}

	public void IniciarsesinconGoogle() {
		// Aquí iría la lógica de autenticación con Google para registro
		System.out.println("Iniciando registro con Google...");
		// Crear instancia del componente de Google si es necesario
		if (_aCT05Google == null) {
			// _aCT05Google = new ACT05Google(this);
		}
	}
}