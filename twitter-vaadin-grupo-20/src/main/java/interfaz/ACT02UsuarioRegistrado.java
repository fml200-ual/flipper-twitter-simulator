package interfaz;

import com.github.fge.jsonschema.main.cli.Main;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ACT02UsuarioRegistrado extends ACT06SesinIniciada {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verpropioperfil _verpropioperfil;
	public Escribirtweet _escribirtweet;
	public Vernotificaciones _vernotificaciones;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;

	public ACT02UsuarioRegistrado(MainView mainView) {
		super(mainView);
		this.getSpanListaTweetsRecientes().setVisible(false);
		Listadeusuariosregistrado();
		Listadehashtagsregistrado();
		Listadetweetsyretweetsregistrado();

		this.getBotonPerfilPropioRegistrado()
				.addClickListener(event -> Verpropioperfil());

		this.getBotonEscribirTweet()
				.addClickListener(event -> Escribirtweet());

		this.getBotonNotificacionesRegistrado()
				.addClickListener(event -> Vernotificaciones());

		this.getBotonMasUsuarios()
				.addClickListener(event -> Listafijadeusuariosregistrado());

		this.getBotonMasHashtags()
				.addClickListener(event -> Listafijadehashtagsregistrado());

		this.getBotonCerrarSesionPrimerBoton()
				.addClickListener(event -> {
					MainView.removeAll();
					MainView.add(new ACT01UsuarioNoRegistrado());
				});
	}

	public void Listadeusuariosregistrado() {
		// _listafijadeusuariosregistrado = new Listafijadeusuariosregistrado(this);

		Listadeusuarios listadeusuarios = new Listadeusuarios(
				(Verlistaampliadadeusuarios) null);
		listadeusuarios.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(listadeusuarios));
		listadeusuarios.getMainContainer().as(VerticalLayout.class)
				.add(new Listadeusuarios_item(listadeusuarios));
		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class)
				.add(listadeusuarios);
	}

	public void Listadehashtagsregistrado() {
		Listadehashtags listadehashtags = new Listadehashtags(
				(Verlistaampliadadehashtagsregistrado) null);

		this.getVerticalLayoutListaHashtagsSesionIniciada().as(VerticalLayout.class)
				.add(listadehashtags);
	}

	public void Verpropioperfil() {
		_verpropioperfil = new Verpropioperfil(this);
		MainView.removeAll();
		MainView.add(_verpropioperfil);
	}

	public void Escribirtweet() {
		_escribirtweet = new Escribirtweet(this);
		MainView.removeAll();
		MainView.add(_escribirtweet);
	}

	public void Vernotificaciones() {
		_vernotificaciones = new Vernotificaciones(this);
		MainView.removeAll();
		MainView.add(_vernotificaciones);
	}

	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);
		_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class)
				.add(new Listadetweetsyretweets_item(_listadetweetsyretweetsregistrado));
		_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class)
				.add(new Listadetweetsyretweets_item(_listadetweetsyretweetsregistrado));

		this.getVerticalLayoutListaTweets().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsregistrado);
	}

	public void Listafijadeusuariosregistrado() {
		_listafijadeusuariosregistrado = new Listafijadeusuariosregistrado(this);
		MainView.removeAll();
		MainView.add(_listafijadeusuariosregistrado);
	}

	public void Listafijadehashtagsregistrado() {
		_listafijadehashtagsregistrado = new Listafijadehashtagsregistrado(this);
		MainView.removeAll();
		MainView.add(_listafijadehashtagsregistrado);
	}
}