package interfaz;

import mds2.MainView.Pantalla;

public class Verperfilnoregistrado extends Verperfil {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado;
	public Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado;
	public Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado;

	// Objeto ORMPersistable para el usuario cuyo perfil se muestra
	public basededatos.Usuario_Registrado u;

	public Verperfilnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._listafijadeusuariosnoregistrado = _listafijadeusuariosnoregistrado;
		this.u = u;

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getEditAccountButton().setVisible(false);

		this.Agrupartweets(u);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado);
		});
		this.getFollowersCount().addClickListener(event -> Verlistaseguidoresnoregistrado());
		this.getFollowingCount().addClickListener(event -> Verlistaseguidosnoregistrado());
		this.getUserTweetsTab().addClickListener(event -> Agrupartweets(u));
		this.getRetweetsTab().addClickListener(event -> Agruparretweets(u));
		this.getLikedTweetsTab().addClickListener(event -> Agrupartweetsgustados(u));
	}

	public Verperfilnoregistrado(Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._verlistaampliadadeusuariosnoregistrado = _verlistaampliadadeusuariosnoregistrado;
		this.u = u;

		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getEditAccountButton().setVisible(false);

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.Agrupartweets(u);

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadeusuariosnoregistrado);
		});
		this.getFollowersCount().addClickListener(event -> Verlistaseguidoresnoregistrado());
		this.getFollowingCount().addClickListener(event -> Verlistaseguidosnoregistrado());
		this.getUserTweetsTab().addClickListener(event -> Agrupartweets(u));
		this.getRetweetsTab().addClickListener(event -> Agruparretweets(u));
		this.getLikedTweetsTab().addClickListener(event -> Agrupartweetsgustados(u));
	}

	public void Verlistaseguidoresnoregistrado() {
		_verlistaseguidoresnoregistrado = new Verlistaseguidoresnoregistrado(this, u);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaseguidoresnoregistrado);
	}

	public void Verlistaseguidosnoregistrado() {
		_verlistaseguidosnoregistrado = new Verlistaseguidosnoregistrado(this, u);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaseguidosnoregistrado);
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

				// Configurar imágenes de perfil
				configurarImagenesPerfil();

				System.out.println("Datos de perfil cargados para usuario no registrado viendo: " + u.getNickname());
			} else {
				System.err.println("Error: No se pudo acceder a los datos del usuario");
			}
		} catch (Exception e) {
			System.err.println("Error al cargar datos del perfil: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void configurarImagenesPerfil() {
		try {
			if (u != null) {
				// Configurar imagen de fondo/banner
				String imagenFondoURL = u.getImagenFondoURL();
				if (imagenFondoURL != null && !imagenFondoURL.trim().isEmpty() && 
					!imagenFondoURL.equals("default-background.jpg")) {
					// Configurar como imagen de fondo real
					this.getCoverPhoto().getStyle()
						.set("background-image", "url('" + imagenFondoURL + "')")
						.set("background-size", "cover")
						.set("background-position", "center")
						.set("background-repeat", "no-repeat");
					this.getCoverPhoto().setText(""); // Quitar la "X" placeholder
				} else {
					// Usar imagen por defecto o placeholder
					this.getCoverPhoto().getStyle()
						.set("background-image", "linear-gradient(135deg, #667eea 0%, #764ba2 100%)")
						.set("background-size", "cover");
					this.getCoverPhoto().setText("📷"); // Icono de cámara como placeholder
				}

				// Configurar imagen de perfil/avatar
				String fotoPerfilURL = u.getFotoPerfilURL();
				if (fotoPerfilURL != null && !fotoPerfilURL.trim().isEmpty() && 
					!fotoPerfilURL.equals("default-profile.jpg")) {
					// Configurar como imagen de perfil real
					this.getProfilePicture().getStyle()
						.set("background-image", "url('" + fotoPerfilURL + "')")
						.set("background-size", "cover")
						.set("background-position", "center")
						.set("background-repeat", "no-repeat")
						.set("border-radius", "50%"); // Hacer circular
					this.getProfilePicture().setText(""); // Quitar la "X" placeholder
				} else {
					// Usar avatar por defecto
					this.getProfilePicture().getStyle()
						.set("background-color", "#4CAF50")
						.set("border-radius", "50%");
					// Usar la primera letra del nickname como avatar
					String iniciales = u.getNickname() != null && u.getNickname().length() > 0 
						? u.getNickname().substring(0, 1).toUpperCase() 
						: "U";
					this.getProfilePicture().setText(iniciales);
				}

				System.out.println("✅ Imágenes de perfil configuradas:");
				System.out.println("   📷 Banner: " + (imagenFondoURL != null ? imagenFondoURL : "Por defecto"));
				System.out.println("   👤 Avatar: " + (fotoPerfilURL != null ? fotoPerfilURL : "Por defecto"));
			}
		} catch (Exception e) {
			System.err.println("Error configurando imágenes de perfil: " + e.getMessage());
			e.printStackTrace();
			// En caso de error, usar placeholders por defecto
			this.getCoverPhoto().setText("📷");
			this.getProfilePicture().setText("👤");
		}
	}
}