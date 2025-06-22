package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listafijadehashtagsregistrado extends Listafijadehashtags {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;
	public Listadehashtags _listadehashtags; // Nuevo atributo para acceder a la lista

	public Listafijadehashtagsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		Listadehashtagsregistrado();
	}

	public void Verlistaampliadadehashtagsregistrado() {
		_verlistaampliadadehashtagsregistrado = new Verlistaampliadadehashtagsregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaampliadadehashtagsregistrado);
	}

	public void Verhashtagregistrado() {
		_verhashtagregistrado = new Verhashtagregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verhashtagregistrado);
	}

	public void Listadehashtagsregistrado() {
		// Crear lista de hashtags items
		_listadehashtags = new Listadehashtags(_verlistaampliadadehashtagsregistrado);
		for (int i = 0; i < 5; i++) {
			Listadehashtags_item item = new Listadehashtags_item(_listadehashtags);
			// Agregar ClickListener personalizado para navegar a Verhashtagnoregistrado
			item.getHashtagContainer().addClickListener(event -> {
				Verhashtagregistrado();
			});
			_listadehashtags.getMainContainer().as(VerticalLayout.class).add(item);
		}
		this.getMainContainer().as(VerticalLayout.class).add(_listadehashtags);
	}
}