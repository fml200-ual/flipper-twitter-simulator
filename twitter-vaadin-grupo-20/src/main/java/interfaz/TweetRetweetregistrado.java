package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetweetregistrado extends TweetRetweet {
	public Listadecomentariosregistrado _listadecomentariosregistrado;
	protected basededatos.Tweet tweet;
	public TweetRetweetregistrado(basededatos.Tweet tweet) {
		super();
		this.tweet = tweet;

		// Configurar imágenes y multimedia usando la lógica centralizada del padre
		if (tweet != null) {
			basededatos.Usuario_Registrado usuarioPrincipal = tweet.getPublicado_por();
			this.configurarImagenPerfilPrincipal(usuarioPrincipal);

			// Si el tweet es un retweet, configurar imagen del citado
			basededatos.Usuario_Registrado usuarioCitado = null;
			if (tweet.getTweet_retweeteado() != null) {
				usuarioCitado = tweet.getTweet_retweeteado().getPublicado_por();
			}
			this.configurarImagenPerfilCitado(usuarioCitado);

			// Mostrar multimedia si existe
			this.mostrarMultimediaTweet(tweet);
		}

		// Configurar eventos de interacción
		configurarEventosInteraccion();
	}
	
	/**
	 * Configurar eventos para retweet y comentario
	 */
	private void configurarEventosInteraccion() {
		// Configurar botón de retweet
		this.getIconoRetweet().addClickListener(event -> {
			mds2.MainView.Pantalla.MainView.removeAll();
			Darretweet darRetweet = new Darretweet(this);
			mds2.MainView.Pantalla.MainView.add(darRetweet);
		});
		
		// Configurar botón de comentario
		this.getIconoComentarios().addClickListener(event -> {
			mds2.MainView.Pantalla.MainView.removeAll();
			Escribircomentario escribirComentario = new Escribircomentario(this);
			mds2.MainView.Pantalla.MainView.add(escribirComentario);
		});
	}

	public void Listadecomentariosregistrado() {
		// Cargar comentarios reales desde la base de datos
		try {
			System.out.println("Cargando comentarios desde la base de datos...");
			
			if (tweet != null) {
				// Crear instancia de la base de datos
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				
				// Cargar comentarios reales del tweet
				basededatos.Comentario[] comentarios = bd.cargarComentariosDeTweet(tweet.getORMID());
				
				_listadecomentariosregistrado = new Listadecomentariosregistrado(null);
				
				if (comentarios != null && comentarios.length > 0) {
					System.out.println("Cargados " + comentarios.length + " comentarios desde la BD");
					
					// Crear items con datos reales
					for (basededatos.Comentario comentario : comentarios) {
						if (comentario != null) {
							Listadecomentariosregistrado_item item = new Listadecomentariosregistrado_item(
								_listadecomentariosregistrado, comentario);
							_listadecomentariosregistrado.getMainContainer().as(VerticalLayout.class)
								.add(item);
						}
					}
				} else {
					System.out.println("No se encontraron comentarios para este tweet");
					// Dejar la lista vacía si no hay comentarios
				}
			} else {
				System.out.println("Tweet es null, creando lista vacía de comentarios");
				_listadecomentariosregistrado = new Listadecomentariosregistrado(null);
			}
			
			// Agregar la lista de comentarios al contenedor
			this.getDiv4().add(_listadecomentariosregistrado);
			
		} catch (Exception e) {
			System.err.println("Error cargando comentarios desde la BD: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: crear lista vacía
			_listadecomentariosregistrado = new Listadecomentariosregistrado(null);
			this.getDiv4().add(_listadecomentariosregistrado);
		}
	}

	// Método para establecer el tweet desde las clases hijas
	protected void setTweet(basededatos.Tweet tweet) {
		this.tweet = tweet;
	}

	// Método para obtener el tweet desde las clases hijas
	protected basededatos.Tweet getTweet() {
		return this.tweet;
	}
}