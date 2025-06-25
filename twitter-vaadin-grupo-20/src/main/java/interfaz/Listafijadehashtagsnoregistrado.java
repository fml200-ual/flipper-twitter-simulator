package interfaz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Hashtag;

public class Listafijadehashtagsnoregistrado extends Listafijadehashtags {
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Verhashtagnoregistrado _verhashtagnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
	public Vector<Listadehashtags_item> _item = new Vector<Listadehashtags_item>();

	public Listafijadehashtagsnoregistrado(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;

		// Cargar hashtags desde la base de datos
		BDPrincipal bd = new BDPrincipal();
		try {
			Hashtag[] hashtags = bd.cargarHashtags();
			if (hashtags != null && hashtags.length > 0) {
				// Ordenar hashtags alfabéticamente
				Arrays.sort(hashtags, Comparator.comparing(Hashtag::getHashtag));

				// Limitar a los primeros 5 hashtags
				int limite = Math.min(hashtags.length, 5);
				for (int i = 0; i < limite; i++) {
					basededatos.Hashtag hashtag = hashtags[i];
					Listadehashtags_item item = new Listadehashtags_item(null, hashtag);

					item.getHashtagContainer().addClickListener(event -> {
						Verhashtagnoregistrado(hashtag);
					});

					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
			}
		} catch (Exception e) {
			System.err.println("Error cargando hashtags: " + e.getMessage());
		}
	}

	public void Verhashtagnoregistrado(basededatos.Hashtag hashtag) {
		_verhashtagnoregistrado = new Verhashtagnoregistrado(this, hashtag);
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