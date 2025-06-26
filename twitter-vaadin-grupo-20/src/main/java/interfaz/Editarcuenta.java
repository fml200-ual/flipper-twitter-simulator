package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;
import vistas.VistaEditarcuenta;

import basededatos.BDPrincipal;
import basededatos.Usuario_Registrado;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;

public class Editarcuenta extends VistaEditarcuenta {
	// private event _eliminarcuenta;
	// private event _errordeedicin;
	public Verpropioperfil _verpropioperfil;

	// Objeto ORMPersistable para el usuario cuya cuenta se edita
	public basededatos.Usuario_Registrado u;

	public Editarcuenta(Verpropioperfil _verpropioperfil, basededatos.Usuario_Registrado u) {
		super();
		this._verpropioperfil = _verpropioperfil;
		this.u = u;

		System.out.println("🔧 INICIANDO Editarcuenta - VERSIÓN CORREGIDA 2.0");

		// Inicializar contenedores de preview
		inicializarPreviewContainers();

		// Rellenar datos actuales del usuario
		rellenarDatosUsuario();

		// Configurar eventos de los botones
		this.getCancelarButton().addClickListener(event -> Cancelar());
		this.getContinuarButton().addClickListener(event -> guardarCambios());
		this.getEliminarCuentaButton().addClickListener(event -> Eliminarcuenta());

		// Agregar listener para sincronizar @ con nick
		this.getNickField().addValueChangeListener(event -> {
			String nick = event.getValue();
			if (nick != null && !nick.isEmpty()) {
				this.getArrobField().setValue("@" + nick);
			}
		});
		
		// Listeners para preview de imágenes
		this.getFotoPerfilField().addValueChangeListener(event -> {
			updateImagePreview(event.getValue(), "profile");
		});

		this.getFondoField().addValueChangeListener(event -> {
			updateImagePreview(event.getValue(), "background");
		});
	}

	// Constructor de compatibilidad temporal
	public Editarcuenta(Verpropioperfil _verpropioperfil) {
		this(_verpropioperfil, null);
	}

	private void rellenarDatosUsuario() {
		if (u != null) {
			// Rellenar campos de edición con datos actuales
			if (u.getNickname() != null) {
				this.getArrobField().setValue("@" + u.getNickname());
				this.getNickField().setValue(u.getNickname());
			}
			if (u.getDescripcion() != null) {
				this.getDescripcionField().setValue(u.getDescripcion());
			}
			if (u.getImagenFondoURL() != null) {
				this.getFondoField().setValue(u.getImagenFondoURL());
			}
			if (u.getFotoPerfilURL() != null) {
				this.getFotoPerfilField().setValue(u.getFotoPerfilURL());
			}

			System.out.println("Datos del usuario cargados en el formulario de edición");
		}
	}

	public void guardarCambios() {
		if (u == null) {
			System.err.println("No hay usuario para modificar");
			return;
		}

		try {
			// Declaración del atributo IActor como en el patrón
			BDPrincipal iactor = new BDPrincipal();

			// Obtener los nuevos valores de los campos
			String nuevoNickname = this.getNickField().getValue() != null ? this.getNickField().getValue().trim()
					: u.getNickname();
			String nuevaDescripcion = this.getDescripcionField().getValue() != null
					? this.getDescripcionField().getValue().trim()
					: u.getDescripcion();
			String nuevaImagenFondo = this.getFondoField().getValue() != null ? this.getFondoField().getValue().trim()
					: u.getImagenFondoURL();
			String nuevaFotoPerfil = this.getFotoPerfilField().getValue() != null
					? this.getFotoPerfilField().getValue().trim()
					: u.getFotoPerfilURL();
			String nuevaContrasena = u.getContrasena(); // Mantener contraseña actual

			// Validaciones básicas
			if (nuevoNickname == null || nuevoNickname.isEmpty()) {
				System.err.println("El nickname no puede estar vacío");
				Errordeedicin();
				return;
			}

			// Usar valores por defecto si están vacíos
			if (nuevaDescripcion == null || nuevaDescripcion.isEmpty()) {
				nuevaDescripcion = "Usuario de Twitter";
			}
			if (nuevaImagenFondo == null || nuevaImagenFondo.isEmpty()) {
				nuevaImagenFondo = "default-background.jpg";
			}
			if (nuevaFotoPerfil == null || nuevaFotoPerfil.isEmpty()) {
				nuevaFotoPerfil = "default-profile.jpg";
			}

			System.out.println("Actualizando perfil siguiendo el patrón ORM...");
			System.out.println("Usuario ID: " + u.getORMID() + ", Nuevo nickname: " + nuevoNickname);

			// Seguir el patrón del diagrama:
			// usuario u = this._usuario._iUsuario.actualizar(_usuario.u.getID(), ...)
			basededatos.Usuario_Registrado usuarioActualizado = iactor.modificarPerfilSimple(
					u.getORMID(),
					nuevoNickname,
					nuevaDescripcion,
					nuevaImagenFondo,
					nuevaFotoPerfil,
					nuevaContrasena);

			if (usuarioActualizado != null) {
				System.out.println("Perfil actualizado exitosamente");

				// Seguir el patrón: this._usuario = new Usuario(this._usuario.MainView, u);
				// Actualizar el usuario en la sesión global y en el contexto
				mds2.MainView.Usuario.usuarioRegistrado = usuarioActualizado;
				if (_verpropioperfil != null && _verpropioperfil._aCT02UsuarioRegistrado != null) {
					_verpropioperfil._aCT02UsuarioRegistrado.u = usuarioActualizado;
				}

				// Seguir el patrón: this._usuario.MainView.removeAll() + add
				// Volver a la vista del perfil actualizada
				Cancelar();
			} else {
				System.err.println("Error al actualizar el perfil");
				Errordeedicin();
			}

		} catch (Exception e) {
			System.err.println("Error durante la actualización del perfil: " + e.getMessage());
			e.printStackTrace();
			Errordeedicin();
		}

		// Actualizar las imágenes del perfil y el avatar superior tras guardar cambios
		if (_verpropioperfil != null) {
			_verpropioperfil.actualizarImagenesPerfil();
		}
	}

