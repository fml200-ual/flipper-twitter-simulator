package interfaz;

public class Verretweetnoregistrado extends TweetRetweetnoregistrado {
	public Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado;

	public Verretweetnoregistrado(Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado) {
		super();
		this._listadetweetsyretweetsnoregistrado = _listadetweetsyretweetsnoregistrado;
		// Ensamblado de componentes fijos para ver retweet
		setupRetweetView();
	}

	private void setupRetweetView() {
		// Configurar vista específica de retweet para usuario no registrado
		// Heredar configuración base de TweetRetweetnoregistrado
		// Mostrar información del retweet original
		hideRetweetActions();
	}

	private void hideRetweetActions() {
		// Ocultar acciones específicas de retweet que requieren login
		// Como retweetear, dar like al retweet, etc.
	}
}