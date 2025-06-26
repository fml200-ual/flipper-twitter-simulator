package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetnoregistrado extends TweetRetweetnoregistrado {
	public Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado;
	private basededatos.Tweet tweet;

	public Vertweetnoregistrado(Listadetweetsyretweetsnoregistrado_item listadetweetsyretweetsnoregistrado,
			basededatos.Tweet tweet) {
		super(tweet);
		this.tweet = tweet;

		// Configurar elementos no disponibles para usuarios no registrados
		this.getBotonEliminarTweet().setVisible(false);
		this.getContenedorPublicacionCitada().setVisible(false);

		// Cargar datos del tweet
		cargarDatosTweet();

		// Configurar lista de comentarios
		this.Listadecomentariosnoregistrado();

		// Configurar navegación
		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});
		// Agregar listeners a los iconos para redirigir a login
		this.getIconoMeGusta().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});

		this.getIconoRetweet().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});

		this.getIconoComentarios().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});
	}

	private void cargarDatosTweet() {
		if (tweet == null)
			return;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// Contenido del tweet
			this.getTextoPublicacion().setText(tweet.getContenidoTweet() != null ? tweet.getContenidoTweet() : "");

			// Datos del usuario
			if (tweet.getPublicado_por() != null) {
				this.getArrobaUsuario().setText("@" + tweet.getPublicado_por().getNickname());
				this.getNombreUsuario().setText(tweet.getPublicado_por().getNickname());
			}

			// Fecha de publicación
			if (tweet.getFechaPublicacion() != null) {
				this.getFechaPublicacion().setText(tweet.getFechaPublicacion().toString());
			}

			// Contadores
			int likesCount = bd.contarLikesTweet(tweet.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(tweet.getORMID());
			int comentariosCount = bd.contarComentariosTweet(tweet.getORMID());

			this.getNumMegusta().setText(String.valueOf(likesCount));
			this.getNumeroRetweets().setText(String.valueOf(retweetsCount));
			this.getNumeroRetweets1().setText(String.valueOf(comentariosCount));

		} catch (Exception e) {
			System.err.println("Error cargando datos del tweet: " + e.getMessage());
			// Valores por defecto en caso de error
			this.getTextoPublicacion().setText("Error cargando tweet");
			this.getArrobaUsuario().setText("@usuario");
			this.getFechaPublicacion().setText("--");
			this.getNumMegusta().setText("0");
			this.getNumeroRetweets().setText("0");
			this.getNumeroRetweets1().setText("0");
		}
	}
}