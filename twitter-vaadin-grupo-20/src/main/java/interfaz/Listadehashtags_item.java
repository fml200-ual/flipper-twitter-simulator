package interfaz;

import vistas.VistaListadehashtags_item;

public class Listadehashtags_item extends VistaListadehashtags_item{
	// private event _mostrarmshashtags;
	public Listadehashtags _listadehashtags;
	private ACT01UsuarioNoRegistrado _usuarioNoRegistrado; // Referencia directa
	private ACT02UsuarioRegistrado _usuarioRegistrado; // Referencia para usuario registrado

	public Listadehashtags_item(Listadehashtags _listadehashtags) {
		super();
		this._listadehashtags = _listadehashtags;
		
		// Ensamblado dinámico - Click en el hashtag para ver detalles
		setupHashtagClickListener();
	}
	
	// Constructor con referencia directa para usuario no registrado
	public Listadehashtags_item(Listadehashtags _listadehashtags, ACT01UsuarioNoRegistrado usuarioNoRegistrado) {
		super();
		this._listadehashtags = _listadehashtags;
		this._usuarioNoRegistrado = usuarioNoRegistrado;
		
		// Ensamblado dinámico - Click en el hashtag para ver detalles
		setupHashtagClickListener();
	}
	
	// Constructor con referencia directa para usuario registrado
	public Listadehashtags_item(Listadehashtags _listadehashtags, ACT02UsuarioRegistrado usuarioRegistrado) {
		super();
		this._listadehashtags = _listadehashtags;
		this._usuarioRegistrado = usuarioRegistrado;
		
		// Ensamblado dinámico - Click en el hashtag para ver detalles
		setupHashtagClickListener();
	}
	
	private void setupHashtagClickListener() {
		// Click en el contenedor del hashtag para ver detalles
		this.getHashtagContainer().addClickListener(event -> {
			verHashtag();
		});
	}
	
	private void verHashtag() {
		// Usar la referencia directa si está disponible para usuario no registrado
		if (_usuarioNoRegistrado != null) {
			// Crear vista ampliada de hashtags primero
			Verlistaampliadadehashtagsnoregistrado verListaAmpliada = new Verlistaampliadadehashtagsnoregistrado(_usuarioNoRegistrado);
			// Crear vista de hashtag usando el constructor correcto que incluye el usuario no registrado
			Verhashtagnoregistrado verHashtag = new Verhashtagnoregistrado(verListaAmpliada, _usuarioNoRegistrado);
			_usuarioNoRegistrado._mainView.removeAll();
			_usuarioNoRegistrado._mainView.add(verHashtag);
		}
		// Usar la referencia directa si está disponible para usuario registrado
		else if (_usuarioRegistrado != null) {
			// Crear vista ampliada de hashtags primero
			Verlistaampliadadehashtagsregistrado verListaAmpliada = new Verlistaampliadadehashtagsregistrado(_usuarioRegistrado);
			// Crear vista de hashtag para usuario registrado
			Verhashtagregistrado verHashtag = new Verhashtagregistrado(verListaAmpliada, _usuarioRegistrado);
			// Usar el patrón de navegación backend
			mds2.MainView.Pantalla.Anterior = mds2.MainView.Pantalla.MainView.getComponentAt(0);
			mds2.MainView.Pantalla.MainView.removeAll();
			mds2.MainView.Pantalla.MainView.add(verHashtag);
		}
	}


	public void Mostrarmshashtags() {
		verHashtag();
	}
}