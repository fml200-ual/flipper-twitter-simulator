package interfaz;

public class TweetRetweetnoregistrado extends TweetRetweet {
	public Listadecomentariosnoregistrado _listadecomentariosnoregistrado;
	
	public TweetRetweetnoregistrado() {
		// Ensamblado básico para tweet/retweet sin usuario
		setupTweetRetweetView();
	}

	public TweetRetweetnoregistrado(Listadecomentariosnoregistrado listadecomentariosnoregistrado) {
		super();
		this._listadecomentariosnoregistrado = listadecomentariosnoregistrado;
		// Ensamblado de componentes fijos
		Listadecomentariosnoregistrado();
		setupTweetRetweetView();
	}

	private void setupTweetRetweetView() {
		// Configurar vista de tweet/retweet para usuario no registrado
		// Ocultar botones de like, retweet, comentar que requieren login
		hideRegisteredUserActions();
	}

	private void hideRegisteredUserActions() {
		// Ocultar acciones que requieren estar registrado
	}

	public void Listadecomentariosnoregistrado() {
		_listadecomentariosnoregistrado = new Listadecomentariosnoregistrado(this);
		// Agregar lista de comentarios al layout cuando esté disponible
	}
}