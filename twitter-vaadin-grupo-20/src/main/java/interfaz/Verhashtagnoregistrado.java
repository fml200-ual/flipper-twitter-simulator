package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Hashtag;
import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Verhashtagnoregistrado extends Verhashtag {
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
	public Listadetweetsyretweetsnoregistrado _listadetweetsyretweetsnoregistrado;
	public basededatos.Hashtag _hashtag;

<<<<<<< HEAD

	public basededatos.Hashtag h;

	public Verhashtagnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado, basededatos.Hashtag hashtag) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;
		this.h = hashtag;
=======
	public Verhashtagnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado, Hashtag hashtag) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;
		this._hashtag = hashtag;

		this.getH1().setText("#" + hashtag.getHashtag());
>>>>>>> f181314abb8f924194337209199b7bceaa2730b5

		Listadetweetsyretweetsnoregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsnoregistrado._aCT01UsuarioNoRegistrado);
		});

	}

<<<<<<< HEAD
	public Verhashtagnoregistrado(Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado, basededatos.Hashtag hashtag) {
		super();
		this._verlistaampliadadehashtagsnoregistrado = _verlistaampliadadehashtagsnoregistrado;

		this.h = hashtag;
=======
	public Verhashtagnoregistrado(Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado,
			Hashtag hashtag) {
		super();
		this._verlistaampliadadehashtagsnoregistrado = _verlistaampliadadehashtagsnoregistrado;

		this.getH1().setText("#" + hashtag.getHashtag());
>>>>>>> f181314abb8f924194337209199b7bceaa2730b5

		Listadetweetsyretweetsnoregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadehashtagsnoregistrado);
		});
	}

	public void Listadetweetsyretweetsnoregistrado() {
		// Crear la lista - la inicialización automática carga los tweets de la BD
		_listadetweetsyretweetsnoregistrado = new Listadetweetsyretweetsnoregistrado(this);

		BDPrincipal bd = new BDPrincipal();
		Tweet[] tweets = bd.cargarTweetsDeHashtag(this._hashtag.getId_hashtag());

		for (Tweet tweet : tweets) {
			System.out.println("Tweet cargado: " + tweet.getContenidoTweet());
			Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
					_listadetweetsyretweetsnoregistrado, tweet);
			_listadetweetsyretweetsnoregistrado.getMainContainer().as(VerticalLayout.class).add(item);
		}
		this.getMainLayout().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsnoregistrado);
	}
}