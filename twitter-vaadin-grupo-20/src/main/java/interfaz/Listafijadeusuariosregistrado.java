package interfaz;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class Listafijadeusuariosregistrado extends Listafijadeusuarios {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verperfilregistrado _verperfilregistrado;
	public Perspectivabloqueado _perspectivabloqueado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;

	public Listafijadeusuariosregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		Listadeusuarios();
	}

	public void Listadeusuarios() {
		this.getMainContainer().as(VerticalLayout.class).removeAll();
		try {
			// Crear conexión a la base de datos para obtener usuarios reales
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado[] usuarios = bd.cargarUsuarios();
			basededatos.Usuario_Registrado[] bloqueados = MainView.obtenerUsuarioActual().meTienenBloqueado.toArray();

			// Filtrar para eliminar el usuario actual
			String usuarioActual = MainView.obtenerUsuarioActual().getNickname();
			usuarios = java.util.Arrays.stream(usuarios)
					.filter(u -> !u.getNickname().equals(usuarioActual))
					.toArray(basededatos.Usuario_Registrado[]::new);

			Listadeusuarios listaUsuarios = new Listadeusuarios(_verlistaampliadadeusuariosregistrado);

			// Si no hay usuarios, mostrar mensaje de error

			// Mostrar hasta 5 usuarios de la base de datos
			int maxUsuarios = Math.min(5, usuarios.length);
			for (int i = 0; i < maxUsuarios; i++) {
				basededatos.Usuario_Registrado usuario = usuarios[i];
				Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, usuario);

				// Agregar ClickListener personalizado para navegar al perfil con el usuario
				// correcto
				item.getMainContainer().addClickListener(event -> {
					boolean usuarioBloqueado = false;
					for (basededatos.Usuario_Registrado bloqueado : bloqueados) {
						if (bloqueado.getNickname().equals(usuario.getNickname())) {
							usuarioBloqueado = true;
							break;
						}
					}

					if (usuarioBloqueado) {
						Perspectivabloqueado();
					} else {
						Verperfilregistrado(usuario);
					}
				});
				listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);
			}
			this.getMainContainer().as(VerticalLayout.class).add(listaUsuarios);

		} catch (Exception e) {
			System.err.println("Error al cargar usuarios: " + e.getMessage());
			e.printStackTrace();

			this.getMainContainer().as(VerticalLayout.class)
					.add(new Span("No se pudieron cargar los usuarios. Por favor, inténtelo de nuevo más tarde."));
		}
	}

	public void Verperfilregistrado(basededatos.Usuario_Registrado usuario) {
		_verperfilregistrado = new Verperfilregistrado(this, usuario);
		mds2.MainView.Pantalla.MainView.removeAll();
		mds2.MainView.Pantalla.MainView.add(_verperfilregistrado);
	}

	public void Perspectivabloqueado() {
		_perspectivabloqueado = new Perspectivabloqueado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_perspectivabloqueado);
	}

	public void Verlistaampliadadeusuariosregistrado() {
		_verlistaampliadadeusuariosregistrado = new Verlistaampliadadeusuariosregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaampliadadeusuariosregistrado);
	}
}