	public void Eliminarcuenta() {
		if (u == null) {
			System.err.println("No hay usuario para eliminar");
			return;
		}

		try {
			System.out.println("Eliminando cuenta del usuario: " + u.getNickname());

			// Crear instancia de la base de datos
			BDPrincipal bd = new BDPrincipal();
			Usuario_Registrado usuario = MainView.obtenerUsuarioActual();

			// Eliminar el usuario de la base de datos
			bd.eliminarPerfil(usuario.getId_usuario());

			System.out.println("Cuenta eliminada exitosamente");

			// Navegar de vuelta a la vista de usuario no registrado (logout forzado)
			ACT01UsuarioNoRegistrado vistaInicial = new ACT01UsuarioNoRegistrado(null);
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(vistaInicial);

		} catch (Exception e) {
			System.err.println("Error durante la eliminación de cuenta: " + e.getMessage());
			e.printStackTrace();
			// Mostrar mensaje de error si no se pudo eliminar
			Errordeedicin();
		}
	}

	public void Errordeedicin() {
		// Mostrar mensaje de error en la consola y marcar campos como inválidos
		System.err.println("Error al editar la cuenta");

		// Marcar los campos como inválidos para mostrar feedback visual
		this.getNickField().setInvalid(true);
		this.getNickField().setErrorMessage("Error al actualizar el perfil");

		// También se podría mostrar una notificación
		System.err.println("Por favor, revise los datos e intente nuevamente");
	}

	public void Comprobarnoduplicadodearrobaynick() {
		throw new UnsupportedOperationException();
	}

	public void Cancelar() {
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(Pantalla.Anterior);
	}
	
	/**
	 * Inicializar contenedores para preview de imágenes
	 */
	private void inicializarPreviewContainers() {
		try {
			// Usar directamente los contenedores existentes de la vista (perfilPreviewContainer, fondoPreviewContainer)
			// No crear contenedores adicionales - usar los que ya están en el HTML
			
			// Limpiar los contenedores existentes
			this.getPerfilPreviewContainer().removeAll();
			this.getFondoPreviewContainer().removeAll();
			
			// Asegurar que los contenedores de la vista estén visibles
			this.getPerfilPreviewContainer().setVisible(true);
			this.getFondoPreviewContainer().setVisible(true);
			
			System.out.println("✅ Contenedores de preview inicializados - usando divs existentes del HTML en Editarcuenta");
			
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
		this.getPerfilPreviewContainer().removeAll();
		
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
			this.getPerfilPreviewContainer().add(imagen);
			System.out.println("✅ Imagen de perfil agregada al preview en Editarcuenta: " + url);
		} catch (Exception e) {
			Div urlInfo = new Div();
			urlInfo.setText("Error cargando imagen");
			urlInfo.getStyle()
				.set("font-size", "10px")
				.set("color", "#ff4444")
				.set("text-align", "center");
			this.getPerfilPreviewContainer().add(urlInfo);
			System.out.println("❌ Error cargando imagen de perfil en Editarcuenta: " + url);
		}
	}
	
	/**
	 * Mostrar preview de imagen de fondo
	 */
	private void mostrarPreviewImagenFondo(String url) {
		// Usar directamente el contenedor del HTML
		this.getFondoPreviewContainer().removeAll();
		
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
			this.getFondoPreviewContainer().add(imagen);
			System.out.println("✅ Imagen de fondo agregada al preview en Editarcuenta: " + url);
		} catch (Exception e) {
			Div urlInfo = new Div();
			urlInfo.setText("Error cargando imagen");
			urlInfo.getStyle()
				.set("font-size", "10px")
				.set("color", "#ff4444")
				.set("text-align", "center");
			this.getFondoPreviewContainer().add(urlInfo);
			System.out.println("❌ Error cargando imagen de fondo en Editarcuenta: " + url);
		}
	}
	/**
	 * Limpiar preview de imagen
	 */
	private void limpiarPreview(String tipo) {
		System.out.println("Limpiando preview de tipo: " + tipo + " en Editarcuenta");
		if ("profile".equals(tipo)) {
			this.getPerfilPreviewContainer().removeAll();
		} else if ("background".equals(tipo)) {
			this.getFondoPreviewContainer().removeAll();
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
}