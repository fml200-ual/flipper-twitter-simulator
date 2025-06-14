package interfaz;

import com.vaadin.flow.component.button.Button;

import mds2.MainView.Pantalla;

public class Verlistaampliadadehashtagsregistrado extends Verlistaampliadadehashtags {
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;

	public Verlistaampliadadehashtagsregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;
		addBackButton();

		// Agregar la lista de hashtags al contenedor
		if (this._listafijadehashtagsregistrado._listadehashtags != null) {
			this.getHashtagsListContainer()
					.add(this._listafijadehashtagsregistrado._listadehashtags);
		}

	}

	public void Verhashtagregistrado() {
		throw new UnsupportedOperationException();
	}

	protected void addBackButton() {
		Button backButton = new Button("← Volver", event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(Pantalla.Anterior);
		});
		this.getPageTitle().add(backButton);
	}

}