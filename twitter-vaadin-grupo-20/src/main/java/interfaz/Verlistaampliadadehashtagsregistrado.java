package interfaz;

import mds2.MainView.Pantalla;

public class Verlistaampliadadehashtagsregistrado extends Verlistaampliadadehashtags {
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Verhashtagregistrado _verhashtagregistrado;
	public ACT02UsuarioRegistrado _usuarioRegistrado;

	public Verlistaampliadadehashtagsregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;
		// Configurar botón de retroceso
		setupBackButton();
		// Ensamblado de componentes fijos
		ListadehashtagsAmpliada();
	}
	
	public Verlistaampliadadehashtagsregistrado(ACT02UsuarioRegistrado usuarioRegistrado) {
		super();
		this._usuarioRegistrado = usuarioRegistrado;
		// Configurar botón de retroceso
		setupBackButton();
		// Ensamblado de componentes fijos
		ListadehashtagsAmpliada();
	}
	
	private void setupBackButton() {
		this.getBackButton().addClickListener(event -> goBack());
	}

	private void goBack() {
		// Volver usando el patrón de navegación backend
		if (Pantalla.Anterior != null) {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(Pantalla.Anterior);
		}
	}
	
	public void ListadehashtagsAmpliada() {
		// Crear lista ampliada de hashtags para usuario registrado
		Listadehashtags listaHashtags = new Listadehashtags(this);
		// Agregar items de hashtags con navegación
		listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadehashtags_item(listaHashtags, _usuarioRegistrado));
		listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadehashtags_item(listaHashtags, _usuarioRegistrado));
		listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadehashtags_item(listaHashtags, _usuarioRegistrado));
		// Agregar al contenedor de la vista
		this.getHashtagsListContainer().add(listaHashtags);
	}

	public void Verhashtagregistrado() {
		throw new UnsupportedOperationException();
	}
}