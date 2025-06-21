package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Verhashtagregistrado extends Verhashtag {
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	public ACT02UsuarioRegistrado _usuarioRegistrado;

	public Verhashtagregistrado(Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado) {
		super();
		this._verlistaampliadadehashtagsregistrado = _verlistaampliadadehashtagsregistrado;

		Listadetweetsyretweetsregistrado();
		this.addBackButton();
	}

	public Verhashtagregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;

		Listadetweetsyretweetsregistrado();
		this.addBackButton();
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