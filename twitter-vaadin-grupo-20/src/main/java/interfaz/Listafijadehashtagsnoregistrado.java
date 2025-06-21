package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listafijadehashtagsnoregistrado extends Listafijadehashtags {
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Verhashtagnoregistrado _verhashtagnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
	public Listadehashtags _listadehashtags; // Nuevo atributo para acceder a la lista

	public Listafijadehashtagsnoregistrado(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		// Ensamblado de componentes fijos
		ListadehashtagsNR();
		// Ensamblado dinámico - ClickListeners
	}

	public void ListadehashtagsNR() {
		// Crear lista de hashtags items
		_listadehashtags = new Listadehashtags(_verlistaampliadadehashtagsnoregistrado);
		for (int i = 0; i < 5; i++) {
			Listadehashtags_item item = new Listadehashtags_item(_listadehashtags);
			// Agregar ClickListener personalizado para navegar a Verhashtagnoregistrado
			item.getHashtagContainer().addClickListener(event -> {
				Verhashtagnoregistrado();
			});
			_listadehashtags.getMainContainer().as(VerticalLayout.class).add(item);
		}
		this.getMainContainer().as(VerticalLayout.class).add(_listadehashtags);
	}

	public void Verhashtagnoregistrado() {
		_verhashtagnoregistrado = new Verhashtagnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verhashtagnoregistrado);
	}

	public void Verlistaampliadadehashtagsnoregistrado() {
		_verlistaampliadadehashtagsnoregistrado = new Verlistaampliadadehashtagsnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaampliadadehashtagsnoregistrado);
	}
}