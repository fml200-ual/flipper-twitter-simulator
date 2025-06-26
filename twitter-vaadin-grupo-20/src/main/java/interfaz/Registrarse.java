package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaRegistrarse;
import basededatos.BDPrincipal;
import java.util.Date;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;

public class Registrarse extends VistaRegistrarse {
	// private event _mensajedeerrorregistro;
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Iniciarsesin _iniciarsesin;
	public Introducircdigodeverificacin _introducircdigodeverificacin;
	public ACT05Google _aCT05Google;
	public IniciarsesinconGoogle _iniciarsesinconGoogle;
	public String _codigoVerificacion;
	private ACT04SistemadeCorreo _sistemaCorreo; // Agregar instancia del sistema de correo

	public Registrarse(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		this._sistemaCorreo = new ACT04SistemadeCorreo(); // Inicializar el sistema de correo
		// Ensamblado dinámico - Configurar listeners para todos los botones y campos
		setupRegisterButtons();
		setupFormValidation();
		setupFieldListeners();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT01UsuarioNoRegistrado);
		});
		
		// Mostrar preview de prueba para verificar que funciona
		// mostrarPreviewDePrueba(); // Descomentar para probar
	}

	public Registrarse(Iniciarsesin _iniciarsesin) {
		super();
		this._iniciarsesin = _iniciarsesin;
		this._sistemaCorreo = new ACT04SistemadeCorreo(); // Inicializar el sistema de correo
		// Ensamblado dinámico - Configurar listeners para todos los botones y campos
		setupRegisterButtons();
		setupFormValidation();
		setupFieldListeners();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_iniciarsesin);
		});
		
		// Mostrar preview de prueba para verificar que funciona
		// mostrarPreviewDePrueba(); // Descomentar para probar
	}

	private void setupRegisterButtons() {
		// Configurar botón de registro principal
		this.getRegisterButton().addClickListener(event -> {
			if (validarTodosLosCampos()) {
				procesarRegistro();
			}
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

	/**
	 * Inicializar contenedores para preview de imágenes
	 */
	private void inicializarPreviewContainers() {
		try {
			// Usar directamente los contenedores existentes de la vista (profileImagePreview, backgroundImagePreview)
			// No crear contenedores adicionales - usar los que ya están en el HTML
			
			// Limpiar los contenedores existentes
			this.getProfileImagePreview().removeAll();
			this.getBackgroundImagePreview().removeAll();
			
			// Asegurar que los contenedores de la vista estén visibles
			this.getProfileImagePreview().setVisible(true);
			this.getBackgroundImagePreview().setVisible(true);
			
			System.out.println("Contenedores de preview inicializados - usando divs existentes del HTML");
			
		} catch (Exception e) {
			System.err.println("Error inicializando contenedores de preview: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void updateImagePreview(String url, String type) {
		try {
			if (url != null && !url.trim().isEmpty()) {
				System.out.println("Actualizando preview de " + type + " con URL: " + url);
				
				// Validar que la URL sea de imagen
				if (esUrlValida(url)) {
					if ("profile".equals(type)) {
						mostrarPreviewImagenPerfil(url);
					} else if ("background".equals(type)) {
						mostrarPreviewImagenFondo(url);
					}
				} else {
					limpiarPreview(type);
					mostrarNotificacion("URL de imagen no válida", "error");
				}
			} else {
				limpiarPreview(type);
			}
		} catch (Exception e) {
			System.err.println("Error en preview de imagen: " + e.getMessage());
			limpiarPreview(type);
		}
	}
	
	/**
	 * Validar si la URL es válida para imagen
	 */
	private boolean esUrlValida(String url) {
		if (url == null || url.trim().isEmpty()) {
			return false;
		}
		
		url = url.toLowerCase();
		
		// Verificar si termina con extensiones de imagen
		if (url.endsWith(".jpg") || url.endsWith(".jpeg") || url.endsWith(".png") || 
			url.endsWith(".gif") || url.endsWith(".webp") || url.endsWith(".bmp")) {
			return true;
		}
		
		// Verificar si es de sitios conocidos de imágenes
		if (url.contains("imgur.com") || url.contains("imagebb.com") || 
			url.contains("unsplash.com") || url.contains("images.")) {
			return true;
		}
		
		// Por defecto, asumir que puede ser válida si empieza con http
		return url.startsWith("http");
	}
	
	/**
	 * Mostrar preview de imagen de perfil
	 */
	private void mostrarPreviewImagenPerfil(String url) {
		// Usar directamente el contenedor del HTML
		this.getProfileImagePreview().removeAll();
		
		try {
			Image imagen = new Image(url, "Preview foto de perfil");
			imagen.getStyle()
				.set("width", "50px")
				.set("height", "50px")
				.set("border-radius", "50%")
				.set("object-fit", "cover")
				.set("border", "2px solid #00FFFF")
				.set("box-shadow", "0 0 5px #00FFFF");
			
			// Agregar directamente al div del HTML
			this.getProfileImagePreview().add(imagen);
			System.out.println("✅ Imagen de perfil agregada al preview: " + url);
		} catch (Exception e) {
			Div urlInfo = new Div();
			urlInfo.setText("Error cargando imagen");
			urlInfo.getStyle()
				.set("font-size", "10px")
				.set("color", "#ff4444")
				.set("text-align", "center");
			this.getProfileImagePreview().add(urlInfo);
			System.out.println("❌ Error cargando imagen de perfil: " + url);
		}
	}
	
	/**
	 * Mostrar preview de imagen de fondo
	 */
	private void mostrarPreviewImagenFondo(String url) {
		// Usar directamente el contenedor del HTML
		this.getBackgroundImagePreview().removeAll();
		
		try {
			Image imagen = new Image(url, "Preview imagen de fondo");
			imagen.getStyle()
				.set("width", "50px")
				.set("height", "30px")
				.set("border-radius", "8px")
				.set("object-fit", "cover")
				.set("border", "2px solid #00FFFF")
				.set("box-shadow", "0 0 5px #00FFFF");
			
			// Agregar directamente al div del HTML
			this.getBackgroundImagePreview().add(imagen);
			System.out.println("✅ Imagen de fondo agregada al preview: " + url);
		} catch (Exception e) {
			Div urlInfo = new Div();
			urlInfo.setText("Error cargando imagen");
			urlInfo.getStyle()
				.set("font-size", "10px")
				.set("color", "#ff4444")
				.set("text-align", "center");
			this.getBackgroundImagePreview().add(urlInfo);
			System.out.println("❌ Error cargando imagen de fondo: " + url);
		}
	}
	/**
	 * Limpiar preview de imagen
	 */
	private void limpiarPreview(String tipo) {
		System.out.println("Limpiando preview de tipo: " + tipo);
		if ("profile".equals(tipo)) {
			this.getProfileImagePreview().removeAll();
		} else if ("background".equals(tipo)) {
			this.getBackgroundImagePreview().removeAll();
		}
	}
	
	/**
	 * Mostrar notificación
	 */
	private void mostrarNotificacion(String mensaje, String tipo) {
		Notification.Position position = Notification.Position.BOTTOM_CENTER;
		int duration = 3000;
		
		if ("error".equals(tipo)) {
			duration = 4000;
			position = Notification.Position.MIDDLE;
		}
		
		Notification.show(mensaje, duration, position);
	}

	private void procesarRegistro() {
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
					new Date());

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
		_codigoVerificacion = generateVerificationCode();
		System.out.println("Código de verificación generado: " + _codigoVerificacion);

		// En una implementación real, se guardaría en una tabla temporal o cache // y
		// se enviaría por email usando el ACT04SistemadeCorreo
		_sistemaCorreo.enviarCorreo(usuario.getCorreoElectronico(), _codigoVerificacion);

	}

	// Método para generar código de verificación
	private String generateVerificationCode() {
		// Generar código de 4 dígitos aleatorio
		return String.format("%04d", (int) (Math.random() * 10000));
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

		_introducircdigodeverificacin = new Introducircdigodeverificacin(this, _sistemaCorreo);

		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_introducircdigodeverificacin);

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