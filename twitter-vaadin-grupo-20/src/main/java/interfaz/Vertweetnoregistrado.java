package interfaz;

public class Vertweetnoregistrado extends TweetRetweetnoregistrado {
	public Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado;

	public Vertweetnoregistrado(Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado) {
		super();
		this._listadetweetsyretweetsnoregistrado = _listadetweetsyretweetsnoregistrado;
		// Ensamblado estático y dinámico para ver tweet
		setupStaticTweetView();
		setupTweetView();
		setupBackButton();
	}
	
	private void setupStaticTweetView() {
		// Configurar elementos estáticos de la vista de tweet
		this.addAttachListener(e -> {
			// Aplicar estilos generales para la vista de tweet
			this.getElement().getStyle()
				.set("background-color", "black")
				.set("color", "white")
				.set("padding", "20px")
				.set("font-family", "Arial, sans-serif");
		});
	}	private void setupTweetView() {
		// Configurar vista específica de tweet para usuario no registrado
		// Heredar configuración base de TweetRetweetnoregistrado
		// Ocultar botones específicos de tweet (responder, dar like, etc.)
		hideTweetActions();
		hideQuotedTweet(); // Ocultar publicación citada cuando no sea retweet
		setupTweetContent();
		setupCommentsSection(); // Configurar sección de comentarios
	}
	
	private void hideQuotedTweet() {
		// Ocultar la publicación citada ya que este es un tweet simple, no un retweet
		this.addAttachListener(e -> {
			if (this.getContenedorPublicacionCitada() != null) {
				this.getContenedorPublicacionCitada().setVisible(false);
			}
		});
	}	private void setupTweetContent() {
		// Configurar contenido del tweet con datos pasados desde la navegación
		this.addAttachListener(e -> {
			// Configurar el nombre del usuario
			if (this.getNombreUsuario() != null) {
				this.getNombreUsuario().setText("Usuario Tech");
			}
			
			// Configurar el arroba del usuario
			if (this.getArrobaUsuario() != null) {
				this.getArrobaUsuario().setText("@tech_guru");
			}
			
			// Configurar el contenido del tweet
			if (this.getTextoPublicacion() != null) {
				this.getTextoPublicacion().setText("Este #Hashtag está revolucionando la tecnología! 🚀");
			}
			
			// Asegurar que solo haya un tweet visible (ocultar duplicados)
			hideUnnecessaryElements();
		});
	}
	
	private void hideUnnecessaryElements() {
		// Ocultar elementos innecesarios o duplicados
		this.addAttachListener(e -> {
			// Aplicar estilos para asegurar fondo negro
			this.getElement().getStyle()
				.set("background-color", "black")
				.set("min-height", "100vh");
				
			// Ocultar botón de eliminar tweet para usuario no registrado
			if (this.getBotonEliminarTweet() != null) {
				this.getBotonEliminarTweet().setVisible(false);
			}		});
	}
	
	private void setupBackButton() {
		// Configurar botón de volver para regresar al hashtag
		this.addAttachListener(e -> {
			// Buscar elementos de navegación en la vista
			// Esto dependerá de la estructura específica de la vista
			// Por ahora, aplicar estilos de navegación básicos
			setupNavigationStyles();
		});
	}
	
	private void setupNavigationStyles() {
		// Aplicar estilos para mejorar la navegación
		this.getElement().getStyle()
			.set("min-height", "100vh")
			.set("background-color", "black")
			.set("color", "white")
			.set("padding", "20px");
	}

	private void hideTweetActions() {
		// Ocultar acciones específicas de tweet que requieren login
		this.addAttachListener(e -> {
			// Ocultar botones de like, retweet, responder, etc.
			// Estos elementos dependerán de la estructura de TweetRetweetnoregistrado
		});
	}
	public void goBackToHashtag() {
		// Método para volver al hashtag desde la vista de tweet  
		// Por ahora, simplificar la navegación usando una referencia directa guardada
		// Esta funcionalidad se puede expandir más adelante
	}
	private void setupCommentsSection() {
		// Configurar sección de comentarios para usuario no registrado
		this.addAttachListener(e -> {			// Configurar el botón "Mostrar más comentarios"
			if (this.getMostrarMasComentarios() != null) {
				this.getMostrarMasComentarios().addEventListener("click", event -> {
					loadComments();
				});
				
				// Aplicar estilos al botón
				this.getMostrarMasComentarios().getStyle()
					.set("color", "#00FFFF")
					.set("text-decoration", "none")
					.set("cursor", "pointer")
					.set("padding", "10px")
					.set("display", "block")
					.set("text-align", "center");
			}
			
			// Configurar el contenedor de comentarios
			if (this.getDiv4() != null) {
				this.getDiv4().getStyle()
					.set("background-color", "transparent")
					.set("color", "white");
			}
			
			// Cargar comentarios iniciales
			loadInitialComments();
		});
	}
	
	private void loadInitialComments() {
		// Cargar comentarios iniciales de ejemplo
		if (this.getDiv4() != null) {
			// Crear lista de comentarios para este tweet
			if (_listadetweetsyretweetsnoregistrado != null) {
				// Crear instancia de lista de comentarios
				Listadecomentariosnoregistrado comentarios = new Listadecomentariosnoregistrado(this);
				
		// Agregar la lista de comentarios al contenedor
		this.addAttachListener(e -> {
			if (this.getDiv4() != null) {
				this.getDiv4().removeAll();
				this.getDiv4().add(comentarios);
			}
		});
			}
		}
	}
	
	private void loadComments() {
		// Cargar más comentarios dinámicamente
		if (this.getDiv4() != null) {
			// Encontrar la lista de comentarios existente y agregar más
			loadMoreCommentsToContainer();
		}
	}
	
	private void loadMoreCommentsToContainer() {
		// Agregar más comentarios al contenedor existente
		this.addAttachListener(e -> {
			if (this.getDiv4() != null) {
				// Buscar si ya existe una lista de comentarios
				if (this.getDiv4().getChildren().findFirst().isPresent()) {
					// Si existe, agregar más comentarios a la lista existente
					Object existingList = this.getDiv4().getChildren().findFirst().get();
					if (existingList instanceof Listadecomentariosnoregistrado) {
						Listadecomentariosnoregistrado comentarios = (Listadecomentariosnoregistrado) existingList;
						comentarios.addMoreComments(); // Método para agregar más comentarios
					}
				} else {
					// Si no existe, crear nueva lista
					loadInitialComments();
				}
			}
		});
	}
}