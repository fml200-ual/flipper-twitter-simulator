package interfaz;

import mds2.MainView.Pantalla;

public class Verperfilnoregistrado extends Verperfil {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado;
	public Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado;
	public Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado;

	public Verperfilnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado) {
		super();
		this._listafijadeusuariosnoregistrado = _listafijadeusuariosnoregistrado;

		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getEditAccountButton().setVisible(false);

		this.Agrupartweets();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadeusuariosnoregistrado._aCT01UsuarioNoRegistrado);
		});
		this.getFollowersCount().addClickListener(event -> Verlistaseguidoresnoregistrado());
		this.getFollowingCount().addClickListener(event -> Verlistaseguidosnoregistrado());
		this.getUserTweetsTab().addClickListener(event -> Agrupartweets());
		this.getRetweetsTab().addClickListener(event -> Agruparretweets());
		this.getLikedTweetsTab().addClickListener(event -> Agrupartweetsgustados());
	}

	public Verperfilnoregistrado(Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado) {
		super();
		this._verlistaampliadadeusuariosnoregistrado = _verlistaampliadadeusuariosnoregistrado;

		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getEditAccountButton().setVisible(false);

		this.Agrupartweets();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadeusuariosnoregistrado);
		});
		this.getFollowersCount().addClickListener(event -> Verlistaseguidoresnoregistrado());
		this.getFollowingCount().addClickListener(event -> Verlistaseguidosnoregistrado());
		this.getUserTweetsTab().addClickListener(event -> Agrupartweets());
		this.getRetweetsTab().addClickListener(event -> Agruparretweets());
		this.getLikedTweetsTab().addClickListener(event -> Agrupartweetsgustados());
	}

	public void Verlistaseguidoresnoregistrado() {
		_verlistaseguidoresnoregistrado = new Verlistaseguidoresnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaseguidoresnoregistrado);
	}

	public void Verlistaseguidosnoregistrado() {
		_verlistaseguidosnoregistrado = new Verlistaseguidosnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaseguidosnoregistrado);
	}

}