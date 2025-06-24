package interfaz;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;

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
	
	// Constructor temporal para navegación directa desde listas de usuarios
	public Verperfilregistrado(basededatos.Usuario_Registrado u) {
		super();
		this._listafijadeusuariosregistrado = null; // Temporal: no tenemos referencia padre
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
			// Volver a la pantalla anterior guardada
			if (Pantalla.Anterior != null) {
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(Pantalla.Anterior);
			}
		});
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
		// Declaración del atributo IActor como en el patrón del diagrama de secuencia
		basededatos.BDPrincipal iactor = new basededatos.BDPrincipal();
		
		if (u == null) {
			System.err.println("No se puede realizar la operación de seguimiento: falta información del usuario a seguir");
			return;
		}
		
		try {
			// Obtener el usuario actual de forma segura
			mds2.MainView.Usuario.usuarioRegistrado = mds2.MainView.obtenerUsuarioActual();
			
			if (mds2.MainView.Usuario.usuarioRegistrado == null) {
				System.err.println("Error: No se pudo obtener el usuario actual");
				return;
			}
			
			if (this.getEditAccountButton().getText().equals("Seguir")) {
				// Seguir el patrón del diagrama: iactor.Subscribe(padre.logueado.getID(), usuario_visitado.getID())
				System.out.println("Realizando operación de seguimiento siguiendo patrón ORM...");
				
				iactor.seguir(
					mds2.MainView.Usuario.usuarioRegistrado.getId_usuario(), 
					u.getORMID(), 
					new java.util.Date()
				);
				
				// Seguir el patrón: actor = iactor.LoadUserById(padre.logueado.getID())
				basededatos.Usuario_Registrado usuarioActualizado = iactor.cargarUsuarioPorId(
					mds2.MainView.Usuario.usuarioRegistrado.getId_usuario()
				);
				
				if (usuarioActualizado != null) {
					// Actualizar el usuario en la sesión global
					mds2.MainView.Usuario.usuarioRegistrado = usuarioActualizado;
					
					// Actualizar la interfaz
					this.getEditAccountButton().setText("Dejar de seguir");
					System.out.println("Seguimiento realizado exitosamente");
				} else {
					System.err.println("Error al recargar el usuario después del seguimiento");
				}
				
			} else {
				// Implementar dejar de seguir siguiendo el mismo patrón
				System.out.println("Realizando operación de dejar de seguir siguiendo patrón ORM...");
				
				iactor.dejarDeSeguir(
					mds2.MainView.Usuario.usuarioRegistrado.getId_usuario(), 
					u.getORMID()
				);
				
				// Recargar el usuario actualizado
				basededatos.Usuario_Registrado usuarioActualizado = iactor.cargarUsuarioPorId(
					mds2.MainView.Usuario.usuarioRegistrado.getId_usuario()
				);
				
				if (usuarioActualizado != null) {
					// Actualizar el usuario en la sesión global
					mds2.MainView.Usuario.usuarioRegistrado = usuarioActualizado;
					
					// Actualizar la interfaz
					this.getEditAccountButton().setText("Seguir");
					System.out.println("Dejar de seguir realizado exitosamente");
				} else {
					System.err.println("Error al recargar el usuario después de dejar de seguir");
				}
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la operación de seguimiento: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Método público para actualizar los contadores de seguidores y seguidos
	 * Se puede llamar después de seguir/dejar de seguir para refrescar la UI
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
				
				System.out.println("Contadores actualizados para usuario: " + u.getNickname());
			} catch (Exception e) {
				System.err.println("Error actualizando contadores: " + e.getMessage());
			}
		}
	}

}