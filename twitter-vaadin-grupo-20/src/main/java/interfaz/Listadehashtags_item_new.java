package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaListadehashtags_item;

public class Listadehashtags_item extends VistaListadehashtags_item {
	// private event _mostrarmshashtags;
	public Listadehashtags _listadehashtags;
	
	// Objeto ORMPersistable para el hashtag
	public basededatos.Hashtag h;

	public Listadehashtags_item(Listadehashtags _listadehashtags) {
		super();
		this._listadehashtags = _listadehashtags;
	}
	
	// Constructor que acepta Hashtag
	public Listadehashtags_item(Listadehashtags _listadehashtags, basededatos.Hashtag h) {
		super();
		this._listadehashtags = _listadehashtags;
		this.h = h;
		
		// Rellenar datos del hashtag en los componentes gráficos
		if (h != null) {
			rellenarDatosHashtag();
		}
	}
	
	private void rellenarDatosHashtag() {
		// Rellenar datos del hashtag en los componentes gráficos
		if (h.getHashtag() != null) {
			this.getHashtagText().setText("#" + h.getHashtag());
		}
		
		// Número de tweets que usan este hashtag
		this.getPostCount().setText("" + h.pertenece.size() + " posts");
		
		// Configurar click listener en el contenedor
		this.getHashtagContainer().addClickListener(event -> Mostrarmshashtags());
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
