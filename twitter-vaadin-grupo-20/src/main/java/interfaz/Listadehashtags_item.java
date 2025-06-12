package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaListadehashtags_item;

public class Listadehashtags_item extends VistaListadehashtags_item {
	// private event _mostrarmshashtags;
	public Listadehashtags _listadehashtags;

	public Listadehashtags_item(Listadehashtags _listadehashtags) {
		super();
		this._listadehashtags = _listadehashtags;

		this.getHashtagContainer().addClickListener(event -> {
			// Trigger the event to show hashtags
			System.out.println("Presinando");
			mostrarHashtag();
		});
	}

	private void mostrarHashtag() {
		Pantalla.MainView.removeAll();
		if (Pantalla.usuario == 2) {
			Pantalla.MainView.add(new Verhashtagregistrado((Listafijadehashtagsregistrado) null));
		} else {
			Pantalla.MainView.add(new Verhashtagnoregistrado((Listafijadehashtagsnoregistrado) null));
		}
	}

	public void Mostrarmshashtags() {
		throw new UnsupportedOperationException();
	}
}