package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Listafijadeusuariosregistrado extends Listafijadeusuarios {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verperfilregistrado _verperfilregistrado;
	public Perspectivabloqueado _perspectivabloqueado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;

	public Listafijadeusuariosregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		Verlistadeusuarios();
	}

	public void Verperfilregistrado() {
		_verperfilregistrado = new Verperfilregistrado(this);
		mds2.MainView.Pantalla.MainView.removeAll();
		mds2.MainView.Pantalla.MainView.add(_verperfilregistrado);
	}

	public void Perspectivabloqueado() {
		throw new UnsupportedOperationException();
	}

	public void Verlistaampliadadeusuariosregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Verlistadeusuarios() {
		Listadeusuarios listadeusuarios = new Listadeusuarios(
				_verlistaampliadadeusuariosregistrado);

		listadeusuarios.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(listadeusuarios));
		listadeusuarios.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(listadeusuarios));

		this.getMainContainer().as(VerticalLayout.class)
				.add(listadeusuarios);
	}
}