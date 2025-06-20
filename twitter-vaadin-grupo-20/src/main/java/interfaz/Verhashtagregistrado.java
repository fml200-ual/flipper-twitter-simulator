package interfaz;

import mds2.MainView.Pantalla;

public class Verhashtagregistrado extends Verhashtag {
	public Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado;
	public Listafijadehashtagsregistrado _listafijadehashtagsregistrado;
	public Listadetweetsyretweetsregistrado _listadetweetsyretweetsregistrado;
	public ACT02UsuarioRegistrado _usuarioRegistrado;

	public Verhashtagregistrado(Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado) {
		super();
		this._verlistaampliadadehashtagsregistrado = _verlistaampliadadehashtagsregistrado;
		// Ensamblado de componentes fijos
		Listadetweetsyretweetsregistrado();
		setupHashtagView();
	}

	public Verhashtagregistrado(Listafijadehashtagsregistrado _listafijadehashtagsregistrado) {
		super();
		this._listafijadehashtagsregistrado = _listafijadehashtagsregistrado;
		// Ensamblado de componentes fijos
		Listadetweetsyretweetsregistrado();
		setupHashtagView();
	}
	
	public Verhashtagregistrado(Verlistaampliadadehashtagsregistrado _verlistaampliadadehashtagsregistrado, ACT02UsuarioRegistrado usuarioRegistrado) {
		super();
		this._verlistaampliadadehashtagsregistrado = _verlistaampliadadehashtagsregistrado;
		this._usuarioRegistrado = usuarioRegistrado;
		// Ensamblado de componentes fijos
		Listadetweetsyretweetsregistrado();
		setupHashtagView();
	}
		private void setupHashtagView() {
		// Configurar vista de hashtag para usuario registrado
		
		// Configurar botón de volver - usar addAttachListener para asegurar que el botón esté disponible
		this.addAttachListener(e -> {
			if (this.getVolverButton() != null) {
				this.getVolverButton().addClickListener(event -> goBack());
			}
		});
	}
	
	private void goBack() {
		// Volver usando el patrón de navegación backend
		if (Pantalla.Anterior != null) {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(Pantalla.Anterior);
		}
	}

	public void Listadetweetsyretweetsregistrado() {
		throw new UnsupportedOperationException();
	}
}