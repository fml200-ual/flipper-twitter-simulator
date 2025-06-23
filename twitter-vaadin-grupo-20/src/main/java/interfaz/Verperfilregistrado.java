package interfaz;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import java.util.Date;

public class Verperfilregistrado extends Verperfil {
	// private event _bloquearusuario;
	// private event _desbloquearusuario;
	// private event _seguirusuario;
	// private event _dejardeseguirusuario;
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;
	public Verlistadeseguidosregistrado _verlistadeseguidosregistrado;	public Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado;
	
	// Objeto ORMPersistable para el usuario cuyo perfil se muestra
	public basededatos.Usuario_Registrado u;

	public Verperfilregistrado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado, basededatos.Usuario_Registrado u) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;
		this.u = u;
		
		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}
		
		this.getDeleteProfileButton().setVisible(false);

		this.getBanProfileButton().setText("Bloquear");
		this.getEditAccountButton().setText("Seguir");

		this.Agrupartweets();

		this.getBanProfileButton().addClickListener(event -> {
			BloquearDesbloquearUsuario();
		});
		this.getEditAccountButton().addClickListener(event -> {
			Seguirusuario();
		});
		this.getFollowingCount().addClickListener(event -> {
			Verlistadeseguidosregistrado();
		});
		this.getFollowersCount().addClickListener(event -> {
			Verlistadeseguidoresregistrado();
		});
		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados();
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets();
		});
		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets();
		});
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosregistrado._aCT02UsuarioRegistrado);
		});
	}

	public Verperfilregistrado(Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado) {
		super();
		this._verlistaampliadadeusuariosregistrado = _verlistaampliadadeusuariosregistrado;
		this.getDeleteProfileButton().setVisible(false);

		this.getBanProfileButton().setText("Bloquear");
		this.getEditAccountButton().setText("Seguir");

		this.Agrupartweets();

		this.getBanProfileButton().addClickListener(event -> {
			BloquearDesbloquearUsuario();
		});
		this.getEditAccountButton().addClickListener(event -> {
			Seguirusuario();
		});
		this.getFollowingCount().addClickListener(event -> {
			Verlistadeseguidosregistrado();
		});
		this.getFollowersCount().addClickListener(event -> {
			Verlistadeseguidoresregistrado();
		});
		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados();
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets();
		});
		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets();
		});
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView
					.add(_verlistaampliadadeusuariosregistrado);
		});

	}
	
	// Constructor de compatibilidad temporal
	public Verperfilregistrado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado) {
		this(_listafijadeusuariosregistrado, null);
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
				}
						// Calcular y mostrar contadores reales de seguidores y seguidos desde la base de datos
				try {
					// Número de usuarios que sigue este usuario
					int siguiendo = u.seguidosPropiedadesseguidoss.size();
					this.getFollowingCount().setText(siguiendo + " siguiendo");
					
					// Número de usuarios que siguen a este usuario
					int seguidores = u.seguidoresPropiedadesseguidoss.size();
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
				
				System.out.println("Datos de perfil ajeno cargados para usuario: " + u.getNickname());
			} else {
				System.err.println("Error: No se pudo acceder a los datos del usuario");
			}
		} catch (Exception e) {
			System.err.println("Error al cargar datos del perfil: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Verlistadeseguidosregistrado() {
		_verlistadeseguidosregistrado = new Verlistadeseguidosregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidosregistrado);
	}

	public void Verlistadeseguidoresregistrado() {
		_verlistadeseguidoresregistrado = new Verlistadeseguidoresregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidoresregistrado);
	}

	public void BloquearDesbloquearUsuario() {
		switch (this.getBanProfileButton().getText()) {
			case "Bloquear":
				this.getBanProfileButton().setText("Desbloquear");
				break;

			case "Desbloquear":
				this.getBanProfileButton().setText("Bloquear");
				break;

			default:
				break;
		}
	}	public void Seguirusuario() {
		// Por ahora, sin un sistema de sesión completo, implementamos una versión simplificada
		if (u == null) {
			System.err.println("No se puede realizar la operación de seguimiento: falta información del usuario a seguir");
			return;
		}
		
		try {
			// TODO: Obtener el usuario actual desde la sesión/contexto
			// Por ahora simulamos que tenemos un usuario autenticado con ID=1
			int usuarioActualId = 1; // Esto debería venir de la sesión actual
			
			// Crear instancia de la base de datos
			BDPrincipal bd = new BDPrincipal();
			
			if (this.getEditAccountButton().getText().equals("Seguir")) {
				// Realizar operación de seguimiento
				System.out.println("Usuario ID " + usuarioActualId + " va a seguir a " + u.getNickname());
				
				basededatos.Usuario_Registrado usuarioActualizado = bd.seguir(
					usuarioActualId, 
					u.getORMID(), 
					new Date()
				);
				
				if (usuarioActualizado != null) {
					// Actualizar la interfaz
					this.getEditAccountButton().setText("Dejar de seguir");
					System.out.println("Seguimiento realizado exitosamente");
				} else {
					System.err.println("Error al realizar el seguimiento");
				}
				
			} else {
				// TODO: Implementar dejar de seguir cuando esté disponible en la BD
				System.out.println("Funcionalidad de dejar de seguir no implementada aún en la BD");
				this.getEditAccountButton().setText("Seguir");
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la operación de seguimiento: " + e.getMessage());
			e.printStackTrace();
		}
	}

}