package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Verhashtagregistrado extends Verhashtag {
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	public ACT02UsuarioRegistrado _usuarioRegistrado;

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

	public void Listadetweetsyretweetsregistrado() {
		_listadetweetsyretweetsregistrado = new Listadetweetsyretweetsregistrado(this);
		_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class)
				.add(new Listadetweetsyretweets_item(_listadetweetsyretweetsregistrado));
		_listadetweetsyretweetsregistrado.getMainContainer().as(VerticalLayout.class)
				.add(new Listadetweetsyretweets_item(_listadetweetsyretweetsregistrado));

		this.getMainLayout().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsregistrado);
	}

}