package interfaz;

import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Verretweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;

	public Verretweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador,
			Tweet tweet) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;

		volver();
		this.Listadecomentariosadministrador(tweet);
		rellenarDatosTweet(tweet);

		this.getAvatarDivPrincipal().addClickListener(event -> {
			Verperfiladministrador();
		});
		this.getBotonEliminarTweet().addClickListener(event -> {
			this.Eliminarpublicacin(tweet);
		});
	}

	private void rellenarDatosTweet(Tweet tweet) {
		if (tweet == null)
			return;

		try {
			// Esta vista solo muestra retweets, por lo que siempre hay un tweet retweeteado
			Tweet tweetOriginal = tweet.getTweet_retweeteado();

			// Obtener datos del usuario que hizo el retweet
			basededatos.Usuario_Registrado usuarioRetweet = tweet.getPublicado_por();
			if (usuarioRetweet != null) {
				// Establecer nombre y handle del usuario que hizo el retweet
				this.getSpanNombreUsuario().setText(usuarioRetweet.getNickname());
				this.getSpanHandleUsuario().setText("@" + usuarioRetweet.getNickname());
			}

			// Contenido del retweet (comentario del usuario que retweetea)
			String contenidoRetweet = tweet.getContenidoTweet();
			if (contenidoRetweet != null && !contenidoRetweet.trim().isEmpty()) {
				this.getPTextoPublicacion().setText(contenidoRetweet);
			} else {
				this.getPTextoPublicacion().setText(""); // Retweet sin comentario
			}

			// Establecer fecha de publicación del retweet
			if (tweet.getFechaPublicacion() != null) {
				this.getSpanFecha().setText(tweet.getFechaPublicacion().toString());
			}

			// Siempre mostrar el layout de publicación citada
			this.getLayoutPublicacionCitada().getStyle().set("display", "block");

			// Rellenar datos del tweet original en la sección citada
			if (tweetOriginal != null) {
				basededatos.Usuario_Registrado autorOriginal = tweetOriginal.getPublicado_por();
				if (autorOriginal != null) {
					this.getSpanNombreUsuarioCitado().setText(autorOriginal.getNickname());
					this.getSpanHandleUsuarioCitado().setText("@" + autorOriginal.getNickname());
				}

				// Contenido del tweet original
				String contenidoOriginal = tweetOriginal.getContenidoTweet();
				if (contenidoOriginal != null) {
					this.getPTextoPublicacionCitada().setText(contenidoOriginal);
				}

				// Usar estadísticas del tweet original
				int likesCount = tweetOriginal.recibe_me_gusta != null ? tweetOriginal.recibe_me_gusta.size() : 0;
				this.getSpanContadorMeGusta().setText(String.valueOf(likesCount));

				int retweetsCount = tweetOriginal.retweets != null ? tweetOriginal.retweets.size() : 0;
				this.getSpanContadorRetweet().setText(String.valueOf(retweetsCount));

				int commentsCount = tweetOriginal.tiene != null ? tweetOriginal.tiene.size() : 0;
				this.getSpanContadorComentarios().setText(String.valueOf(commentsCount));
			} else {
				// Caso fallback si no hay tweet original (no debería ocurrir en esta vista)
				this.getPTextoPublicacionCitada().setText("Tweet original no disponible");
				this.getSpanNombreUsuarioCitado().setText("Usuario no disponible");
				this.getSpanHandleUsuarioCitado().setText("@desconocido");
			}

		} catch (Exception e) {
			// En caso de error, mostrar información básica
			this.getPTextoPublicacion().setText("Error al cargar retweet");
			this.getSpanNombreUsuario().setText("Usuario desconocido");
			this.getSpanHandleUsuario().setText("@desconocido");
			this.getPTextoPublicacionCitada().setText("Error al cargar tweet citado");
			this.getSpanNombreUsuarioCitado().setText("Usuario desconocido");
			this.getSpanHandleUsuarioCitado().setText("@desconocido");
		}
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}