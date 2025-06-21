package interfaz;

public class Vercomentarionoregistrado extends Vercomentario {
	public Listadecomentariosnoregistrado_item _listadecomentariosnoregistrado;

	public Vercomentarionoregistrado(Listadecomentariosnoregistrado_item _listadecomentariosnoregistrado) {
		super();
		this._listadecomentariosnoregistrado = _listadecomentariosnoregistrado;
		// Ensamblado de componentes fijos para ver comentario
		setupComentarioView();
	}

	private void setupComentarioView() {
		// Configurar vista de comentario para usuario no registrado
		// Ocultar botones de acciones que requieren login
		hideRegisteredUserActions();
	}

	private void hideRegisteredUserActions() {
		// Ocultar botones que requieren estar registrado
		// Como responder, dar like, etc.
	}
}