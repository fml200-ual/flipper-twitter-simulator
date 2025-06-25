package interfaz;

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
		basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
		basededatos.Usuario_Registrado[] usuarios = bd.cargarUsuarios();
		basededatos.Usuario_Registrado usuarioActual = MainView.obtenerUsuarioActual();
		basededatos.Usuario_Registrado[] bloqueados = usuarioActual.meTienenBloqueado.toArray();

		// Filtrar para eliminar el usuario actual
		String nickname = usuarioActual.getNickname();
		usuarios = java.util.Arrays.stream(usuarios)
				.filter(u -> !u.getNickname().equals(nickname))
				.toArray(basededatos.Usuario_Registrado[]::new);

		// Crear lista ampliada de usuarios para usuario no registrado
		Listadeusuarios listaUsuarios = new Listadeusuarios(this);

		for (basededatos.Usuario_Registrado usuario_Registrado : usuarios) {
			Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, usuario_Registrado);

			item.getMainContainer().addClickListener(event -> {
				boolean usuarioBloqueado = false;
				for (basededatos.Usuario_Registrado bloqueado : bloqueados) {
					if (bloqueado.getNickname().equals(usuario_Registrado.getNickname())) {
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
		}

		this.getUsersContainer().add(listaUsuarios);
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