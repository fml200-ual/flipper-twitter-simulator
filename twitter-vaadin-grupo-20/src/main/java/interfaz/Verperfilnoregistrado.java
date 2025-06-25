package interfaz;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;

public class Verperfilnoregistrado extends Verperfil {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado;
	public Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado;
	public Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado;
	
	// Objeto ORMPersistable para el usuario cuyo perfil se muestra
	public basededatos.Usuario_Registrado u;

	public Verperfilnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado, basededatos.Usuario_Registrado u) {
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

		this.Agrupartweets();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado);
		});
		this.getFollowersCount().addClickListener(event -> Verlistaseguidoresnoregistrado());
		this.getFollowingCount().addClickListener(event -> Verlistaseguidosnoregistrado());
		this.getUserTweetsTab().addClickListener(event -> Agrupartweets());
		this.getRetweetsTab().addClickListener(event -> Agruparretweets());
		this.getLikedTweetsTab().addClickListener(event -> Agrupartweetsgustados());
	}
	
	// Constructor de compatibilidad temporal
	public Verperfilnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado) {
		this(_listafijadeusuariosnoregistrado, null);
	}	public void Verlistaseguidoresnoregistrado() {
		_verlistaseguidoresnoregistrado = new Verlistaseguidoresnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaseguidoresnoregistrado);
	}

	public void Verlistaseguidosnoregistrado() {
		_verlistaseguidosnoregistrado = new Verlistaseguidosnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaseguidosnoregistrado);
	}
	
	@Override
	public basededatos.Usuario_Registrado getUsuarioPerfil() {
		return u;
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
				}				// Calcular y mostrar contadores reales de seguidores y seguidos desde la base de datos
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
				
				System.out.println("Datos de perfil cargados para usuario no registrado viendo: " + u.getNickname());
			} else {
				System.err.println("Error: No se pudo acceder a los datos del usuario");
			}
		} catch (Exception e) {
			System.err.println("Error al cargar datos del perfil: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public Verperfilnoregistrado(Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado) {
		super();
		this._verlistaampliadadeusuariosnoregistrado = _verlistaampliadadeusuariosnoregistrado;

		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getEditAccountButton().setVisible(false);

		this.Agrupartweets();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadeusuariosnoregistrado);
		});
		this.getFollowersCount().addClickListener(event -> Verlistaseguidoresnoregistrado());
		this.getFollowingCount().addClickListener(event -> Verlistaseguidosnoregistrado());
		this.getUserTweetsTab().addClickListener(event -> Agrupartweets());
		this.getRetweetsTab().addClickListener(event -> Agruparretweets());
		this.getLikedTweetsTab().addClickListener(event -> Agrupartweetsgustados());
	}
	
	// Constructor temporal para navegación directa desde listas de usuarios
	public Verperfilnoregistrado(basededatos.Usuario_Registrado u) {
		super();
		this._listafijadeusuariosnoregistrado = null;
		this.u = u;
		
		if (u != null) {
			rellenarDatosPerfil();
		}
		
		this.getDeleteProfileButton().setVisible(false);
		this.getBanProfileButton().setVisible(false);
		this.getEditAccountButton().setVisible(false);

		this.Agrupartweets();

		this.getBackButton().addClickListener(event -> {
			if (Pantalla.Anterior != null) {
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(Pantalla.Anterior);
			}
		});
	}
	
	/**
	 * Método público para actualizar los contadores de seguidores y seguidos
	 * Se puede llamar para refrescar la UI
	 */
	public void actualizarContadores() {
		if (u != null) {
			try {
				BDPrincipal bd = new BDPrincipal();
				
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
				
				System.out.println("Contadores actualizados para perfil no registrado: " + u.getNickname());
			} catch (Exception e) {
				System.err.println("Error actualizando contadores: " + e.getMessage());
			}
		}
	}
}