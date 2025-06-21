package interfaz;

import mds2.MainView.Pantalla;

public class Verperfilregistrado extends Verperfil {
	// private event _bloquearusuario;
	// private event _desbloquearusuario;
	// private event _seguirusuario;
	// private event _dejardeseguirusuario;
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;
	public Verlistadeseguidosregistrado _verlistadeseguidosregistrado;
	public Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado;

	public Verperfilregistrado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;
		this.getDeleteProfileButton().setVisible(false);
		this.getShowMoreButton().setVisible(false);

		this.getBanProfileButton().setText("Bloquear");
		this.getEditAccountButton().setText("Seguir");

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

		this.Agrupartweets();

		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados();
		});

		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets();
		});
		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets();
		});
	}

	public Verperfilregistrado(Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado) {
		super();
		this._verlistaampliadadeusuariosregistrado = _verlistaampliadadeusuariosregistrado;
		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setText("Bloquear");
		;
		this.getEditAccountButton().setVisible(false);
	}

	public void Verlistadeseguidosregistrado() {
		_verlistadeseguidosregistrado = new Verlistadeseguidosregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidosregistrado);
	}

	public void Verlistadeseguidoresregistrado() {
		_verlistadeseguidoresregistrado = new Verlistadeseguidoresregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidoresregistrado);
	}

	public void BloquearDesbloquearUsuario() {
		switch (this.getBanProfileButton().getText()) {
			case "Bloquear":
				this.getBanProfileButton().setText("Desbloquear");
				break;

			case "Desbloquear":
				this.getBanProfileButton().setText("Bloquear");
				break;

			default:
				break;
		}
	}

	public void Seguirusuario() {
		if (this.getEditAccountButton().getText().equals("Seguir")) {
			this.getEditAccountButton().setText("Dejar de seguir");
		} else {
			this.getEditAccountButton().setText("Seguir");
		}
	}

}