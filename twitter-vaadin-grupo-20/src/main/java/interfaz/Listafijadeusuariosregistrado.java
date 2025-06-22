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
		Listadeusuarios listaUsuarios = new Listadeusuarios(_verlistaampliadadeusuariosregistrado);

		for (int i = 0; i < 5; i++) {
			Listadeusuarios_item item = new Listadeusuarios_item(listaUsuarios);
			// Agregar ClickListener personalizado para navegar a Verperfilnoregistrado
			item.getMainContainer().addClickListener(event -> {
				Verperfilregistrado();
			});
			listaUsuarios.getMainContainer().as(VerticalLayout.class).add(item);
		}

		this.getMainContainer().as(VerticalLayout.class).add(listaUsuarios);
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
}