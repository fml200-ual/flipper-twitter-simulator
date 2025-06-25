package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetweetnoregistrado extends TweetRetweet {
	public Listadecomentariosnoregistrado _listadecomentariosnoregistrado;
	protected basededatos.Tweet tweet;
	public TweetRetweetnoregistrado(basededatos.Tweet tweet) {
		super();
		this.tweet = tweet;
		
		// Configurar eventos para usuarios no registrados (solo visualización)
		configurarEventosVisualizacion();
	}
	
	/**
	 * Configurar eventos para usuarios no registrados (solo pueden ver, no interactuar)
	 */
	private void configurarEventosVisualizacion() {
		// Para usuarios no registrados, los iconos no tendrán funcionalidad de escritura
		// Solo pueden ver los tweets y comentarios
		this.getIconoRetweet().addClickListener(event -> {
			System.out.println("Usuario no registrado intentó hacer retweet - acción no permitida");
			// Podrías mostrar un mensaje o redirigir al login
		});
		
		this.getIconoComentarios().addClickListener(event -> {
			System.out.println("Usuario no registrado intentó comentar - acción no permitida");
			// Podrías mostrar un mensaje o redirigir al login
		});
	}

	public void Listadecomentariosnoregistrado() {
		// Cargar comentarios reales desde la base de datos
		try {
			System.out.println("Cargando comentarios para usuario no registrado...");
			
			if (tweet != null) {
				// Crear instancia de la base de datos
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				
				// Cargar comentarios reales del tweet
				basededatos.Comentario[] comentarios = bd.cargarComentariosDeTweet(tweet.getORMID());
				
				_listadecomentariosnoregistrado = new Listadecomentariosnoregistrado(this);
				
				if (comentarios != null && comentarios.length > 0) {
					System.out.println("Cargados " + comentarios.length + " comentarios desde la BD");
					
					// Crear items con datos reales
					for (basededatos.Comentario comentario : comentarios) {
						if (comentario != null) {
							Listadecomentariosnoregistrado_item item = new Listadecomentariosnoregistrado_item(
								_listadecomentariosnoregistrado, comentario);
							_listadecomentariosnoregistrado.getMainContainer().as(VerticalLayout.class)
								.add(item);
						}
					}
				} else {
					System.out.println("No se encontraron comentarios para este tweet");
					// Dejar la lista vacía si no hay comentarios
				}
			} else {
				System.out.println("Tweet es null, creando lista vacía de comentarios");
				_listadecomentariosnoregistrado = new Listadecomentariosnoregistrado(this);
			}
			
			// Agregar la lista de comentarios al contenedor
			this.getDiv4().add(_listadecomentariosnoregistrado);
			
		} catch (Exception e) {
			System.err.println("Error cargando comentarios desde la BD: " + e.getMessage());
			e.printStackTrace();
			
			// Fallback: crear lista vacía
			_listadecomentariosnoregistrado = new Listadecomentariosnoregistrado(this);
			this.getDiv4().add(_listadecomentariosnoregistrado);
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