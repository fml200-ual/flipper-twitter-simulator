package interfaz;

import mds2.MainView.Pantalla;

public class Verperfiladministrador extends Verperfil {
	// private event _eliminarperfil;
	// private event _banearusuario;
	// private event _detallarlongitudbaneo;
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	public Verperfiladministrador(Vertweetadministrador _vertweetadministrador) {
		super();
		this._vertweetadministrador = _vertweetadministrador;
		this.getEditAccountButton().setVisible(false);

		this.Agrupartweets();
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_vertweetadministrador);
		});

		this.getDeleteProfileButton().addClickListener(event -> {
			Eliminarperfil();
		});
		this.getBanProfileButton().addClickListener(event -> {
			Banearusuario();
		});

		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets();
		});

		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados();
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets();
		});

	}

	public Verperfiladministrador(Verretweetadministrador _verretweetadministrador) {
		super();
		this._verretweetadministrador = _verretweetadministrador;
		this.getEditAccountButton().setVisible(false);

		this.Agrupartweets();
		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_vertweetadministrador);
		});

		this.getDeleteProfileButton().addClickListener(event -> {
			Eliminarperfil();
		});
		this.getBanProfileButton().addClickListener(event -> {
			Banearusuario();
		});

		this.getUserTweetsTab().addClickListener(event -> {
			this.Agrupartweets();
		});

		this.getLikedTweetsTab().addClickListener(event -> {
			this.Agrupartweetsgustados();
		});
		this.getRetweetsTab().addClickListener(event -> {
			this.Agruparretweets();
		});
	}

	public void Eliminarperfil() {
		System.out.println("Eliminar perfil");
	}

	public void Banearusuario() {
		System.out.println("Banear usuario");
	}

	public void Detallarlongitudbaneo() {
		throw new UnsupportedOperationException();
	}
}