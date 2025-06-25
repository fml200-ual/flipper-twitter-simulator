package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Verhashtagregistrado extends Verhashtag {
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	public basededatos.Hashtag _hashtag;

	public Verhashtagregistrado(Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado,
			basededatos.Hashtag hashtag) {
		super();
		this._verlistaampliadadehashtagsregistrado = _verlistaampliadadehashtagsregistrado;
		this._hashtag = hashtag;

		this.getH1().setText(hashtag.getHashtag());

		Listadetweetsyretweetsregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadehashtagsregistrado);
		});
	}

	public Verhashtagregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado,
			basededatos.Hashtag hashtag) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;
		this._hashtag = hashtag;

		this.getH1().setText(hashtag.getHashtag());

		Listadetweetsyretweetsregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsregistrado._aCT02UsuarioRegistrado);
		});
	}

	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);

		BDPrincipal bd = new BDPrincipal();
		Tweet[] tweets = bd.cargarTweetsDeHashtag(this._hashtag.getId_hashtag());

		for (Tweet tweet : tweets) {
			System.out.println("Tweet cargado: " + tweet.getContenidoTweet());
			Listadetweetsyretweetsregistrado_item item = new Listadetweetsyretweetsregistrado_item(
					_listadetweetsyretweetsregistrado, tweet);
			_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class).add(item);
		}

		this.getMainLayout().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsregistrado);
	}

}