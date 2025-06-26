package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class Verlistaampliadadeusuariosregistrado extends Verlistaampliadadeusuarios {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Perspectivabloqueado _perspectivabloqueado;
	public Verperfilregistrado _verperfilregistrado;

	public Verlistaampliadadeusuariosregistrado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;
		// Configurar botón de retroceso
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosregistrado._aCT02UsuarioRegistrado);
		});
		// Crear lista ampliada de usuarios
		Listadeusuarios();
	}

	@Override
	public void Listadeusuarios() {
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// Cargar usuarios con múltiples niveles de fallback
			basededatos.Usuario_Registrado[] usuarios;
			try {
				usuarios = bd.cargarUsuarios(); // Método original confiable
			} catch (Exception usuariosEx) {
				System.err.println(
						"Error cargando usuarios con método original, usando fallback: " + usuariosEx.getMessage());
				usuarios = bd.cargarUsuariosFallback();
			}

			basededatos.Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();

			// Obtener usuarios bloqueados de forma segura con fallback
			final basededatos.Usuario_Registrado[] bloqueados;
			if (usuarioActual != null) {
				basededatos.Usuario_Registrado[] tempBloqueados;
				try {
					// Intentar el método seguro primero
					tempBloqueados = bd.obtenerUsuariosBloqueados(usuarioActual);
					System.out.println("Usuarios bloqueados obtenidos: " + tempBloqueados.length);
				} catch (Exception bloqueadosEx) {
					System.err.println(
							"Error obteniendo usuarios bloqueados, usando método simple: " + bloqueadosEx.getMessage());
					// Si falla, usar el método simple
					tempBloqueados = bd.obtenerUsuariosBloqueadosSimple(usuarioActual);
				}
				bloqueados = tempBloqueados;
			} else {
				bloqueados = new basededatos.Usuario_Registrado[0];
			}

			// Verificar que usuarios no sea null
			if (usuarios == null) {
				usuarios = new basededatos.Usuario_Registrado[0];
				System.err.println("No se pudieron cargar usuarios desde la base de datos");
			}

			// Filtrar para eliminar el usuario actual
			String nickname = usuarioActual != null ? usuarioActual.getNickname() : "";
			usuarios = java.util.Arrays.stream(usuarios)
					.filter(u -> u != null && !u.getNickname().equals(nickname))
					.toArray(basededatos.Usuario_Registrado[]::new);

			// Crear lista ampliada de usuarios para usuario registrado
			Listadeusuarios listaUsuarios = new Listadeusuarios(this);

			for (basededatos.Usuario_Registrado usuario_Registrado : usuarios) {
				try {
					Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, usuario_Registrado);

					// Agregar el item a la lista inmediatamente
					listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);

					item.getMainContainer().addClickListener(event -> {
						boolean usuarioBloqueado = false;
						// Verificar si el usuario está bloqueado
						for (basededatos.Usuario_Registrado bloqueado : bloqueados) {
							if (bloqueado != null && bloqueado.getNickname().equals(usuario_Registrado.getNickname())) {
								usuarioBloqueado = true;
								break;
							}
						}

						if (usuarioBloqueado) {
							Perspectivabloqueado();
						} else {
							Verperfilregistrado(usuario_Registrado);
						}
					});
				} catch (Exception itemEx) {
					System.err.println("Error creando item para usuario " + usuario_Registrado.getNickname() + ": "
							+ itemEx.getMessage());
				}
			}

			this.getUsersContainer().add(listaUsuarios);
			System.out.println("Lista de usuarios ampliada cargada exitosamente con " + usuarios.length + " usuarios");

		} catch (Exception e) {
			System.err.println("Error en Listadeusuarios: " + e.getMessage());
			e.printStackTrace();

			// En caso de error, mostrar una lista vacía para evitar el crash
			try {
				Listadeusuarios listaUsuarios = new Listadeusuarios(this);
				this.getUsersContainer().add(listaUsuarios);
				System.out.println("Lista de usuarios vacía mostrada como fallback");
			} catch (Exception fallbackEx) {
				System.err.println("Error en fallback de Listadeusuarios: " + fallbackEx.getMessage());
			}
		}
	}

	public void Perspectivabloqueado() {
		_perspectivabloqueado = new Perspectivabloqueado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_perspectivabloqueado);
	}

	public void Verperfilregistrado(basededatos.Usuario_Registrado usuarioRegistrado) {
		_verperfilregistrado = new Verperfilregistrado(this, usuarioRegistrado);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfilregistrado);
	}
}