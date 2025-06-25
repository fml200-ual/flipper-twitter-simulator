package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaIniciarsesin;
import basededatos.BDPrincipal;

public class Iniciarsesin extends VistaIniciarsesin {
	// private event _mensajedeerroriniciosesin;
	// private event _contraseaolvidada;
	// private event _reenviarcorreo;
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Registrarse _registrarse;
	public ACT04SistemadeCorreo _aCT04SistemadeCorreo;

	public Iniciarsesin(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		// Ensamblado dinámico - Configurar listeners para todos los botones
		volver();
		setupLoginButtons();
		setupFormValidation();
		setupForgotPasswordLink();
	}

	private void setupLoginButtons() {
		// Configurar botón de inicio de sesión principal
		this.getLoginButton().addClickListener(event -> {
			// Validar datos antes de proceder
			if (validarCampos()) {
				Validardatos();
			}
		});

		// Configurar botón de registrarse
		this.getRegisterButton().addClickListener(event -> {
			// Navegar a la vista de registro
			navegarARegistro();
		});
	}

	private void setupFormValidation() {
		// Configurar validación en tiempo real para los campos
		this.getUsernameField().addValueChangeListener(event -> {
			if (event.getValue() != null && !event.getValue().trim().isEmpty()) {
				this.getUsernameField().setInvalid(false);
			}
		});

		this.getPasswordField().addValueChangeListener(event -> {
			if (event.getValue() != null && !event.getValue().trim().isEmpty()) {
				this.getPasswordField().setInvalid(false);
			}
		});
	}

	private void setupForgotPasswordLink() {
		// Configurar el enlace de contraseña olvidada usando JavaScript
		this.getForgotPasswordLink().addEventListener("click", event -> {
			Contraseaolvidada();
		});
	}

	private boolean validarCampos() {
		boolean isValid = true;

		// Validar campo de usuario
		if (this.getUsernameField().getValue() == null ||
				this.getUsernameField().getValue().trim().isEmpty()) {
			this.getUsernameField().setInvalid(true);
			this.getUsernameField().setErrorMessage("El campo de usuario es obligatorio");
			isValid = false;
		}

		// Validar campo de contraseña
		if (this.getPasswordField().getValue() == null ||
				this.getPasswordField().getValue().trim().isEmpty()) {
			this.getPasswordField().setInvalid(true);
			this.getPasswordField().setErrorMessage("La contraseña es obligatoria");
			isValid = false;
		}

		return isValid;
	}

	private void navegarARegistro() {
		_registrarse = new Registrarse(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_registrarse);
	}

	private void volver() {
		this.getBackButton().addClickListener(event -> {
			System.out.println("Volviendo a la vista anterior...");
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT01UsuarioNoRegistrado);
		});

	}

	public void Validardatos() {
		// Declaración del atributo IActor como en el patrón
		BDPrincipal iactor = new BDPrincipal();

		// Obtener los valores de los campos
		String username = this.getUsernameField().getValue();
		String password = this.getPasswordField().getValue();

		System.out.println("Intentando iniciar sesión con usuario: " + username);

		try {
			// Seguir el patrón del diagrama: usuario = iactor.Login(login, password)
			basededatos.Usuario_Registrado usuarioRegistrado = iactor.login(username, password);
			if (usuarioRegistrado != null) {
				System.out.println("Login exitoso como usuario registrado: " + usuarioRegistrado.getNickname());

				// Seguir el patrón: padre.MainView.removeAll() + crear vista + add
				Pantalla.MainView.removeAll(); // Crear la vista del usuario logueado con el usuario de la BD
				ACT02UsuarioRegistrado usuarioLogueado = new ACT02UsuarioRegistrado(
						Pantalla.MainView, usuarioRegistrado);
				Pantalla.MainView.add(usuarioLogueado);

				// Actualizar el usuario en la sesión global
				mds2.MainView.Usuario.usuarioRegistrado = usuarioRegistrado;

				return;
			}

			// Si llegamos aquí, las credenciales son incorrectas
			System.out.println("Credenciales incorrectas para usuario: " + username);
			Mensajedeerroriniciosesin();
		} catch (Exception e) {
			System.err.println("Error durante el login: " + e.getMessage());
			e.printStackTrace();
			Mensajedeerroriniciosesin();
		}
	}

	private void navegarAAdministrador() {
		try {
			// Crear la vista de administrador
			ACT03Administrador administradorView = new ACT03Administrador(null);

			// Navegar a la nueva vista
			Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(administradorView);

			System.out.println("Navegación exitosa a vista de administrador");
		} catch (Exception e) {
			System.err.println("Error al navegar a administrador: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Registrarse() {
		// Este método ya no se usa directamente, la navegación se hace en
		// navegarARegistro()
		navegarARegistro();
	}

	public void Mensajedeerroriniciosesin() {
		// Mostrar mensaje de error en los campos
		this.getUsernameField().setInvalid(true);
		this.getPasswordField().setInvalid(true);
		this.getUsernameField().setErrorMessage("Credenciales incorrectas");
		this.getPasswordField().setErrorMessage("Credenciales incorrectas");
	}
	public void Contraseaolvidada() {
		// Navegar a la vista de restablecer contraseña
		System.out.println("Navegando a restablecimiento de contraseña...");
		
		// Crear instancia de la vista de restablecimiento
		Restablecercontrasea restablecerContrasena = new Restablecercontrasea(_aCT01UsuarioNoRegistrado);
		
		// Navegar a la nueva vista
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(restablecerContrasena);
	}

	public void Reenviarcorreo() {
		// Lógica para reenviar correo de verificación
		System.out.println("Reenviando correo de verificación...");
		if (_aCT04SistemadeCorreo == null) {
			// _aCT04SistemadeCorreo = new ACT04SistemadeCorreo(this);
		}
	}
}