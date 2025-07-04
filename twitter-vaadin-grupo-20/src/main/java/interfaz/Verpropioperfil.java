package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Usuario_Registrado;

public class Verpropioperfil extends Verperfil {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Editarcuenta _editarcuenta;
	public Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado;
	public Verlistadeseguidosregistrado _verlistadeseguidosregistrado;

	public Verpropioperfil(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		Usuario_Registrado usuario = MainView.obtenerUsuarioActual();
		// Rellenar datos del perfil con información del usuario actual
		rellenarDatosPropiosPerfil();

		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getUserTweetsTab().setText("Mis tweets");
		this.getLikedTweetsTab().setText("Tweets que me gustan");

		this.Agrupartweets(usuario);

		this.getLikedTweetsTab().addClickListener(event -> {
			Agrupartweetsgustados(usuario);
		});

		this.getRetweetsTab().addClickListener(event -> {
			Agruparretweets(usuario);
		});
		this.getUserTweetsTab().addClickListener(event -> {
			Agrupartweets(usuario);
		});
		this.getFollowingCount().addClickListener(event -> {
			Verlistadeseguidosregistrado();
		});
		this.getFollowersCount().addClickListener(event -> {
			Verlistadeseguidoresregistrado();
		});
		this.getEditAccountButton().addClickListener(event -> {
			Editarcuenta();
		});
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT02UsuarioRegistrado);
		});
	}

	public void Editarcuenta() {
		// Pasar el usuario actual al formulario de edición
		basededatos.Usuario_Registrado usuarioActual = (_aCT02UsuarioRegistrado != null) ? _aCT02UsuarioRegistrado.u
				: null;
		_editarcuenta = new Editarcuenta(this, usuarioActual);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_editarcuenta);
	}

	public void Verlistadeseguidoresregistrado() {
		_verlistadeseguidoresregistrado = new Verlistadeseguidoresregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidoresregistrado);
	}

	public void Verlistadeseguidosregistrado() {
		_verlistadeseguidosregistrado = new Verlistadeseguidosregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidosregistrado);
	}

	private void rellenarDatosPropiosPerfil() {
		try {
			if (_aCT02UsuarioRegistrado != null && _aCT02UsuarioRegistrado.u != null) {
				basededatos.Usuario_Registrado usuario = _aCT02UsuarioRegistrado.u;

				// Rellenar nombre y nickname (directamente desde Usuario_Registrado que hereda
				// de Usuario_Autentificado)
				if (usuario.getNickname() != null) {
					this.getProfileName().setText(usuario.getNickname());
					this.getProfileUsername().setText("@" + usuario.getNickname());
				}

				// Rellenar descripción
				if (usuario.getDescripcion() != null && !usuario.getDescripcion().trim().isEmpty()) {
					this.getDescription().setText(usuario.getDescripcion());
				} else {
					this.getDescription().setText("Nuevo usuario de Twitter");
				}

				// Rellenar fecha de registro
				if (usuario.getFechaDeRegistro() != null) {
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
					this.getJoinDate().setText("Se unió en " + sdf.format(usuario.getFechaDeRegistro()));
				} // Calcular y mostrar contadores reales de seguidores y seguidos desde la base
					// de datos
				try {
					BDPrincipal bd = new BDPrincipal();

					// Número de usuarios que sigue este usuario
					int siguiendo = bd.contarSeguidos(usuario.getId_usuario());
					this.getFollowingCount().setText(siguiendo + " siguiendo");

					// Número de usuarios que siguen a este usuario
					int seguidores = bd.contarSeguidores(usuario.getId_usuario());
					String seguidoresTexto;
					if (seguidores >= 1000) {
						double seguidoresK = seguidores / 1000.0;
						seguidoresTexto = String.format("%.1fK seguidores", seguidoresK);
					} else {
						seguidoresTexto = seguidores + " seguidores";
					}
					this.getFollowersCount().setText(seguidoresTexto);

				} catch (Exception e) {
					// En caso de error, mostrar valores por defecto
					this.getFollowingCount().setText("0 siguiendo");
					this.getFollowersCount().setText("0 seguidores");
					System.err.println("Error calculando seguidores/siguiendo: " + e.getMessage());
				}

				// Configurar imágenes de perfil y banner
				configurarImagenesPerfil(usuario);
				
				System.out.println("Datos del propio perfil cargados para usuario: " + usuario.getNickname());
			} else {
				System.err.println("Error: No se pudo acceder a los datos del usuario registrado");
			}
		} catch (Exception e) {
			System.err.println("Error al cargar datos del propio perfil: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Método público para actualizar los contadores de seguidores y seguidos
	 * Se puede llamar después de seguir/dejar de seguir para refrescar la UI
	 */
	public void actualizarContadores() {
		if (_aCT02UsuarioRegistrado != null && _aCT02UsuarioRegistrado.u != null) {
			try {
				BDPrincipal bd = new BDPrincipal();
				basededatos.Usuario_Registrado usuario = _aCT02UsuarioRegistrado.u;

				// Número de usuarios que sigue este usuario
				int siguiendo = bd.contarSeguidos(usuario.getId_usuario());
				this.getFollowingCount().setText(siguiendo + " siguiendo");

				// Número de usuarios que siguen a este usuario
				int seguidores = bd.contarSeguidores(usuario.getId_usuario());
				String seguidoresTexto;
				if (seguidores >= 1000) {
					double seguidoresK = seguidores / 1000.0;
					seguidoresTexto = String.format("%.1fK seguidores", seguidoresK);
				} else {
					seguidoresTexto = seguidores + " seguidores";
				}
				this.getFollowersCount().setText(seguidoresTexto);

				System.out.println("Contadores actualizados para propio perfil: " + usuario.getNickname());
			} catch (Exception e) {
				System.err.println("Error actualizando contadores: " + e.getMessage());
			}
		}
	}

	    /**
     * Método público para actualizar las imágenes del perfil tras editar cuenta.
     * Recarga el usuario desde la BD y actualiza tanto el perfil como el avatar superior.
     */
    public void actualizarImagenesPerfil() {
        try {
            // Recargar el usuario desde la base de datos para obtener los datos más recientes
            BDPrincipal bd = new BDPrincipal();
            Usuario_Registrado usuarioActualizado = bd.cargarUsuarioPorId(MainView.obtenerUsuarioActual().getId_usuario());
            
            if (usuarioActualizado != null) {
                // Actualizar la referencia global
                MainView.Usuario.usuarioRegistrado = usuarioActualizado;
                
                // Actualizar las imágenes del perfil usando el método heredado
                configurarImagenesPerfil(usuarioActualizado);
                
                // Actualizar el avatar superior en la vista principal
                if (_aCT02UsuarioRegistrado != null) {
                    _aCT02UsuarioRegistrado.u = usuarioActualizado;
                    _aCT02UsuarioRegistrado.actualizarAvatarSuperior();
                }
                
                // Rellenar otros datos del perfil
                rellenarDatosPropiosPerfil();
                
                System.out.println("Imágenes del perfil actualizadas tras edición de cuenta");
            }
        } catch (Exception e) {
            System.err.println("Error actualizando imágenes del perfil: " + e.getMessage());
            e.printStackTrace();
        }
    }
}