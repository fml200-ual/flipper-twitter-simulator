package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TweetRetweetnoregistrado extends TweetRetweet {
	public Listadecomentariosnoregistrado _listadecomentariosnoregistrado;
	protected basededatos.Tweet tweet;
	
	public TweetRetweetnoregistrado(basededatos.Tweet tweet) {
		super();
		this.tweet = tweet;
		
		// Configurar datos del tweet
		configurarDatosTweet();
		
		// Configurar eventos para usuarios no registrados (solo visualización)
		configurarEventosVisualizacion();
	}
	
	/**
	 * Configurar los datos del tweet en la interfaz
	 */
	private void configurarDatosTweet() {
		if (tweet != null) {
			try {
				// Configurar datos del usuario principal
				basededatos.Usuario_Registrado usuario = tweet.getPublicado_por();
				
				System.out.println("🔍 Debug Tweet ID: " + tweet.getORMID());
				System.out.println("🔍 Debug Usuario obtenido: " + (usuario != null ? "Usuario encontrado" : "Usuario es NULL"));
				
				if (usuario != null) {
					// Configurar nickname
					String nickname = usuario.getNickname();
					System.out.println("🔍 Debug Nickname: " + nickname);
					
					if (nickname != null && !nickname.trim().isEmpty()) {
						this.getNombreUsuario().setText(nickname);
						this.getArrobaUsuario().setText("@" + nickname);
					} else {
						this.getNombreUsuario().setText("Usuario sin nombre");
						this.getArrobaUsuario().setText("@usuario");
						System.out.println("⚠️ Usuario sin nickname, usando valores por defecto");
					}
					
					// Configurar imagen de perfil usando método del padre
					configurarImagenPerfilPrincipal(usuario);
				} else {
					// Usuario es null - usar valores por defecto
					System.err.println("❌ Usuario del tweet es NULL - usando valores por defecto");
					this.getNombreUsuario().setText("Usuario no disponible");
					this.getArrobaUsuario().setText("@usuario");
					configurarImagenPorDefectoPrincipal();
				}
				
				// Configurar texto del tweet
				if (tweet.getContenidoTweet() != null) {
					this.getTextoPublicacion().setText(tweet.getContenidoTweet());
				}
				
				// Configurar fecha
				if (tweet.getFechaPublicacion() != null) {
					this.getFechaPublicacion().setText(tweet.getFechaPublicacion().toString());
				}
				
				// Mostrar multimedia si existe
				mostrarMultimediaTweet(tweet);
				
				// Configurar datos de tweet citado si existe
				configurarTweetCitado();
				
				System.out.println("✅ Datos del tweet configurados correctamente para usuario no registrado");
				
			} catch (Exception e) {
				System.err.println("❌ Error configurando datos del tweet: " + e.getMessage());
				e.printStackTrace();
				// Usar valores por defecto en caso de error
				usarValoresPorDefecto();
			}
		} else {
			System.err.println("⚠️ Tweet es null, usando valores por defecto");
			usarValoresPorDefecto();
		}
	}
	
	/**
	 * Configurar datos del tweet citado si existe
	 */
	private void configurarTweetCitado() {
		// Si el tweet actual es un retweet, configurar los datos del tweet original
		if (tweet.getTweet_retweeteado() != null) {
			basededatos.Tweet tweetCitado = tweet.getTweet_retweeteado();
			basededatos.Usuario_Registrado usuarioCitado = tweetCitado.getPublicado_por();
			
			System.out.println("🔍 Debug Tweet citado ID: " + tweetCitado.getORMID());
			System.out.println("🔍 Debug Usuario citado obtenido: " + (usuarioCitado != null ? "Usuario encontrado" : "Usuario es NULL"));
			
			if (usuarioCitado != null) {
				// Verificar y configurar nickname del usuario citado
				String nicknameCitado = null;
				try {
					nicknameCitado = usuarioCitado.getNickname();
					System.out.println("🔍 Debug Nickname citado: " + nicknameCitado);
				} catch (Exception e) {
					System.err.println("❌ Error obteniendo nickname del usuario citado: " + e.getMessage());
				}
				
				if (nicknameCitado != null && !nicknameCitado.trim().isEmpty()) {
					this.getNombreUsuarioCitado().setText(nicknameCitado);
					this.getArrobaUsuarioCitado().setText("@" + nicknameCitado);
				} else {
					this.getNombreUsuarioCitado().setText("Usuario citado");
					this.getArrobaUsuarioCitado().setText("@usuario");
					System.out.println("⚠️ Usuario citado sin nickname, usando valores por defecto");
				}
				
				// Configurar imagen de perfil del usuario citado usando CSS background (como en los perfiles)
				configurarImagenPerfilCitado(usuarioCitado);
				
				// Configurar texto del tweet citado
				if (tweetCitado.getContenidoTweet() != null) {
                    this.getTextoPublicacionCitada().setText(tweetCitado.getContenidoTweet());
                }
                // Mostrar multimedia del tweet citado
                mostrarMultimediaTweet(tweetCitado);
			} else {
				// Usuario citado es null - usar valores por defecto
				System.err.println("❌ Usuario del tweet citado es NULL - usando valores por defecto");
				this.getNombreUsuarioCitado().setText("Usuario no disponible");
				this.getArrobaUsuarioCitado().setText("@usuario");
				configurarImagenPorDefectoCitado();
			}
			
			// Mostrar el contenedor de publicación citada
			this.getContenedorPublicacionCitada().getStyle().set("display", "block");
		} else {
			// Ocultar el contenedor de publicación citada si no hay tweet citado
			this.getContenedorPublicacionCitada().getStyle().set("display", "none");
		}
	}
	
	/**
	 * Usar valores por defecto en caso de error
	 */
	private void usarValoresPorDefecto() {
		this.getNombreUsuario().setText("Usuario");
		this.getArrobaUsuario().setText("@usuario");
		configurarImagenPorDefectoPrincipal();
		this.getTextoPublicacion().setText("Tweet sin datos");
		this.getFechaPublicacion().setText("Fecha no disponible");
		
		// Ocultar tweet citado
		this.getContenedorPublicacionCitada().getStyle().set("display", "none");
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