package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaListadehashtags_item;

public class Listadehashtags_item extends VistaListadehashtags_item {
	// private event _mostrarmshashtags;
	public Listadehashtags _listadehashtags;
	
	// Objeto ORMPersistable para el hashtag
	public basededatos.Hashtag h;	public Listadehashtags_item(Listadehashtags _listadehashtags) {
		super();
		this._listadehashtags = _listadehashtags;
		// Configurar datos vacíos por defecto
		this.getHashtagText().setText("");
		this.getPostCount().setText("");
	}
		// Constructor que acepta Hashtag
	public Listadehashtags_item(Listadehashtags _listadehashtags, basededatos.Hashtag h) {
		super();
		this._listadehashtags = _listadehashtags;
		this.h = h;
		
		// Rellenar datos del hashtag en los componentes gráficos
		if (h != null) {
			rellenarDatosHashtag();
		} else {
			// Si no hay hashtag, establecer valores vacíos
			this.getHashtagText().setText("");
			this.getPostCount().setText("");
		}
	}
	private void rellenarDatosHashtag() {
		// Rellenar datos del hashtag en los componentes gráficos
		if (h.getHashtag() != null) {
			String hashtag = h.getHashtag();
			// El hashtag en la base de datos ya incluye el #, solo mostrarlo una vez
			if (hashtag.startsWith("#")) {
				this.getHashtagText().setText(hashtag);
			} else {
				this.getHashtagText().setText("#" + hashtag);
			}
		}
		
		// Número de tweets que usan este hashtag
		try {
			int numTweets = h.pertenece != null ? h.pertenece.size() : 0;
			this.getPostCount().setText(numTweets + " posts");
		} catch (Exception e) {
			this.getPostCount().setText("0 posts");
		}
		
		// Configurar click listener en el contenedor
		this.getHashtagContainer().addClickListener(event -> Mostrarmshashtags());
	}	public void Mostrarmshashtags() {
		// Declaración del atributo IActor como en el patrón del diagrama de secuencia
		basededatos.BDPrincipal iactor = new basededatos.BDPrincipal();
		
		if (h != null) {
			System.out.println("Buscando tweets por hashtag siguiendo patrón ORM: " + h.getHashtag());
			
			try {
				// Seguir el patrón del diagrama: hashtags = iactor.Buscar(this.getHashtag().getText())
				basededatos.Hashtag[] hashtagsEncontrados = iactor.buscarHashtag(h.getHashtag());
				
				// Navegación siguiendo el patrón
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();
				
				if (Pantalla.usuario == 2) {
					// Usuario registrado - usar vista correspondiente
					Listafijadehashtagsregistrado lista = new Listafijadehashtagsregistrado(null);
					Verhashtagregistrado vista = new Verhashtagregistrado(lista);
					
					// Seguir el patrón: for cada hashtag encontrado, crear vista
					if (hashtagsEncontrados != null && hashtagsEncontrados.length > 0) {
						vista.cargarTweetsDeHashtag(hashtagsEncontrados[0]); // Usar el hashtag encontrado
					} else {
						vista.cargarTweetsDeHashtag(h); // Usar el hashtag original como fallback
					}
					
					Pantalla.MainView.add(vista);
				} else {
					// Usuario no registrado
					Listafijadehashtagsnoregistrado lista = new Listafijadehashtagsnoregistrado(null);
					Verhashtagnoregistrado vista = new Verhashtagnoregistrado(lista);
					
					if (hashtagsEncontrados != null && hashtagsEncontrados.length > 0) {
						vista.cargarTweetsDeHashtag(hashtagsEncontrados[0]);
					} else {
						vista.cargarTweetsDeHashtag(h);
					}
					
					Pantalla.MainView.add(vista);
				}
				
				System.out.println("Navegación exitosa a vista de hashtag");
				
			} catch (Exception e) {
				System.err.println("Error al buscar hashtag: " + e.getMessage());
				e.printStackTrace();
				// En caso de error, usar navegación simple
				mostrarHashtagSimple();
			}
		} else {
			System.err.println("No hay hashtag para mostrar");
		}
	}
	
	// Método auxiliar para navegación simple sin búsqueda ORM
	private void mostrarHashtagSimple() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		if (Pantalla.usuario == 2) {
			Listafijadehashtagsregistrado lista = new Listafijadehashtagsregistrado(null);
			Verhashtagregistrado vista = new Verhashtagregistrado(lista);
			vista.cargarTweetsDeHashtag(h);
			Pantalla.MainView.add(vista);
		} else {
			Listafijadehashtagsnoregistrado lista = new Listafijadehashtagsnoregistrado(null);
			Verhashtagnoregistrado vista = new Verhashtagnoregistrado(lista);
			vista.cargarTweetsDeHashtag(h);
			Pantalla.MainView.add(vista);
		}
	}
}
