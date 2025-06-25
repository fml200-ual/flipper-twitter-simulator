package interfaz;

import vistas.VistaPerspectivabloqueado;

public class Perspectivabloqueado extends VistaPerspectivabloqueado {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;
	public basededatos.Usuario_Registrado usuarioBloqueador; // El usuario que nos bloqueó

	public Perspectivabloqueado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;

		this.getBackButton().addClickListener(event -> {
			mds2.MainView.Pantalla.MainView.removeAll();
			mds2.MainView.Pantalla.MainView.add(_listafijadeusuariosregistrado._aCT02UsuarioRegistrado);
		});
	}

	public Perspectivabloqueado(Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado) {
		super();
		this._verlistaampliadadeusuariosregistrado = _verlistaampliadadeusuariosregistrado;

		this.getBackButton().addClickListener(event -> {
			mds2.MainView.Pantalla.MainView.removeAll();
			mds2.MainView.Pantalla.MainView.add(_verlistaampliadadeusuariosregistrado);
		});
	}

}