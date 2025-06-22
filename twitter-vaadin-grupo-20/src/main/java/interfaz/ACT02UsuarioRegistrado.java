package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class ACT02UsuarioRegistrado extends ACT06SesinIniciada {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verpropioperfil _verpropioperfil;
	public Escribirtweet _escribirtweet;
	public Vernotificaciones _vernotificaciones;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	public basededatos.Usuario_Registrado _usuarioRegistrado;

	public ACT02UsuarioRegistrado(MainView mainView) {
		super(mainView);

		this.getSpanListaTweetsRecientes().setVisible(false);

		Listafijadeusuariosregistrado();
		Listafijadehashtagsregistrado();
		Listadetweetsyretweetsregistrado();

		this.getBotonPerfilPropioRegistrado()
				.addClickListener(event -> Verpropioperfil());
		this.getBotonEscribirTweet()
				.addClickListener(event -> Escribirtweet());
		this.getBotonNotificacionesRegistrado()
				.addClickListener(event -> Vernotificaciones());
		this.getBotonMasUsuarios()
				.addClickListener(event -> _listafijadeusuariosregistrado.Verlistaampliadadeusuariosregistrado());
		this.getBotonMasHashtags()
				.addClickListener(event -> _listafijadehashtagsregistrado.Verlistaampliadadehashtagsregistrado());
		this.getBotonCerrarSesionPrimerBoton().addClickListener(event -> {
			this.Cerrarsesin();
		});
		this.getBotonEscribirTweet().addClickListener(event -> {
			Escribirtweet();
		});

	}

	public void Listafijadeusuariosregistrado() {
		_listafijadeusuariosregistrado = new Listafijadeusuariosregistrado(this);
		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class)
				.add(_listafijadeusuariosregistrado);
	}

	public void Listafijadehashtagsregistrado() {
		_listafijadehashtagsregistrado = new Listafijadehashtagsregistrado(this);
		this.getVerticalLayoutListaHashtagsSesionIniciada().as(VerticalLayout.class)
				.add(_listafijadehashtagsregistrado);
	}

	public void Verpropioperfil() {
		_verpropioperfil = new Verpropioperfil(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verpropioperfil);
	}

	public void Escribirtweet() {
		_escribirtweet = new Escribirtweet(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_escribirtweet);
	}

	public void Vernotificaciones() {
		_vernotificaciones = new Vernotificaciones(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vernotificaciones);
	}

	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);

		for (int i = 0; i < 5; i++) {
			Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
					_listadetweetsyretweetsregistrado);
			_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class).add(item);
		}

		this.getVerticalLayoutListaTweets().as(VerticalLayout.class).add(_listadetweetsyretweetsregistrado);
	}
}