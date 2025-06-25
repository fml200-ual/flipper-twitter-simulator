package interfaz;

import java.util.Vector;

import java.util.Arrays;
import java.util.Comparator;

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
				System.out.println("Cargando " + hashtags.length + " hashtags en lista scrolleable (registrado)");
				
				// Ordenar hashtags alfabéticamente
				Arrays.sort(hashtags, Comparator.comparing(Hashtag::getHashtag));

				// Mostrar todos los hashtags (sin límite de 5) para scroll
				for (int i = 0; i < hashtags.length; i++) {
					basededatos.Hashtag hashtag = hashtags[i];
					Listadehashtags_item item = new Listadehashtags_item(null, hashtag);
					item.getHashtagContainer().addClickListener(event -> {
						Verhashtagregistrado(hashtag);
					});
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
				
				// Configurar el contenedor como scrolleable
				this.getMainContainer().getStyle()
					.set("height", "300px")  // Altura fija para permitir scroll
					.set("overflow-y", "auto")  // Scroll vertical
					.set("overflow-x", "hidden")  // Sin scroll horizontal
					.set("padding", "5px")
					.set("gap", "3px");  // Gap más pequeño para hashtags
				
				System.out.println("Lista fija de hashtags configurada como scrolleable con " + hashtags.length + " hashtags");
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

	public void Verhashtagregistrado(basededatos.Hashtag hashtag) {
		_verhashtagregistrado = new Verhashtagregistrado(this, hashtag);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verhashtagregistrado);
	}
}