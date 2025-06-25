package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetwetadministrador extends Publicacinvistaadministrador {
	public Listadecomentariosadministrador _listadecomentariosadministrador;
	protected basededatos.Tweet tweet;
	public TweetRetwetadministrador(basededatos.Tweet tweet) {
		super();
		this.tweet = tweet;
		
		// Configurar eventos para administrador
		configurarEventosAdministrador();
	}
		/**
	 * Configurar eventos para administrador (pueden retweet y comentar como usuarios normales)
	 */
	private void configurarEventosAdministrador() {
		// Los administradores pueden hacer retweet y comentar
		this.getIconoRetweet().addClickListener(event -> {
			mds2.MainView.Pantalla.MainView.removeAll();
			// Crear un TweetRetweetajeno temporal para usar con Darretweet
			TweetRetweetajeno tweetTemp = new TweetRetweetajeno(this.tweet);
			Darretweet darRetweet = new Darretweet(tweetTemp);
			mds2.MainView.Pantalla.MainView.add(darRetweet);
		});
		
		this.getIconoComentar().addClickListener(event -> {
			mds2.MainView.Pantalla.MainView.removeAll();
			// Crear un TweetRetweetajeno temporal para usar con Escribircomentario
			TweetRetweetajeno tweetTemp = new TweetRetweetajeno(this.tweet);
			Escribircomentario escribirComentario = new Escribircomentario(tweetTemp);
			mds2.MainView.Pantalla.MainView.add(escribirComentario);
		});
	}

	public void Listadecomentariosadministrador() {
		// Cargar comentarios reales desde la base de datos
		try {
			System.out.println("Cargando comentarios para administrador...");
			
			if (tweet != null) {
				// Crear instancia de la base de datos
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				
				// Cargar comentarios reales del tweet
				basededatos.Comentario[] comentarios = bd.cargarComentariosDeTweet(tweet.getORMID());
				
				_listadecomentariosadministrador = new Listadecomentariosadministrador(this);
				
				if (comentarios != null && comentarios.length > 0) {
					System.out.println("Cargados " + comentarios.length + " comentarios desde la BD");
					
					// Crear items con datos reales
					for (basededatos.Comentario comentario : comentarios) {
						if (comentario != null) {
							Listadecomentariosadministrador_item item = new Listadecomentariosadministrador_item(
								_listadecomentariosadministrador, comentario);
							_listadecomentariosadministrador.getMainContainer().as(VerticalLayout.class)
								.add(item);
						}
					}
				} else {
					System.out.println("No se encontraron comentarios para este tweet");
					// Dejar la lista vacía si no hay comentarios
				}
			} else {
				System.out.println("Tweet es null, creando lista vacía de comentarios");
				_listadecomentariosadministrador = new Listadecomentariosadministrador(this);
			}
			
			// Agregar la lista de comentarios al contenedor
			this.getContenedorComentarios().add(_listadecomentariosadministrador);
			
		} catch (Exception e) {
			System.err.println("Error cargando comentarios desde la BD: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: crear lista vacía
			_listadecomentariosadministrador = new Listadecomentariosadministrador(this);
			this.getContenedorComentarios().add(_listadecomentariosadministrador);
		}
	}

	// Métodos para establecer y obtener el tweet desde las clases hijas
	protected void setTweet(basededatos.Tweet tweet) {
		this.tweet = tweet;
	}

	protected basededatos.Tweet getTweet() {
		return this.tweet;
	}
}