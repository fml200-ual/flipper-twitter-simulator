package interfaz;

import mds2.MainView.Pantalla;

public class Verperfilnoregistrado extends Verperfil {
	public Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado;
	public Verlistaampliadadeusuariosnoregistrado _verlistaampliadadeusuariosnoregistrado;
	public Verlistaseguidoresnoregistrado _verlistaseguidoresnoregistrado;
	public Verlistaseguidosnoregistrado _verlistaseguidosnoregistrado;
	
	// Objeto ORMPersistable para el usuario cuyo perfil se muestra
	public basededatos.Usuario_Registrado u;

	public Verperfilnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado, basededatos.Usuario_Registrado u) {
		super();
		this._listafijadeusuariosnoregistrado = _listafijadeusuariosnoregistrado;
		this.u = u;
		
		// Rellenar datos del perfil con información del usuario
		if (u != null) {
			rellenarDatosPerfil();
		}

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
	
	// Constructor de compatibilidad temporal
	public Verperfilnoregistrado(Listafijadeusuariosnoregistrado _listafijadeusuariosnoregistrado) {
		this(_listafijadeusuariosnoregistrado, null);
	}
		private void rellenarDatosPerfil() {
		// TODO: Rellenar datos del usuario en la vista de perfil cuando los getters estén disponibles
		// if (u.getNickname() != null) {
		//     this.getUsernameSpan().setText("@" + u.getNickname());
		//     this.getDisplayNameSpan().setText(u.getNickname());
		// }
		// 
		// if (u.getBio() != null && !u.getBio().trim().isEmpty()) {
		//     this.getProfileDescriptionDiv().setText(u.getBio());
		// }
		// 
		// Actualizar contadores (requeriría consultas adicionales a la BD)
		// this.getFollowersCount().setText("" + u.getSeguido_por().size());
		// this.getFollowingCount().setText("" + u.getSigue_a().size());
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