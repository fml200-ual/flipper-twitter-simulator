package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
		throw new UnsupportedOperationException();
	}

	public void Verhashtagregistrado() {
		
	}

	public void Listadehashtagsregistrado() {
		this._listadehashtags = new Listadehashtags(
				_verlistaampliadadehashtagsregistrado);

		this._listadehashtags.getMainContainer().as(VerticalLayout.class)
				.add(new Listadehashtags_item(this._listadehashtags));
		this._listadehashtags.getMainContainer().as(VerticalLayout.class)
				.add(new Listadehashtags_item(this._listadehashtags));

		this.getMainContainer().as(VerticalLayout.class)
				.add(this._listadehashtags);
	}
}