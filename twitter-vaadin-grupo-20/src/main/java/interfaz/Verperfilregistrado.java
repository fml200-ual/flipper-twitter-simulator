package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;

public class Verperfilregistrado extends Verperfil {
	// private event _bloquearusuario;
	// private event _desbloquearusuario;
	// private event _seguirusuario;
	// private event _dejardeseguirusuario;
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;
	public Verlistadeseguidosregistrado _verlistadeseguidosregistrado;
	public Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado;

	// Objeto ORMPersistable para el usuario cuyo perfil se muestra
	public basededatos.Usuario_Registrado u;

	@Override
	public basededatos.Usuario_Registrado getUsuarioPerfil() {
		return this.u;
	}

	public Verperfilregistrado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;
		this.u = u;

		System.out.println("=== Verperfilregistrado constructor 1 inicializado ===");
		System.out.println("Usuario del perfil: " + (u != null ? u.toString() : "NULL"));

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.getDeleteProfileButton().setVisible(false);

		// Establecer el estado inicial del botón de bloquear/desbloquear
		establecerEstadoInicialBotones();

		// Texto por defecto para seguir (se actualiza en
		// establecerEstadoInicialBotones)
		this.getEditAccountButton().setText("Seguir");

		System.out.println("=== A punto de llamar Agrupartweets() ===");
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
			System.out.println("=== CLICK en LikedTweetsTab detectado en Verperfilregistrado constructor 1 ===");
			this.Agrupartweetsgustados();
		});
		this.getRetweetsTab().addClickListener(event -> {
			System.out.println("=== CLICK en RetweetsTab detectado en Verperfilregistrado constructor 1 ===");
			this.Agruparretweets();
		});
		this.getUserTweetsTab().addClickListener(event -> {
			System.out.println("=== CLICK en UserTweetsTab detectado en Verperfilregistrado constructor 1 ===");
			this.Agrupartweets();
		});
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosregistrado._aCT02UsuarioRegistrado);
		});
	}

	public Verperfilregistrado(Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado,
			basededatos.Usuario_Registrado u) {
		super();
		this._verlistaampliadadeusuariosregistrado = _verlistaampliadadeusuariosregistrado;
		this.u = u;

		System.out.println("=== Verperfilregistrado constructor 2 inicializado ===");
		System.out.println("Usuario del perfil: " + (u != null ? u.toString() : "NULL"));

		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

		this.getDeleteProfileButton().setVisible(false);

		// Establecer el estado inicial del botón de bloquear/desbloquear
		establecerEstadoInicialBotones();

		// Texto por defecto para seguir (se actualiza en
		// establecerEstadoInicialBotones)
		this.getEditAccountButton().setText("Seguir");

		System.out.println("=== A punto de llamar Agrupartweets() ===");
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
			System.out.println("=== CLICK en LikedTweetsTab detectado en Verperfilregistrado constructor 2 ===");
			this.Agrupartweetsgustados();
		});
		this.getRetweetsTab().addClickListener(event -> {
			System.out.println("=== CLICK en RetweetsTab detectado en Verperfilregistrado constructor 2 ===");
			this.Agruparretweets();
		});
		this.getUserTweetsTab().addClickListener(event -> {
			System.out.println("=== CLICK en UserTweetsTab detectado en Verperfilregistrado constructor 2 ===");
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

		// Establecer el estado inicial del botón de bloquear/desbloquear
		establecerEstadoInicialBotones();

		// Texto por defecto para seguir (se actualiza en
		// establecerEstadoInicialBotones)
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

	// Constructor de compatibilidad temporal para
	// Verlistaampliadadeusuariosregistrado
	public Verperfilregistrado(Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado) {
		this(_verlistaampliadadeusuariosregistrado, null);
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
		_verlistadeseguidosregistrado = new Verlistadeseguidosregistrado(this, u);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidosregistrado);
	}

	public void Verlistadeseguidoresregistrado() {
		_verlistadeseguidoresregistrado = new Verlistadeseguidoresregistrado(this, u);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidoresregistrado);
	}

	public void BloquearDesbloquearUsuario() {
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();

			if (usuarioActual == null || this.u == null) {
				System.err.println("Error: Usuario actual o usuario destino es null");
				return;
			}

			// Realizar la operación de bloqueo/desbloqueo

			if (this.getBanProfileButton().getText().equals("Bloquear")) {
				// Si estaba desbloqueado, ahora lo bloqueamos
				bd.bloquear(usuarioActual.getId_usuario(),
						this.u.getId_usuario());
				this.getBanProfileButton().setText("Desbloquear");
			} else {
				bd.desbloquear(usuarioActual.getId_usuario(), this.u.getId_usuario());
				this.getBanProfileButton().setText("Bloquear");
			}

		} catch (Exception e) {
			System.err.println("Error al bloquear/desbloquear usuario: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Seguirusuario() {
		try {
			// Obtener el usuario actual
			basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();
			if (usuarioActual == null) {
				System.err.println("No hay usuario autenticado");
				return;
			}

			// Usar BDPrincipal directamente para operaciones de seguimiento
			BDPrincipal bd = new BDPrincipal();

			// Verificar si el usuario actual está siguiendo al usuario del perfil
			boolean sigoAlUsuario = verificarSiEstaSiendoSeguido(usuarioActual, this.u);

			if (sigoAlUsuario) {
				// Dejar de seguir
				bd.quitarSeguimiento(usuarioActual.getId_usuario(), this.u.getId_usuario());

				// Actualizar texto del botón
				this.getEditAccountButton().setText("Seguir");

				System.out.println("Dejado de seguir a usuario: " + this.u.getNickname());
			} else {
				// Seguir usuario
				bd.seguir(usuarioActual.getId_usuario(), this.u.getId_usuario(), new java.util.Date());

				// Actualizar texto del botón
				this.getEditAccountButton().setText("Dejar de seguir");

				System.out.println("Siguiendo a usuario: " + this.u.getNickname());
			}

			// Actualizar contadores en la interfaz usando el método existente
			actualizarContadores();

		} catch (Exception e) {
			System.err.println("Error al seguir/dejar de seguir usuario: " + e.getMessage());
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

	/**
	 * Establece el estado inicial de los botones de bloquear/desbloquear y seguir
	 * basado en las relaciones ORM del usuario actual
	 */
	private void establecerEstadoInicialBotones() {
		if (u == null) {
			// Usuario no válido, usar valores por defecto
			this.getBanProfileButton().setText("Bloquear");
			this.getEditAccountButton().setText("Seguir");
			return;
		}

		try {
			// Obtener el usuario actual siguiendo el patrón ORM
			basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();
			if (usuarioActual == null) {
				// No hay usuario logueado, usar valores por defecto
				this.getBanProfileButton().setText("Bloquear");
				this.getEditAccountButton().setText("Seguir");
				return;
			}

			// Verificar si el usuario está bloqueado
			boolean estaBloqueado = verificarSiEstaBloqueado();
			this.getBanProfileButton().setText(estaBloqueado ? "Desbloquear" : "Bloquear");

			// Verificar si el usuario está siendo seguido
			boolean estaSiendoSeguido = verificarSiEstaSiendoSeguido(usuarioActual, u);
			this.getEditAccountButton().setText(estaSiendoSeguido ? "Dejar de seguir" : "Seguir");

			System.out.println("Estado inicial de botones establecido para usuario: " + u.getNickname() +
					" - Bloqueado: " + estaBloqueado + ", Seguido: " + estaSiendoSeguido);

		} catch (Exception e) {
			System.err.println("Error al establecer estado inicial de botones: " + e.getMessage());
			// En caso de error, usar valores por defecto
			this.getBanProfileButton().setText("Bloquear");
			this.getEditAccountButton().setText("Seguir");
		}
	}

	/**
	 * Verifica si un usuario está bloqueado por el usuario actual
	 * Consulta la BD directamente para obtener el estado actual
	 */
	private boolean verificarSiEstaBloqueado() {
		try {
			// Usar BDPrincipal para consultar directamente el estado de bloqueo
			BDPrincipal bd = new BDPrincipal();
			basededatos.Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();

			if (usuarioActual == null || this.u == null) {
				return false;
			}

			// Cargar el usuario actual actualizado desde la BD para asegurar que esté en
			// una sesión activa
			basededatos.Usuario_Registrado usuarioActualActualizado = bd
					.cargarUsuarioPorId(usuarioActual.getId_usuario());

			if (usuarioActualActualizado != null) {
				try {
					// Inicializar la colección lazy dentro de la sesión activa
					org.hibernate.Hibernate.initialize(usuarioActualActualizado.bloqueados);

					// Ahora podemos usar toArray() de forma segura
					basededatos.Usuario_Registrado[] bloqueados = usuarioActualActualizado.bloqueados.toArray();

					for (basededatos.Usuario_Registrado usuario : bloqueados) {
						if (this.u.getId_usuario() == usuario.getId_usuario()) {
							System.out.println("Usuario " + this.u.getNickname() + " está bloqueado por "
									+ usuarioActual.getNickname());
							return true;
						}
					}
				} catch (Exception e) {
					System.err.println("Error inicializando colección bloqueados: " + e.getMessage());
				}
			}

			System.out.println(
					"Usuario " + this.u.getNickname() + " NO está bloqueado por " + usuarioActual.getNickname());
			return false;
		} catch (Exception e) {
			System.err.println("Error verificando estado de bloqueo: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si un usuario está siendo seguido por el usuario actual
	 * Consulta la BD directamente para obtener el estado actual
	 */
	@SuppressWarnings("unchecked")
	private boolean verificarSiEstaSiendoSeguido(basededatos.Usuario_Registrado usuarioActual,
			basededatos.Usuario_Registrado usuarioDestino) {
		try {
			// Usar BDPrincipal para consultar directamente el estado de seguimiento
			BDPrincipal bd = new BDPrincipal();

			// Cargar el usuario actual actualizado desde la BD
			basededatos.Usuario_Registrado usuarioActualActualizado = bd
					.cargarUsuarioPorId(usuarioActual.getId_usuario());

			if (usuarioActualActualizado != null && usuarioActualActualizado.seguidosPropiedadesseguidoss != null) {
				// Acceder a la colección seguidosPropiedadesseguidoss del usuario actual
				for (java.util.Iterator<basededatos.PropiedadesSeguidos> iter = usuarioActualActualizado.seguidosPropiedadesseguidoss
						.getIterator(); iter.hasNext();) {
					basededatos.PropiedadesSeguidos seguimiento = iter.next();
					if (seguimiento.getSeguidosUsuario_registrado().getId_usuario() == usuarioDestino.getId_usuario()) {
						System.out.println("Usuario " + usuarioDestino.getNickname() + " está siendo seguido por "
								+ usuarioActual.getNickname());
						return true;
					}
				}
			}

			System.out.println("Usuario " + usuarioDestino.getNickname() + " NO está siendo seguido por "
					+ usuarioActual.getNickname());
			return false;
		} catch (Exception e) {
			System.err.println("Error verificando estado de seguimiento: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifica si el usuario actual está bloqueado por el usuario cuyo perfil se
	 * está viendo
	 * (caso inverso del bloqueo - alguien nos bloqueó a nosotros)
	 */
	@SuppressWarnings("unchecked")
	private boolean verificarSiEstoyBloqueadoPor(basededatos.Usuario_Registrado usuarioDestino,
			basededatos.Usuario_Registrado usuarioActual) {
		try {
			// Usar BDPrincipal para consultar directamente el estado de bloqueo
			BDPrincipal bd = new BDPrincipal();

			// Cargar el usuario destino actualizado desde la BD para ver si nos tiene
			// bloqueados
			basededatos.Usuario_Registrado usuarioDestinoActualizado = bd
					.cargarUsuarioPorId(usuarioDestino.getId_usuario());

			if (usuarioDestinoActualizado != null && usuarioDestinoActualizado.bloqueados != null) {
				// Verificar si el usuario actual está en la lista de bloqueados del usuario
				// destino
				for (java.util.Iterator<basededatos.Usuario_Registrado> iter = usuarioDestinoActualizado.bloqueados
						.getIterator(); iter.hasNext();) {
					basededatos.Usuario_Registrado bloqueado = iter.next();
					if (bloqueado.getId_usuario() == usuarioActual.getId_usuario()) {
						System.out.println("Usuario actual está bloqueado por " + usuarioDestino.getNickname());
						return true;
					}
				}
			}

			System.out.println("Usuario actual NO está bloqueado por " + usuarioDestino.getNickname());
			return false;
		} catch (Exception e) {
			System.err.println("Error verificando si estoy bloqueado: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Método para verificar si se debe mostrar la perspectiva de bloqueado
	 * en lugar del perfil normal
	 */
	public static boolean debeMostrarPerspectivaBloqueado(basededatos.Usuario_Registrado usuarioPerfil) {
		try {
			// Obtener el usuario actual
			basededatos.Usuario_Registrado usuarioActual = mds2.MainView.obtenerUsuarioActual();
			if (usuarioActual == null || usuarioPerfil == null) {
				return false;
			}

			// Crear una instancia temporal para usar el método de verificación
			Verperfilregistrado instanciaTemp = new Verperfilregistrado(usuarioPerfil);
			return instanciaTemp.verificarSiEstoyBloqueadoPor(usuarioPerfil, usuarioActual);

		} catch (Exception e) {
			System.err.println("Error verificando perspectiva de bloqueado: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Fuerza la recarga de los datos del perfil desde la base de datos
	 * Útil cuando se necesita actualizar la información después de cambios
	 */
	public void recargarDatosPerfil() {
		if (u != null) {
			rellenarDatosPerfil();
			establecerEstadoInicialBotones();
			System.out.println("Datos del perfil recargados para usuario: " + u.getNickname());
		} else {
			System.err.println("No se puede recargar: usuario es null");
		}
	}

	/**
	 * Fuerza la actualización solo de los contadores desde la base de datos
	 */
	public void forzarActualizacionContadores() {
		if (u != null) {
			try {
				BDPrincipal bd = new BDPrincipal();

				System.out.println("Actualizando contadores para usuario ID: " + u.getId_usuario());

				// Número de usuarios que sigue este usuario
				int siguiendo = bd.contarSeguidos(u.getId_usuario());
				this.getFollowingCount().setText(siguiendo + " siguiendo");
				System.out.println("Siguiendo: " + siguiendo);

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
				System.out.println("Seguidores: " + seguidores);

				System.out.println("Contadores forzados actualizados correctamente");
			} catch (Exception e) {
				System.err.println("Error forzando actualización de contadores: " + e.getMessage());
				e.printStackTrace();
				// En caso de error, mostrar valores por defecto
				this.getFollowingCount().setText("0 siguiendo");
				this.getFollowersCount().setText("0 seguidores");
			}
		} else {
			System.err.println("No se puede actualizar contadores: usuario es null");
		}
	}

}