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
				System.out.println("Cargando " + hashtags.length + " hashtags en lista scrolleable");
				
				// Ordenar hashtags alfabéticamente
				Arrays.sort(hashtags, Comparator.comparing(Hashtag::getHashtag));

				// Mostrar todos los hashtags (sin límite de 5) para scroll
				for (int i = 0; i < hashtags.length; i++) {
					basededatos.Hashtag hashtag = hashtags[i];
					Listadehashtags_item item = new Listadehashtags_item(null, hashtag);

					item.getHashtagContainer().addClickListener(event -> {
						Verhashtagnoregistrado(hashtag);
					});

					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}
				
				// Configurar el contenedor como scrolleable
				this.getMainContainer().getStyle()
					.set("height", "300px")  // Altura fija para permitir scroll (más pequeña que usuarios)
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