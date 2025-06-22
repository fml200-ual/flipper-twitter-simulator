package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Verhashtagnoregistrado extends Verhashtag {
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
	public Listadetweetsyretweetsnoregistrado _listadetweetsyretweetsnoregistrado;

	public Verhashtagnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;

		Listadetweetsyretweetsnoregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsnoregistrado._aCT01UsuarioNoRegistrado);
		});

	}

	public Verhashtagnoregistrado(Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado) {
		super();
		this._verlistaampliadadehashtagsnoregistrado = _verlistaampliadadehashtagsnoregistrado;

		Listadetweetsyretweetsnoregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadehashtagsnoregistrado);
		});
	}

	public void Listadetweetsyretweetsnoregistrado() {
		_listadetweetsyretweetsnoregistrado = new Listadetweetsyretweetsnoregistrado(this);

		for (int i = 0; i < 5; i++) {
			Listadetweetsyretweetsnoregistrado_item item = new Listadetweetsyretweetsnoregistrado_item(
					_listadetweetsyretweetsnoregistrado);
			_listadetweetsyretweetsnoregistrado
					.getMainContainer().as(VerticalLayout.class)
					.add(item);
		}

		this.getMainLayout().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsnoregistrado);
	}
}