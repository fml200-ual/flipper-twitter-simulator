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
	}	// Método para cargar tweets del hashtag específico
	public void cargarTweetsDeHashtag(basededatos.Hashtag hashtag) {
		this.h = hashtag;
		
		// Actualizar el título con el hashtag real
		if (hashtag != null && hashtag.getHashtag() != null) {
			this.getH1().setText("#" + hashtag.getHashtag());
		}
		
		// Recargar la lista de tweets con los del hashtag específico usando agrupación
		if (_listadetweetsyretweetsnoregistrado != null) {
			_listadetweetsyretweetsnoregistrado.cargarTweetsDeHashtag(hashtag, true); // true = agrupar
		}
	}
	
	public void Listadetweetsyretweetsnoregistrado() {
		// Crear la lista - la inicialización automática carga los tweets de la BD
		_listadetweetsyretweetsnoregistrado = new Listadetweetsyretweetsnoregistrado(this);

		// Cargar tweets del hashtag si ya está establecido
		if (h != null) {
			_listadetweetsyretweetsnoregistrado.cargarTweetsDeHashtag(h, true); // true = agrupar
		}

		this.getMainLayout().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsnoregistrado);
	}
}