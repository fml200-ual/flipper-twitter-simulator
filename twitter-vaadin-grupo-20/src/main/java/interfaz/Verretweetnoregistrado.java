package interfaz;

import mds2.MainView.Pantalla;

public class Verretweetnoregistrado extends TweetRetweetnoregistrado {
	private basededatos.Tweet tweet;

	// Constructor directo que acepta un Tweet que es un retweet
	public Verretweetnoregistrado(basededatos.Tweet tweet) {
		super(tweet);
		this.tweet = tweet;

		// Configurar elementos específicos para usuarios no registrados
		configurarElementosNoRegistrado();
		
		// Cargar datos del retweet
		cargarDatosRetweet();

		// Configurar lista de comentarios para usuarios no registrados
		this.Listadecomentariosnoregistrado();

		// Configurar navegación
		configurarNavegacion();
	}

	// Constructor legacy para compatibilidad (deprecado)
	@Deprecated
	public Verretweetnoregistrado(Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado) {
		super(null);
		this._listadetweetsyretweetsnoregistrado = _listadetweetsyretweetsnoregistrado;
		
		// Configurar elementos específicos para usuarios no registrados
		configurarElementosNoRegistrado();

		// Configurar lista de comentarios para usuarios no registrados
		this.Listadecomentariosnoregistrado();

		// Configurar navegación
		configurarNavegacion();
	}

	private void configurarElementosNoRegistrado() {
		// Los usuarios no registrados no pueden eliminar tweets
		if (this.getBotonEliminarTweet() != null) {
			this.getBotonEliminarTweet().setVisible(false);
		}
	}

	private void cargarDatosRetweet() {
		if (tweet == null) return;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// Si es un retweet, mostrar información del tweet original
			if (tweet.getTweet_retweeteado() != null) {
				basededatos.Tweet tweetOriginal = tweet.getTweet_retweeteado();
				
				// Configurar contenido del tweet original
				if (this.getTextoPublicacion() != null) {
					String contenido = tweetOriginal.getContenidoTweet() != null ? 
						tweetOriginal.getContenidoTweet() : "";
					this.getTextoPublicacion().setText(contenido);
				}

				// Configurar datos del usuario original
				if (tweetOriginal.getPublicado_por() != null) {
					if (this.getArrobaUsuario() != null) {
						this.getArrobaUsuario().setText("@" + tweetOriginal.getPublicado_por().getNickname());
					}
				}

				// Configurar fecha del tweet original
				if (tweetOriginal.getFechaPublicacion() != null && this.getFechaPublicacion() != null) {
					this.getFechaPublicacion().setText(tweetOriginal.getFechaPublicacion().toString());
				}

				// Configurar contadores del tweet original
				int likesCount = bd.contarLikesTweet(tweetOriginal.getORMID());
				int retweetsCount = bd.contarRetweetsTweet(tweetOriginal.getORMID());
				int comentariosCount = bd.contarComentariosTweet(tweetOriginal.getORMID());

				if (this.getNumMegusta() != null) {
					this.getNumMegusta().setText(String.valueOf(likesCount));
				}
				if (this.getNumeroRetweets() != null) {
					this.getNumeroRetweets().setText(String.valueOf(retweetsCount));
				}
				if (this.getNumeroRetweets1() != null) {
					this.getNumeroRetweets1().setText(String.valueOf(comentariosCount));
				}
			}

		} catch (Exception e) {
			System.err.println("Error cargando datos del retweet: " + e.getMessage());
			// Valores por defecto en caso de error
			if (this.getTextoPublicacion() != null) {
				this.getTextoPublicacion().setText("Error cargando retweet");
			}
		}
	}

	private void configurarNavegacion() {
		// Configurar botón volver para usuarios no registrados
		if (this.getBotonVolver() != null) {
			this.getBotonVolver().addClickListener(event -> {
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
			});
		}

		// Configurar navegación para usuarios no registrados (redirigir a login)
		configurarRedireccionLogin();
	}

	private void configurarRedireccionLogin() {
		// Los usuarios no registrados deben ir a login si intentan interactuar
		if (this.getIconoMeGusta() != null) {
			this.getIconoMeGusta().addClickListener(event -> redirigirALogin());
		}
		
		if (this.getIconoRetweet() != null) {
			this.getIconoRetweet().addClickListener(event -> redirigirALogin());
		}
		
		if (this.getIconoComentarios() != null) {
			this.getIconoComentarios().addClickListener(event -> redirigirALogin());
		}

		// Click en usuario también redirige a login
		if (this.getArrobaUsuario() != null) {
			this.getArrobaUsuario().addClickListener(event -> redirigirALogin());
		}
	}

	private void redirigirALogin() {
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
	}

	// Variable de compatibilidad para constructor legacy
	public Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado;
}