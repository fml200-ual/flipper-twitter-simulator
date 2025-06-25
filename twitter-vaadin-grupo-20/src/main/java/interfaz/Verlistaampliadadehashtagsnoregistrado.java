package interfaz;

import java.util.Arrays;
import java.util.Comparator;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Hashtag;

public class Verlistaampliadadehashtagsnoregistrado extends Verlistaampliadadehashtags {
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Verlistaampliadadehashtagsnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;

		Listadehashtags();

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_listafijadehashtagsnoregistrado._aCT01UsuarioNoRegistrado);
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

				for (Hashtag hashtag : hashtags) {
					Listadehashtags_item item = new Listadehashtags_item(listaHashtags, hashtag);

					item.getHashtagContainer().addClickListener(event -> {
						System.out.println("Clic en hashtag: " + hashtag.getHashtag());
						Verhashtagnoregistrado(hashtag);
					});

					listaHashtags.getMainContainer().as(VerticalLayout.class).add(item);
				}

				this.getHashtagsListContainer().add(listaHashtags);
			}
		} catch (Exception e) {
			System.err.println("Error cargando hashtags ampliados: " + e.getMessage());
		}
	}

	public void Verhashtagnoregistrado(basededatos.Hashtag hashtag) {
		_verhashtagnoregistrado = new Verhashtagnoregistrado(this, hashtag);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verhashtagnoregistrado);
	}
}