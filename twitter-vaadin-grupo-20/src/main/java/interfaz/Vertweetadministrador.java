package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetadministrador extends TweetRetwetadministrador {
	private basededatos.Tweet tweet;
	public Vertweetadministrador(basededatos.Tweet tweet) {
		super(tweet);
		this.tweet = tweet;

		// Configurar elementos específicos para administrador
		this.getLayoutPublicacionCitada().setVisible(false);

		// Cargar datos del tweet
		cargarDatosTweet();

		// Configurar lista de comentarios para administrador
		this.Listadecomentariosadministrador();

		// Configurar navegación del avatar para ver perfil
		this.getAvatarDivPrincipal().addClickListener(event -> {
			verPerfilAdministrador();
		});

		// Configurar botón de eliminar tweet (solo para administradores)
		configurarBotonEliminar();

		// Configurar botón volver
		configurarBotonVolver();
	}
	private void cargarDatosTweet() {
		if (tweet == null) return;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// Contenido del tweet
			this.getPTextoPublicacion().setText(tweet.getContenidoTweet() != null ? 
				tweet.getContenidoTweet() : "");			// Datos del usuario
			if (tweet.getPublicado_por() != null) {
				this.getSpanHandleUsuario().setText("@" + tweet.getPublicado_por().getNickname());
				this.getSpanNombreUsuario().setText(tweet.getPublicado_por().getNickname());
			}

			// Fecha de publicación
			if (tweet.getFechaPublicacion() != null) {
				this.getSpanFecha().setText(tweet.getFechaPublicacion().toString());
			}

			// Contadores usando métodos BD para evitar LazyInitializationException
			int likesCount = bd.contarLikesTweet(tweet.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(tweet.getORMID());
			int comentariosCount = bd.contarComentariosTweet(tweet.getORMID());

			this.getSpanContadorMeGusta().setText(String.valueOf(likesCount));
			this.getSpanContadorRetweet().setText(String.valueOf(retweetsCount));
			this.getSpanContadorComentarios().setText(String.valueOf(comentariosCount));

			// Manejar retweet citado si existe
			manejarRetweetCitado();

		} catch (Exception e) {
			System.err.println("Error cargando datos del tweet: " + e.getMessage());
			// Valores por defecto en caso de error
			this.getPTextoPublicacion().setText("Error cargando tweet");
			this.getSpanHandleUsuario().setText("@usuario");
			this.getSpanNombreUsuario().setText("Usuario");
			this.getSpanFecha().setText("--");
			this.getSpanContadorMeGusta().setText("0");
			this.getSpanContadorRetweet().setText("0");
			this.getSpanContadorComentarios().setText("0");
		}
	}
	private void manejarRetweetCitado() {
		// Si es un retweet con cita, mostrar información básica del tweet original
		if (tweet.getTweet_retweeteado() != null) {
			basededatos.Tweet tweetOriginal = tweet.getTweet_retweeteado();
			
			// Mostrar contenido del tweet citado en el contenedor correspondiente
			this.getPTextoPublicacionCitada().setText(tweetOriginal.getContenidoTweet() != null ? 
				tweetOriginal.getContenidoTweet() : "");
			
			// Mostrar datos del usuario citado
			if (tweetOriginal.getPublicado_por() != null) {
				this.getSpanHandleUsuarioCitado().setText("@" + tweetOriginal.getPublicado_por().getNickname());
				this.getSpanNombreUsuarioCitado().setText(tweetOriginal.getPublicado_por().getNickname());
			}
			
			this.getLayoutPublicacionCitada().setVisible(true);
		}
	}

	private void configurarBotonEliminar() {
		// Solo administradores pueden eliminar tweets
		this.getBotonEliminarTweet().addClickListener(event -> {
			eliminarTweet();
		});
	}
	private void configurarBotonVolver() {
		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT03Administrador(null));
		});
	}

	private void verPerfilAdministrador() {
		Verperfiladministrador verPerfil = new Verperfiladministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(verPerfil);
	}
	private void eliminarTweet() {
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			// Eliminar el tweet usando el método de la base de datos
			bd.eliminarTweet(tweet.getORMID());
			
			// Regresar a la pantalla principal del administrador
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT03Administrador(null));
			
		} catch (Exception e) {
			System.err.println("Error eliminando tweet: " + e.getMessage());
			// En caso de error, también regresar a la pantalla principal
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT03Administrador(null));
		}
	}
}