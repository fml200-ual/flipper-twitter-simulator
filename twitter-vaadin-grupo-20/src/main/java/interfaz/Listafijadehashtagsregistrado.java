package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listafijadehashtagsregistrado extends Listafijadehashtags {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;
	public Listadehashtags _listadehashtags; // Nuevo atributo para acceder a la lista

	public Listafijadehashtagsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		Listadehashtagsregistrado();
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
	public void Listadehashtagsregistrado() {
		try {
			// Crear conexión a la base de datos para obtener hashtags reales
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			basededatos.Hashtag[] hashtags = bd.cargarHashtags();
			
			// Crear lista de hashtags items
			_listadehashtags = new Listadehashtags(_verlistaampliadadehashtagsregistrado);
			
			// Mostrar hasta 5 hashtags de la base de datos
			int maxHashtags = Math.min(5, hashtags.length);
			for (int i = 0; i < maxHashtags; i++) {
				basededatos.Hashtag hashtag = hashtags[i];
				Listadehashtags_item item = new Listadehashtags_item(_listadehashtags, hashtag);
				
				// Agregar ClickListener personalizado para navegar al hashtag específico
				item.getHashtagContainer().addClickListener(event -> {
					VerhashtagregistradoConHashtag(hashtag);
				});
				_listadehashtags.getMainContainer().as(VerticalLayout.class).add(item);
			}
			
			// Si no hay hashtags en la BD, mostrar items por defecto
			if (hashtags.length == 0) {
				for (int i = 0; i < 5; i++) {
					Listadehashtags_item item = new Listadehashtags_item(_listadehashtags);
					item.getHashtagContainer().addClickListener(event -> {
						Verhashtagregistrado();
					});
					_listadehashtags.getMainContainer().as(VerticalLayout.class).add(item);
				}
			}
			
			this.getMainContainer().as(VerticalLayout.class).add(_listadehashtags);
			
		} catch (Exception e) {
			System.err.println("Error al cargar hashtags: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: mostrar items por defecto
			_listadehashtags = new Listadehashtags(_verlistaampliadadehashtagsregistrado);
			for (int i = 0; i < 5; i++) {
				Listadehashtags_item item = new Listadehashtags_item(_listadehashtags);
				item.getHashtagContainer().addClickListener(event -> {
					Verhashtagregistrado();
				});
				_listadehashtags.getMainContainer().as(VerticalLayout.class).add(item);
			}
			this.getMainContainer().as(VerticalLayout.class).add(_listadehashtags);
		}
	}
	
	public void VerhashtagregistradoConHashtag(basededatos.Hashtag hashtag) {
		// Método mejorado que puede recibir el hashtag específico
		if (hashtag != null) {
			System.out.println("Navegando al hashtag: " + hashtag.getHashtag());
		}
		
		// Por ahora mantener la funcionalidad original
		Verhashtagregistrado();
	}
}