package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Hashtag;

public class Listafijadehashtagsregistrado extends Listafijadehashtags {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;
	public Vector<Listadehashtags_item> _item = new Vector<Listadehashtags_item>();

	public Listafijadehashtagsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		// Cargar hashtags desde la base de datos
		BDPrincipal bd = new BDPrincipal();
		try {
			Hashtag[] hashtags = bd.cargarHashtags();
			if (hashtags != null && hashtags.length > 0) {
				// Agrupar hashtags únicos por texto y ordenar alfabéticamente
				java.util.Map<String, Hashtag> unico = new java.util.TreeMap<>();
				for (Hashtag h : hashtags) {
					if (h != null && h.getHashtag() != null) {
						unico.put(h.getHashtag(), h);
					}
				}
				java.util.List<Hashtag> listaUnica = new java.util.ArrayList<>(unico.values());
				// Limitar a los primeros 5 hashtags únicos
				int limite = Math.min(listaUnica.size(), 5);
				for (int i = 0; i < limite; i++) {
					Hashtag h = listaUnica.get(i);
					Listadehashtags_item item = new Listadehashtags_item(null, h);  // pasar null en lugar de this
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			}
		} catch (Exception e) {
			System.err.println("Error cargando hashtags: " + e.getMessage());
		}
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
}