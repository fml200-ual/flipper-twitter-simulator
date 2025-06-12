package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Listafijadehashtagsregistrado extends Listafijadehashtags {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;

	public Listafijadehashtagsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		Listadehashtagsregistrado();

	}

	public void Verlistaampliadadehashtagsregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Verhashtagregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Listadehashtagsregistrado() {
		Listadehashtags listadehashtags = new Listadehashtags((Verlistaampliadadehashtags) null);

		this.getHashtagsListContainer().as(VerticalLayout.class)
				.add(listadehashtags);

	}
}