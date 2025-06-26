package interfaz;

import mds2.MainView.Pantalla;

public class Verretweetpropio extends TweetRetweetpropio {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;
	public basededatos.Tweet r;

	public Verretweetpropio(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado,
			basededatos.Tweet r) {
		super(r);

		this.getBotonEliminarTweet().setVisible(false);

		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.r = r;

		configurarEventos();
		cargarDatosRetweet();
	}

	private void configurarEventos() {

		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT02UsuarioRegistrado(Pantalla.MainView, null));
		});
		this.getIconoRetweet().addClickListener(event -> {
			this.Darretweet();
		});
		this.getIconoComentarios().addClickListener(event -> {
			this.Escribircomentario();
		});
	}

	private void cargarDatosRetweet() {
		if (tweet == null)
			return;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// DATOS DEL RETWEET (quien retweeteó y cuándo)
			// Configurar datos del usuario que hizo el retweet
			if (tweet.getPublicado_por() != null) {
				if (this.getArrobaUsuario() != null) {
					this.getArrobaUsuario().setText("@" + tweet.getPublicado_por().getNickname());
				}
				if (this.getNombreUsuario() != null) {
					this.getNombreUsuario().setText(tweet.getPublicado_por().getNickname());
				}
			}

			// Configurar fecha del retweet
			if (tweet.getFechaPublicacion() != null && this.getFechaPublicacion() != null) {
				this.getFechaPublicacion().setText(tweet.getFechaPublicacion().toString());
			}

			// Configurar contenido del retweet (si tiene texto adicional)
			if (this.getTextoPublicacion() != null) {
				String contenidoRetweet = tweet.getContenidoTweet() != null ? tweet.getContenidoTweet() : "";
				this.getTextoPublicacion().setText(contenidoRetweet);
			}

			// DATOS DE LA PUBLICACIÓN CITADA (tweet original)
			basededatos.Tweet tweetOriginal = tweet.getTweet_retweeteado();
			if (tweetOriginal != null) {
				// Configurar layout de publicación citada
				if (this.getContenedorPublicacionCitada() != null) {
					this.getContenedorPublicacionCitada().setVisible(true);

					// Datos del usuario original en la sección citada
					if (tweetOriginal.getPublicado_por() != null) {
						if (this.getArrobaUsuarioCitado() != null) {
							this.getArrobaUsuarioCitado().setText("@" + tweetOriginal.getPublicado_por().getNickname());
						}
						if (this.getNombreUsuarioCitado() != null) {
							this.getNombreUsuarioCitado().setText(tweetOriginal.getPublicado_por().getNickname());
						}
					}

					// Contenido del tweet original citado
					if (this.getTextoPublicacionCitada() != null) {
						String contenidoOriginal = tweetOriginal.getContenidoTweet() != null
								? tweetOriginal.getContenidoTweet()
								: "";
						this.getTextoPublicacionCitada().setText(contenidoOriginal);
					}
				}
			}

			// Contadores del retweet (siempre se muestran)
			int likesCount = bd.contarLikesTweet(tweet.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(tweet.getORMID());
			int comentariosCount = bd.contarComentariosTweet(tweet.getORMID());

			if (this.getNumMegusta() != null) {
				this.getNumMegusta().setText(String.valueOf(likesCount));
			}
			if (this.getNumeroRetweets() != null) {
				this.getNumeroRetweets().setText(String.valueOf(retweetsCount));
			}
			if (this.getNumeroRetweets1() != null) {
				this.getNumeroRetweets1().setText(String.valueOf(comentariosCount));
			}

		} catch (Exception e) {
			System.err.println("Error cargando datos del retweet: " + e.getMessage());
			e.printStackTrace();
			// Valores por defecto en caso de error
			if (this.getTextoPublicacion() != null) {
				this.getTextoPublicacion().setText("Error cargando retweet");
			}
		}
	}
}