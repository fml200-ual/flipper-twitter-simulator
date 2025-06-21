package interfaz;

import mds2.MainView.Pantalla;

public class Verpropioperfil extends Verperfil {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Editarcuenta _editarcuenta;
	public Verlistadeseguidoresregistrado _verlistadeseguidoresregistrado;
	public Verlistadeseguidosregistrado _verlistadeseguidosregistrado;

	public Verpropioperfil(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		this.getBanProfileButton().setVisible(false);
		this.getDeleteProfileButton().setVisible(false);
		this.getShowMoreButton().setVisible(false);
		this.getUserTweetsTab().setText("Mis tweets");
		this.getLikedTweetsTab().setText("Tweets que me gustan");

		this.Agrupartweets();

		this.getLikedTweetsTab().addClickListener(event -> {
			Agrupartweetsgustados();
		});

		this.getRetweetsTab().addClickListener(event -> {
			Agruparretweets();
		});
		this.getUserTweetsTab().addClickListener(event -> {
			Agrupartweets();
		});

		this.getFollowingCount().addClickListener(event -> {
			Verlistadeseguidosregistrado();
		});
		this.getFollowersCount().addClickListener(event -> {
			Verlistadeseguidoresregistrado();
		});
		this.getEditAccountButton().addClickListener(event -> {
			Editarcuenta();
		});

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT02UsuarioRegistrado);
		});

	}

	public void Editarcuenta() {
		_editarcuenta = new Editarcuenta(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_editarcuenta);
	}

	public void Verlistadeseguidoresregistrado() {
		_verlistadeseguidoresregistrado = new Verlistadeseguidoresregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidoresregistrado);
		_verlistadeseguidoresregistrado = new Verlistadeseguidoresregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidoresregistrado);
	}

	public void Verlistadeseguidosregistrado() {
		_verlistadeseguidosregistrado = new Verlistadeseguidosregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistadeseguidosregistrado);
	}
}