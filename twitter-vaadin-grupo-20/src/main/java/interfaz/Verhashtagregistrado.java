package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Verhashtagregistrado extends Verhashtag {
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;

	public Verhashtagregistrado(Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado) {
		super();
		this._verlistaampliadadehashtagsregistrado = _verlistaampliadadehashtagsregistrado;

		Listadetweetsyretweetsregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadehashtagsregistrado);
		});
	}

	public Verhashtagregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;

		Listadetweetsyretweetsregistrado();
		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsregistrado._aCT02UsuarioRegistrado);
		});
	}
		// Método para cargar tweets del hashtag específico
	public void cargarTweetsDeHashtag(basededatos.Hashtag hashtag) {
		this.h = hashtag;
		// Recargar la lista de tweets con los del hashtag específico usando agrupación
		if (_listadetweetsyretweetsregistrado != null) {
			_listadetweetsyretweetsregistrado.cargarTweetsDeHashtag(hashtag, true); // true = agrupar
		}
	}	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);

		// Cargar tweets del hashtag si ya está establecido
		if (h != null) {
			_listadetweetsyretweetsregistrado.cargarTweetsDeHashtag(h, true); // true = agrupar
		}

		this.getMainLayout().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsregistrado);
	}

}