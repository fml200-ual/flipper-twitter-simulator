package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import mds2.MainView;

public class Verlistaampliadadeusuariosnoregistrado extends Verlistaampliadadeusuarios {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verperfilnoregistrado _verperfilnoregistrado;
	public ACT01UsuarioNoRegistrado _usuarioNoRegistrado;

	public Verlistaampliadadeusuariosnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado) {
		super();
		this._listafijadeusuariosnoregistrado = _listafijadeusuariosnoregistrado;
	}

	public Verlistaampliadadeusuariosnoregistrado(ACT01UsuarioNoRegistrado usuarioNoRegistrado) {
		super();
		this._usuarioNoRegistrado = usuarioNoRegistrado;
		// Ensamblado de componentes fijos
		Listadeusuarios();
	}

	public void Verperfilnoregistrado() {
		_verperfilnoregistrado = new Verperfilnoregistrado(_listafijadeusuariosnoregistrado);
		if (_usuarioNoRegistrado != null) {
			_usuarioNoRegistrado._mainView.removeAll();
			_usuarioNoRegistrado._mainView.add(_verperfilnoregistrado);
		}
	}

	public void Listadeusuarios() {
		Listadeusuarios listaUsuarios = new Listadeusuarios(this);
		this.getVaadinVerticalLayout().as(VerticalLayout.class).add(listaUsuarios);
	}
}