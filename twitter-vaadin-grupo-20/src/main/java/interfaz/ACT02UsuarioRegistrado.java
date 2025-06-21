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
				.addClickListener(event -> VerlistaAmpliadaDeUsuarios());

		this.getBotonMasHashtags()
				.addClickListener(event -> VerlistaAmpliadaDeUsuariosHashtags());

		this.getBotonCerrarSesionPrimerBoton()
				.addClickListener(event -> {
					this.Cerrarsesin();
				});
		this.getBotonEscribirTweet().addClickListener(event -> {
			Escribirtweet();
		});

	}

	public void Listadeusuariosregistrado() {
		_listafijadeusuariosregistrado = new Listafijadeusuariosregistrado(this);

		this.getVerticalLayoutListaUsuarios().as(VerticalLayout.class)
				.add(_listafijadeusuariosregistrado);
	}

	public void Listadehashtagsregistrado() {
		_listafijadehashtagsregistrado = new Listafijadehashtagsregistrado(this);

		this.getVerticalLayoutListaHashtagsSesionIniciada().as(VerticalLayout.class)
				.add(_listafijadehashtagsregistrado);
	}

	public void Verpropioperfil() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verpropioperfil = new Verpropioperfil(this));
	}

	public void Escribirtweet() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_escribirtweet = new Escribirtweet(this));
	}

	public void Vernotificaciones() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vernotificaciones = new Vernotificaciones(this));
	}

	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);

		// Ejemplo de item que es un tweet de otro usuario
		Listadetweetsyretweetsregistrado_item itemTweet = new Listadetweetsyretweetsregistrado_item(
				_listadetweetsyretweetsregistrado);
		_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class).add(itemTweet);

		// Ejemplo de item que es un retweet de otro usuario
		Listadetweetsyretweetsregistrado_item itemRetweet = new Listadetweetsyretweetsregistrado_item(
				_listadetweetsyretweetsregistrado);
		_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class).add(itemRetweet);

		this.getVerticalLayoutListaTweets().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsregistrado);
	}

	public void VerlistaAmpliadaDeUsuarios() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(new Verlistaampliadadeusuariosregistrado(_listafijadeusuariosregistrado));
	}

	public void VerlistaAmpliadaDeUsuariosHashtags() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(new Verlistaampliadadehashtagsregistrado(_listafijadehashtagsregistrado));
	}
}