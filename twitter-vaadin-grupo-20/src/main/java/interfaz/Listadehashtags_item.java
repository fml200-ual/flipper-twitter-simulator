package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaListadehashtags_item;

public class Listadehashtags_item extends VistaListadehashtags_item {
	// private event _mostrarmshashtags;
	public Listadehashtags _listadehashtags;

	public Listadehashtags_item(Listadehashtags _listadehashtags) {
		super();
		this._listadehashtags = _listadehashtags;
	}

	private void mostrarHashtag() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		if (Pantalla.usuario == 2) {
			Pantalla.MainView.add(new Verhashtagregistrado((Listafijadehashtagsregistrado) null));
		} else {
			Pantalla.MainView.add(new Verhashtagnoregistrado((Listafijadehashtagsnoregistrado) null));
		}
	}

	public void Mostrarmshashtags() {
		mostrarHashtag();
	}

}