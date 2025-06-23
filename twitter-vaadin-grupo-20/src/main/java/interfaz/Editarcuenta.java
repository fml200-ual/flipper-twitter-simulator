package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaEditarcuenta;
import basededatos.BDPrincipal;

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

		// Rellenar datos actuales del usuario
		rellenarDatosUsuario();

		// Configurar eventos de los botones
		this.getCancelarButton().addClickListener(event -> Cancelar());
		
		// Agregar botón de guardar cambios (asumiendo que existe en la vista)
		// this.getGuardarButton().addClickListener(event -> guardarCambios());
	}
	
	// Constructor de compatibilidad temporal
	public Editarcuenta(Verpropioperfil _verpropioperfil) {
		this(_verpropioperfil, null);
	}
		private void rellenarDatosUsuario() {
		if (u != null) {
			// Rellenar campos de edición con datos actuales
			if (u.getNickname() != null) {
				// this.getNicknameField().setValue(u.getNickname());
			}
			if (u.getDescripcion() != null) {
				// this.getDescripcionField().setValue(u.getDescripcion());
			}
			// TODO: Rellenar otros campos de edición cuando estén disponibles los getters
		}
	}
		public void guardarCambios() {
		if (u == null) {
			System.err.println("No hay usuario para modificar");
			return;
		}
		
		try {
			// Obtener los nuevos valores de los campos (comentados hasta que existan los getters)
			String nuevoNickname = u.getNickname(); // this.getNicknameField().getValue();
			String nuevaDescripcion = u.getDescripcion(); // this.getDescripcionField().getValue();
			String nuevaImagenFondo = u.getImagenFondoURL(); // this.getImagenFondoField().getValue();
			String nuevaFotoPerfil = u.getFotoPerfilURL(); // this.getFotoPerfilField().getValue();
			String nuevaContrasena = u.getContrasena(); // this.getPasswordField().getValue();
			
			System.out.println("Guardando cambios para usuario: " + u.getNickname());
			
			// Crear instancia de la base de datos
			BDPrincipal bd = new BDPrincipal();
			
			// Actualizar el perfil del usuario
			basededatos.Usuario_Registrado usuarioActualizado = bd.modificarPerfilSimple(
				u.getORMID(), 
				nuevoNickname, 
				nuevaDescripcion, 
				nuevaImagenFondo, 
				nuevaFotoPerfil, 
				nuevaContrasena
			);
			
			if (usuarioActualizado != null) {
				System.out.println("Perfil actualizado exitosamente");
				// Actualizar el objeto local
				this.u = usuarioActualizado;
				
				// Volver a la vista del perfil con los datos actualizados
				// Crear constructor que acepte los parámetros correctos
				if (_verpropioperfil != null) {
					Pantalla.MainView.removeAll();
					Pantalla.MainView.add(_verpropioperfil);
				} else {
					Cancelar(); // Volver a la vista anterior
				}
			} else {
				System.err.println("Error al actualizar el perfil");
				Errordeedicin();
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la actualización del perfil: " + e.getMessage());
			e.printStackTrace();
			Errordeedicin();
		}
	}	public void Eliminarcuenta() {
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
		throw new UnsupportedOperationException();
	}

	public void Comprobarnoduplicadodearrobaynick() {
		throw new UnsupportedOperationException();
	}

	public void Cancelar() {
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(Pantalla.Anterior);
	}
}