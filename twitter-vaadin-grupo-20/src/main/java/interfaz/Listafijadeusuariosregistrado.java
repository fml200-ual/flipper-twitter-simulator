package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
		try {
			// Crear conexión a la base de datos para obtener usuarios reales
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Usuario_Registrado[] usuarios = bd.cargarUsuarios();
			
			Listadeusuarios listaUsuarios = new Listadeusuarios(_verlistaampliadadeusuariosregistrado);

			// Mostrar hasta 5 usuarios de la base de datos
			int maxUsuarios = Math.min(5, usuarios.length);
			for (int i = 0; i < maxUsuarios; i++) {
				basededatos.Usuario_Registrado usuario = usuarios[i];
				Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, usuario);
				
				// Agregar ClickListener personalizado para navegar al perfil con el usuario correcto
				item.getMainContainer().addClickListener(event -> {
					VerperfilregistradoConUsuario(usuario);
				});
				listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);
			}
			
			// Si no hay usuarios en la BD, mostrar items por defecto
			if (usuarios.length == 0) {
				for (int i = 0; i < 5; i++) {
					Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, null);
					item.getMainContainer().addClickListener(event -> {
						Verperfilregistrado();
					});
					listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);
				}
			}

			this.getMainContainer().as(VerticalLayout.class).add(listaUsuarios);
			
		} catch (Exception e) {
			System.err.println("Error al cargar usuarios: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: mostrar items por defecto
			Listadeusuarios listaUsuarios = new Listadeusuarios(_verlistaampliadadeusuariosregistrado);
			for (int i = 0; i < 5; i++) {
				Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios, null);
				item.getMainContainer().addClickListener(event -> {
					Verperfilregistrado();
				});
				listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);
			}
			this.getMainContainer().as(VerticalLayout.class).add(listaUsuarios);
		}
	}

	public void Verperfilregistrado() {
		_verperfilregistrado = new Verperfilregistrado(this);
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

	public void VerperfilregistradoConUsuario(basededatos.Usuario_Registrado usuario) {
		_verperfilregistrado = new Verperfilregistrado(this, usuario);
		mds2.MainView.Pantalla.MainView.removeAll();
		mds2.MainView.Pantalla.MainView.add(_verperfilregistrado);
	}
}