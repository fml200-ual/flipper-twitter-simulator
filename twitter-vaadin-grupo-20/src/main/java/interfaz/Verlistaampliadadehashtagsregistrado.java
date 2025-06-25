package interfaz;

import java.util.Arrays;
import java.util.Comparator;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Hashtag;

public class Verlistaampliadadehashtagsregistrado extends Verlistaampliadadehashtags {
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;
	public ACT02UsuarioRegistrado _usuarioRegistrado;

	public Verlistaampliadadehashtagsregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;

		Listadehashtags();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsregistrado._aCT02UsuarioRegistrado);
		});
	}

	@Override
	public void Listadehashtags() {
		// Cargar hashtags desde la base de datos
		BDPrincipal bd = new BDPrincipal();
		try {
			Hashtag[] hashtags = bd.cargarHashtags();
			if (hashtags != null && hashtags.length > 0) {
				// Ordenar hashtags alfabéticamente
				Arrays.sort(hashtags, Comparator.comparing(Hashtag::getHashtag));

				// Crear lista ampliada de hashtags (mostrar todos los hashtags disponibles)
				Listadehashtags listaHashtags = new Listadehashtags(this);

				for (int i = 0; i < hashtags.length; i++) {
					Hashtag hashtag = hashtags[i];
					Listadehashtags_item item = new Listadehashtags_item(listaHashtags, hashtag);
					item.getHashtagContainer().addClickListener(event -> {
						Verhashtagregistrado(hashtag);
					});
					listaHashtags.getMainContainer().as(VerticalLayout.class).add(item);
				}

				this.getHashtagsListContainer().add(listaHashtags);
			}
		} catch (Exception e) {
			System.err.println("Error cargando hashtags ampliados: " + e.getMessage());
		}
	}

	public void Verhashtagregistrado(basededatos.Hashtag hashtag) {
		_verhashtagregistrado = new Verhashtagregistrado(this, hashtag);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verhashtagregistrado);
	}
}