package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaEditarcuenta;
import basededatos.BDPrincipal;

public class Editarcuenta extends VistaEditarcuenta {
	// private event _eliminarcuenta;
	// private event _errordeedicin;
	public Verpropioperfil _verpropioperfil;
	
	// Objeto ORMPersistable para el usuario cuya cuenta se edita
	public basededatos.Usuario_Registrado u;	public Editarcuenta(Verpropioperfil _verpropioperfil, basededatos.Usuario_Registrado u) {
		super();
		this._verpropioperfil = _verpropioperfil;
		this.u = u;

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
			String nuevoNickname = this.getNickField().getValue() != null ? this.getNickField().getValue().trim() : u.getNickname();
			String nuevaDescripcion = this.getDescripcionField().getValue() != null ? this.getDescripcionField().getValue().trim() : u.getDescripcion();
			String nuevaImagenFondo = this.getFondoField().getValue() != null ? this.getFondoField().getValue().trim() : u.getImagenFondoURL();
			String nuevaFotoPerfil = this.getFotoPerfilField().getValue() != null ? this.getFotoPerfilField().getValue().trim() : u.getFotoPerfilURL();
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
				nuevaContrasena
			);
			
			if (usuarioActualizado != null) {
				System.out.println("Perfil actualizado exitosamente");
				
				// Seguir el patrón: this._usuario = new Usuario(this._usuario.MainView, u);
				// Actualizar el usuario en la sesión global y en el contexto
				mds2.MainView.Usuario.usuarioRegistrado = usuarioActualizado;				if (_verpropioperfil != null && _verpropioperfil._aCT02UsuarioRegistrado != null) {
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
			
			// Eliminar el usuario de la base de datos
			bd.eliminarPerfil(u.getORMID());
			
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
}