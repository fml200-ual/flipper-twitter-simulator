package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import basededatos.BDPrincipal;
import basededatos.Hashtag;

public class Listafijadehashtagsnoregistrado extends Listafijadehashtags {
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Verhashtagnoregistrado _verhashtagnoregistrado;
	public Verlistaampliadadehashtagsnoregistrado _verlistaampliadadehashtagsnoregistrado;
	public Listadehashtags _listadehashtags; // Nuevo atributo para acceder a la lista

	public Listafijadehashtagsnoregistrado(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
		// Ensamblado de componentes fijos
		ListadehashtagsNR();
		// Ensamblado dinámico - ClickListeners
	}
	public void ListadehashtagsNR() {
		try {
			System.out.println("Cargando hashtags desde la base de datos...");
			
			// Crear instancia de la base de datos
			BDPrincipal bd = new BDPrincipal();
			
			// Cargar hashtags desde la base de datos
			Hashtag[] hashtagsArray = bd.cargarHashtags();
			
			if (hashtagsArray != null && hashtagsArray.length > 0) {
				System.out.println("Cargados " + hashtagsArray.length + " hashtags desde la BD");
				
				// Crear la lista container
				_listadehashtags = new Listadehashtags(_verlistaampliadadehashtagsnoregistrado);
				
				// Crear items de lista para cada hashtag cargado (limitado a los primeros 5)
				int limite = Math.min(hashtagsArray.length, 5);
				for (int i = 0; i < limite; i++) {
					Hashtag hashtag = hashtagsArray[i];
					if (hashtag != null) {
						// Crear item con el hashtag real de la base de datos
						Listadehashtags_item item = new Listadehashtags_item(_listadehashtags, hashtag);
						
						// Agregar ClickListener para navegar al hashtag específico
						item.getHashtagContainer().addClickListener(event -> {
							VerhashtagnoregistradoConHashtag(hashtag);
						});
						
						// Agregar el item al contenedor
						_listadehashtags.getMainContainer().as(VerticalLayout.class).add(item);
					}
				}
				
				this.getMainContainer().as(VerticalLayout.class).add(_listadehashtags);
			} else {
				System.out.println("No se encontraron hashtags en la base de datos");
				// Usar funcionalidad por defecto
				crearListaHashtagsPorDefecto();
			}
			
		} catch (Exception e) {
			System.err.println("Error al cargar hashtags desde la BD: " + e.getMessage());
			e.printStackTrace();
			
			// En caso de error, usar la funcionalidad original
			crearListaHashtagsPorDefecto();
		}
	}
	
	private void crearListaHashtagsPorDefecto() {
		// Crear lista de hashtags items (funcionalidad original)
		_listadehashtags = new Listadehashtags(_verlistaampliadadehashtagsnoregistrado);
		for (int i = 0; i < 5; i++) {
			Listadehashtags_item item = new Listadehashtags_item(_listadehashtags);
			// Agregar ClickListener personalizado para navegar a Verhashtagnoregistrado
			item.getHashtagContainer().addClickListener(event -> {
				Verhashtagnoregistrado();
			});
			_listadehashtags.getMainContainer().as(VerticalLayout.class).add(item);
		}
		this.getMainContainer().as(VerticalLayout.class).add(_listadehashtags);
	}
	
	private void VerhashtagnoregistradoConHashtag(Hashtag hashtag) {
		// Método mejorado que puede recibir el hashtag específico
		if (hashtag != null) {
			System.out.println("Navegando al hashtag: " + hashtag.getHashtag());
		}
		
		// Navegar a la vista de hashtag (por ahora mantener la funcionalidad original)
		Verhashtagnoregistrado();
	}

	public void Verhashtagnoregistrado() {
		_verhashtagnoregistrado = new Verhashtagnoregistrado(this);
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