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
		// Ensamblado estático de componentes fijos
		// setupStaticHashtagView();
		// Ensamblado dinámico de contenido
		Listadetweetsyretweetsnoregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsnoregistrado._aCT01UsuarioNoRegistrado);
		});

	}

	public Verhashtagnoregistrado(Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado) {
		super();
		this._verlistaampliadadehashtagsnoregistrado = _verlistaampliadadehashtagsnoregistrado;
		// Ensamblado estático de componentes fijos
		// setupStaticHashtagView();
		// Ensamblado dinámico de contenido
		Listadetweetsyretweetsnoregistrado();

		this.getVolverButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verlistaampliadadehashtagsnoregistrado);
		});
	}

	public void Listadetweetsyretweetsnoregistrado() {
		_listadetweetsyretweetsnoregistrado = new Listadetweetsyretweetsnoregistrado(this);

		for (int i = 0; i < 5; i++) {
			Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweets_item = new Listadetweetsyretweetsnoregistrado_item(
					_listadetweetsyretweetsnoregistrado);
			// Navegar a Vertweetnoregistrado o Verretweetnoregistrado
			_listadetweetsyretweets_item.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(new Vertweetnoregistrado(_listadetweetsyretweets_item));
			});
			_listadetweetsyretweetsnoregistrado
					.getMainContainer().as(VerticalLayout.class)
					.add(_listadetweetsyretweets_item);
		}

		this.getMainLayout().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsnoregistrado);
	}
}