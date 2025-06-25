package interfaz;

import mds2.MainView.Pantalla;

public class Verperfiladministrador extends Verperfil {
	// private event _eliminarperfil;
	// private event _banearusuario;
	// private event _detallarlongitudbaneo;
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	// Objeto ORMPersistable para el usuario cuyo perfil se muestra
	public basededatos.Usuario_Registrado u;

	public Verperfiladministrador(Vertweetadministrador _vertweetadministrador, basededatos.Usuario_Registrado u) {
		super();
		this._vertweetadministrador = _vertweetadministrador;
		this.u = u;
		this.getEditAccountButton().setVisible(false);

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.Agrupartweets(u);
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_vertweetadministrador);
		});

		this.getDeleteProfileButton().addClickListener(event -> {
			Eliminarperfil();
		});
		this.getBanProfileButton().addClickListener(event -> {
			Banearusuario();
		});

		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets(u);
		});

		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados(u);
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets(u);
		});

	}

	// Constructor de compatibilidad
	public Verperfiladministrador(Vertweetadministrador _vertweetadministrador) {
		this(_vertweetadministrador, null);
	}

	public Verperfiladministrador(Verretweetadministrador _verretweetadministrador, basededatos.Usuario_Registrado u) {
		super();
		this._verretweetadministrador = _verretweetadministrador;
		this.u = u;
		this.getEditAccountButton().setVisible(false);

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.Agrupartweets(u);
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_vertweetadministrador);
		});

		this.getDeleteProfileButton().addClickListener(event -> {
			Eliminarperfil();
		});
		this.getBanProfileButton().addClickListener(event -> {
			Banearusuario();
		});

		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets(u);
		});

		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados(u);
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets(u);
		});
	}

	// Constructor de compatibilidad
	public Verperfiladministrador(Verretweetadministrador _verretweetadministrador) {
		this(_verretweetadministrador, null);
	}

	private void rellenarDatosPerfil() {
		try {
			if (u != null) {
				// Rellenar nombre y nickname
				if (u.getNickname() != null) {
					this.getProfileName().setText(u.getNickname());
					this.getProfileUsername().setText("@" + u.getNickname());
				}

				// Rellenar descripción
				if (u.getDescripcion() != null && !u.getDescripcion().trim().isEmpty()) {
					this.getDescription().setText(u.getDescripcion());
				} else {
					this.getDescription().setText("Usuario de Twitter");
				}

				// Rellenar fecha de registro
				if (u.getFechaDeRegistro() != null) {
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
					this.getJoinDate().setText("Se unió en " + sdf.format(u.getFechaDeRegistro()));
				} // Calcular y mostrar contadores reales de seguidores y seguidos desde la base
					// de datos
				try {
					basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

					// Número de usuarios que sigue este usuario
					int siguiendo = bd.contarSeguidos(u.getId_usuario());
					this.getFollowingCount().setText(siguiendo + " siguiendo");

					// Número de usuarios que siguen a este usuario
					int seguidores = bd.contarSeguidores(u.getId_usuario());
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

				System.out.println("Datos de perfil cargados para administrador viendo: " + u.getNickname());
			} else {
				System.err.println("Error: No se pudo acceder a los datos del usuario");
			}
		} catch (Exception e) {
			System.err.println("Error al cargar datos del perfil: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Eliminarperfil() {
		System.out.println("Eliminar perfil");
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			bd.eliminarUsuario(u.getId_usuario());
			System.out.println("Perfil eliminado correctamente");
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(null));
		} catch (Exception e) {
			System.err.println("Error al eliminar el perfil: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Banearusuario() {
		System.out.println("Banear usuario");
	}

	public void Detallarlongitudbaneo() {
		throw new UnsupportedOperationException();
	}
}