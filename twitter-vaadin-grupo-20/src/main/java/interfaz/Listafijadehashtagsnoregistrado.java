package interfaz;

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
<<<<<<< HEAD
				// Agrupar hashtags por texto
				java.util.Map<String, java.util.List<Hashtag>> grouped = new java.util.TreeMap<>();
				for (Hashtag h : hashtags) {
					if (h != null && h.getHashtag() != null) {
						grouped.computeIfAbsent(h.getHashtag(), k -> new java.util.ArrayList<>()).add(h);
					}
				}
				// Limitar a los primeros 5 hashtags únicos
				int limite = Math.min(grouped.size(), 5);
				int count = 0;
				for (String text : grouped.keySet()) {
					if (count++ >= limite) break;
					java.util.List<Hashtag> group = grouped.get(text);
					// Obtener total de posts para este hashtag
					int totalPosts = 0;
					for (Hashtag h : group) {
						totalPosts += bd.contarTweetsHashtag(h.getORMID());
					}
					// Crear item usando el primer Hashtag del grupo
					Hashtag h0 = group.get(0);
					Listadehashtags_item item = new Listadehashtags_item(null, h0);
					// Actualizar contador de posts con total agrupado
					item.getPostCount().setText(totalPosts + " posts");
=======
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

>>>>>>> f181314abb8f924194337209199b7bceaa2730b5
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