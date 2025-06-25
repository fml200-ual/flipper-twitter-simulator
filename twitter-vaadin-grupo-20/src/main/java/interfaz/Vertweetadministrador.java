package interfaz;

import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Vertweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;

	public Vertweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador,
			Tweet tweet) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;

		this.getLayoutPublicacionCitada().setVisible(false);

		// Añadir botón de regreso
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
			// Obtener datos del usuario que publicó el tweet
			basededatos.Usuario_Registrado usuario = tweet.getPublicado_por();
			if (usuario != null) {
				// Establecer nombre y handle del usuario
				this.getSpanNombreUsuario().setText(usuario.getNickname());
				this.getSpanHandleUsuario().setText("@" + usuario.getNickname());
			}

			// Establecer contenido del tweet
			String contenido = "";
			if (tweet.getTweet_retweeteado() != null) {
				// Es un retweet
				contenido = "RT: " + (tweet.getTweet_retweeteado().getContenidoTweet() != null
						? tweet.getTweet_retweeteado().getContenidoTweet()
						: "");
				// Si el retweet tiene comentario adicional
				if (tweet.getContenidoTweet() != null && !tweet.getContenidoTweet().trim().isEmpty()) {
					contenido = tweet.getContenidoTweet() + "\n\n" + contenido;
				}
			} else {
				// Es un tweet original
				contenido = tweet.getContenidoTweet() != null ? tweet.getContenidoTweet() : "";
			}
			this.getPTextoPublicacion().setText(contenido);

			// Establecer fecha de publicación
			if (tweet.getFechaPublicacion() != null) {
				this.getSpanFecha().setText(tweet.getFechaPublicacion().toString());
			}

			// Contar likes (me gusta)
			int likesCount = tweet.recibe_me_gusta != null ? tweet.recibe_me_gusta.size() : 0;
			this.getSpanContadorMeGusta().setText(String.valueOf(likesCount));

			// Contar retweets
			int retweetsCount = tweet.retweets != null ? tweet.retweets.size() : 0;
			this.getSpanContadorRetweet().setText(String.valueOf(retweetsCount));

			// Contar comentarios
			int commentsCount = tweet.tiene != null ? tweet.tiene.size() : 0;
			this.getSpanContadorComentarios().setText(String.valueOf(commentsCount));

		} catch (Exception e) {
			// En caso de error, mostrar información básica
			this.getPTextoPublicacion().setText("Error al cargar tweet");
			this.getSpanNombreUsuario().setText("Usuario desconocido");
			this.getSpanHandleUsuario().setText("@desconocido");
		}
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}