package interfaz;

public class Verlistaampliadadehashtagsnoregistrado extends Verlistaampliadadehashtags {
	public Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado;
	public Verhashtagnoregistrado _verhashtagnoregistrado;
	public ACT01UsuarioNoRegistrado _usuarioNoRegistrado;

	public Verlistaampliadadehashtagsnoregistrado(Listafijadehashtagsnoregistrado _listafijadehashtagsnoregistrado) {
		super();
		this._listafijadehashtagsnoregistrado = _listafijadehashtagsnoregistrado;
		// Ensamblado de componentes fijos
		ListadehashtagsAmpliada();
	}	public Verlistaampliadadehashtagsnoregistrado(ACT01UsuarioNoRegistrado usuarioNoRegistrado) {
		super();
		this._usuarioNoRegistrado = usuarioNoRegistrado;
		// Ensamblado de componentes fijos
		ListadehashtagsAmpliada();
		// Configurar botón de retroceso
		setupBackButton();
	}
	
	private void setupBackButton() {
		this.getBackButton().addClickListener(event -> goBack());
	}

	private void goBack() {
		// Volver a la vista completa de usuario no registrado
		_usuarioNoRegistrado._mainView.removeAll();
		_usuarioNoRegistrado._mainView.add(_usuarioNoRegistrado);
	}
	public void ListadehashtagsAmpliada() {
		// Crear lista ampliada de hashtags para usuario no registrado
		Listadehashtags listaHashtags = new Listadehashtags(this);
		// Agregar items de hashtags con navegación
		listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadehashtags_item(listaHashtags, _usuarioNoRegistrado));
		listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadehashtags_item(listaHashtags, _usuarioNoRegistrado));
		listaHashtags.getMainContainer().as(com.vaadin.flow.component.orderedlayout.VerticalLayout.class)
			.add(new Listadehashtags_item(listaHashtags, _usuarioNoRegistrado));
		// Agregar al contenedor de la vista
		this.getHashtagsListContainer().add(listaHashtags);
	}	public void Verhashtagnoregistrado() {
		_verhashtagnoregistrado = new Verhashtagnoregistrado(this, _usuarioNoRegistrado);
		// Navegación por MainView - tú arreglas el layout específico
		if (_usuarioNoRegistrado != null) {
			_usuarioNoRegistrado._mainView.removeAll();
			_usuarioNoRegistrado._mainView.add(_verhashtagnoregistrado);
		}
	}
}