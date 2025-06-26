package interfaz;

import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Verretweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;
	public basededatos.Tweet _tweet;

	public Verretweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador,
			Tweet tweet) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;
		this._tweet = tweet;

		volver();
		this.Listadecomentariosadministrador(_tweet);
		cargarDatosRetweet();

		this.getAvatarDivPrincipal().addClickListener(event -> {
			Verperfiladministrador();
		});
		this.getBotonEliminarTweet().addClickListener(event -> {
			this.Eliminarpublicacin(_tweet);
		});
	}

	private void cargarDatosRetweet() {
		if (_tweet == null)
			return;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// DATOS DEL RETWEET (quien retweeteó y cuándo)
			// Configurar datos del usuario que hizo el retweet
			if (_tweet.getPublicado_por() != null) {
				if (this.getSpanHandleUsuario() != null) {
					this.getSpanHandleUsuario().setText("@" + _tweet.getPublicado_por().getNickname());
				}
				if (this.getSpanNombreUsuario() != null) {
					this.getSpanNombreUsuario().setText(_tweet.getPublicado_por().getNickname());
				}
			}

			// Configurar fecha del retweet
			if (_tweet.getFechaPublicacion() != null && this.getSpanFecha() != null) {
				this.getSpanFecha().setText(_tweet.getFechaPublicacion().toString());
			}

			// Configurar contenido del retweet (si tiene texto adicional)
			if (this.getPTextoPublicacion() != null) {
				String contenidoRetweet = _tweet.getContenidoTweet() != null ? _tweet.getContenidoTweet() : "";
				this.getPTextoPublicacion().setText(contenidoRetweet);
			}

			// DATOS DE LA PUBLICACIÓN CITADA (tweet original)
			basededatos.Tweet tweetOriginal = _tweet.getTweet_retweeteado();
			if (tweetOriginal != null) {
				// Configurar layout de publicación citada
				if (this.getLayoutPublicacionCitada() != null) {
					this.getLayoutPublicacionCitada().setVisible(true);

					// Datos del usuario original en la sección citada
					if (tweetOriginal.getPublicado_por() != null) {
						if (this.getSpanHandleUsuarioCitado() != null) {
							this.getSpanHandleUsuarioCitado()
									.setText("@" + tweetOriginal.getPublicado_por().getNickname());
						}
						if (this.getSpanNombreUsuarioCitado() != null) {
							this.getSpanNombreUsuarioCitado().setText(tweetOriginal.getPublicado_por().getNickname());
						}
					}

					// Contenido del tweet original citado
					if (this.getPTextoPublicacionCitada() != null) {
						String contenidoOriginal = tweetOriginal.getContenidoTweet() != null
								? tweetOriginal.getContenidoTweet()
								: "";
						this.getPTextoPublicacionCitada().setText(contenidoOriginal);
					}
				}
			}

			// Contadores del retweet (siempre se muestran)
			int likesCount = bd.contarLikesTweet(_tweet.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(_tweet.getORMID());
			int comentariosCount = bd.contarComentariosTweet(_tweet.getORMID());

			if (this.getSpanContadorMeGusta() != null) {
				this.getSpanContadorMeGusta().setText(String.valueOf(likesCount));
			}
			if (this.getSpanContadorRetweet() != null) {
				this.getSpanContadorRetweet().setText(String.valueOf(retweetsCount));
			}
			if (this.getSpanContadorComentarios() != null) {
				this.getSpanContadorComentarios().setText(String.valueOf(comentariosCount));
			}

		} catch (Exception e) {
			System.err.println("Error cargando datos del retweet: " + e.getMessage());
			e.printStackTrace();
			// Valores por defecto en caso de error
			if (this.getPTextoPublicacion() != null) {
				this.getPTextoPublicacion().setText("Error cargando retweet");
			}
		}
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this, _tweet.getPublicado_por());
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}