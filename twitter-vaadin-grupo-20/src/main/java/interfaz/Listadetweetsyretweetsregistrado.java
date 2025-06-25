package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;

public class Listadetweetsyretweetsregistrado extends Listadetweetsyretweets {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verhashtagregistrado _verhashtagregistrado;	public Listadetweetsyretweetsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super(); // Constructor base sin inicialización
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		// Inicializar manualmente para usuarios registrados
		inicializarTweetsRegistrado();
	}
	
	// Constructor específico para cargar tweets de un usuario específico (Mis tweets)
	public Listadetweetsyretweetsregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado, basededatos.Usuario_Registrado usuario) {
		super(); // Constructor base sin inicialización
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
		// NO llamar a inicializarTweetsRegistrado(), usar método específico
		cargarTweetsDeUsuario(usuario);
	}
	
	public Listadetweetsyretweetsregistrado(Verhashtagregistrado verhashtagregistrado) {
		super();
		this._verhashtagregistrado = verhashtagregistrado;
		// No llamamos a inicializarTweetsRegistrado aquí porque se usará cargarTweetsDeHashtag
	}
	
	// Constructor para contexto de visualización de perfil (sin inicialización automática)
	public Listadetweetsyretweetsregistrado() {
		super(); // Constructor base sin inicialización
		// No asignar _aCT02UsuarioRegistrado ni _verhashtagregistrado
		// Este constructor se usa cuando se cargarán tweets manualmente desde otra clase
	}	// Método para cargar tweets de un hashtag específico
	public void cargarTweetsDeHashtag(basededatos.Hashtag hashtag) {
		cargarTweetsDeHashtag(hashtag, false);
	}
		// Método para cargar tweets de un hashtag específico con opción de agrupación
	public void cargarTweetsDeHashtag(basededatos.Hashtag hashtag, boolean agrupar) {
		if (hashtag == null) return;
				try {
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			
			// Configurar layout principal para ser más compacto
			VerticalLayout mainLayout = this.getMainContainer().as(VerticalLayout.class);
			mainLayout.setPadding(false);
			mainLayout.setSpacing(false);
			mainLayout.setMargin(false);
			
			// Cargar tweets que contienen este hashtag usando BDPrincipal para manejar sesiones correctamente
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			Tweet[] tweets = bd.cargarTweetsDeHashtag(hashtag.getId_hashtag());
			
			if (tweets != null && tweets.length > 0) {
				System.out.println("Tweets encontrados para hashtag " + hashtag.getHashtag() + ": " + tweets.length);
				
				if (agrupar) {
					// Mostrar como grupo agrupado
					crearVistaAgrupadaHashtag(hashtag, tweets);
				} else {
					// Mostrar tweets individuales (comportamiento original) con layout compacto
					for (Tweet tweet : tweets) {
						if (tweet != null) {
							Listadetweetsyretweetsregistrado_item item = 
								new Listadetweetsyretweetsregistrado_item(this, tweet);
							mainLayout.add(item);
							this._item.add(item);
						}
					}
				}
			} else {
				// Si no hay tweets con este hashtag, mostrar mensaje
				System.out.println("No hay tweets para el hashtag: " + hashtag.getHashtag());
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets del hashtag: " + e.getMessage());
			e.printStackTrace();
		}
	}
		/**
	 * Crear una vista agrupada para un hashtag que muestra:
	 * - El hashtag como título
	 * - Número total de tweets
	 * - Lista condensada o expandible de tweets
	 */
	private void crearVistaAgrupadaHashtag(basededatos.Hashtag hashtag, Tweet[] tweets) {
		try {
			// Crear un contenedor usando componentes Vaadin existentes
			com.vaadin.flow.component.orderedlayout.VerticalLayout grupoHashtag = 
				new com.vaadin.flow.component.orderedlayout.VerticalLayout();
			grupoHashtag.setWidth("100%");
			grupoHashtag.setPadding(true);
			grupoHashtag.setSpacing(true);
			grupoHashtag.addClassName("hashtag-group");
			
			// Crear cabecera del grupo
			com.vaadin.flow.component.orderedlayout.HorizontalLayout cabecera = 
				new com.vaadin.flow.component.orderedlayout.HorizontalLayout();
			cabecera.setWidth("100%");
			cabecera.setAlignItems(com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER);
			cabecera.setJustifyContentMode(com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN);
			
			// Título del hashtag
			com.vaadin.flow.component.html.H3 tituloHashtag = new com.vaadin.flow.component.html.H3();
			if (hashtag != null && hashtag.getHashtag() != null) {
				String hashtagText = hashtag.getHashtag();
				if (!hashtagText.startsWith("#")) {
					hashtagText = "#" + hashtagText;
				}
				tituloHashtag.setText(hashtagText);
			} else {
				tituloHashtag.setText("#hashtag");
			}
			tituloHashtag.getStyle().set("margin", "0");
			tituloHashtag.getStyle().set("color", "#1DA1F2"); // Color azul tipo Twitter
			
			// Calcular contadores agregados
			int totalLikes = 0;
			int totalRetweets = 0;
			int totalComentarios = 0;
			
			if (tweets != null && tweets.length > 0) {
				try {
					basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
					for (Tweet tweet : tweets) {
						if (tweet != null) {
							totalLikes += bdTweet.contarMeGustaTweet(tweet.getId_tweet());
							totalRetweets += bdTweet.contarRetweetsTweet(tweet.getId_tweet());
							totalComentarios += bdTweet.contarComentariosTweet(tweet.getId_tweet());
						}
					}
				} catch (Exception e) {
					System.err.println("Error calculando contadores agregados: " + e.getMessage());
				}
			}
			
			// Contadores agregados
			com.vaadin.flow.component.html.Div contadores = new com.vaadin.flow.component.html.Div();
			contadores.getStyle().set("display", "flex");
			contadores.getStyle().set("gap", "15px");
			contadores.getStyle().set("color", "#657786");
			contadores.getStyle().set("font-size", "14px");
			
			com.vaadin.flow.component.html.Span likesTotales = new com.vaadin.flow.component.html.Span("❤️ " + totalLikes);
			com.vaadin.flow.component.html.Span retweetsTotales = new com.vaadin.flow.component.html.Span("🔄 " + totalRetweets);
			com.vaadin.flow.component.html.Span comentariosTotales = new com.vaadin.flow.component.html.Span("💬 " + totalComentarios);
			contadores.add(likesTotales, retweetsTotales, comentariosTotales);
			
			// Contador de tweets
			com.vaadin.flow.component.html.Span contadorTweets = new com.vaadin.flow.component.html.Span();
			int numTweets = tweets != null ? tweets.length : 0;
			contadorTweets.setText(numTweets + " tweet" + (numTweets != 1 ? "s" : ""));
			contadorTweets.getStyle().set("color", "#657786");
			contadorTweets.getStyle().set("font-size", "14px");
			
			cabecera.add(tituloHashtag, contadores, contadorTweets);
			grupoHashtag.add(cabecera);
			
			// Crear contenedor de tweets expandible usando Details
			com.vaadin.flow.component.orderedlayout.VerticalLayout contenedorTweets = 
				new com.vaadin.flow.component.orderedlayout.VerticalLayout();
			contenedorTweets.setSpacing(false);
			contenedorTweets.setPadding(false);
			
			// Cargar solo los primeros 3 tweets por defecto (para mejor rendimiento)
			int maxTweetsIniciales = Math.min(3, tweets != null ? tweets.length : 0);
			
			for (int i = 0; i < maxTweetsIniciales; i++) {
				if (tweets[i] != null) {
					Listadetweetsyretweetsregistrado_item item = 
						new Listadetweetsyretweetsregistrado_item(this, tweets[i]);
					contenedorTweets.add(item);
				}
			}
			
			// Si hay más tweets, mostrar indicador
			if (tweets != null && tweets.length > maxTweetsIniciales) {
				com.vaadin.flow.component.html.Span masIndicador = 
					new com.vaadin.flow.component.html.Span("+" + (tweets.length - maxTweetsIniciales) + " tweets más...");
				masIndicador.getStyle().set("color", "#1DA1F2");
				masIndicador.getStyle().set("font-style", "italic");
				masIndicador.getStyle().set("text-align", "center");
				contenedorTweets.add(masIndicador);
			}
			
			// Crear Details (componente expandible de Vaadin)
			com.vaadin.flow.component.details.Details detallesExpandibles = 
				new com.vaadin.flow.component.details.Details("Ver tweets", contenedorTweets);
			detallesExpandibles.setWidth("100%");
			
			// Configurar evento de expansión para cargar todos los tweets
			detallesExpandibles.addOpenedChangeListener(e -> {
				if (e.isOpened()) {
					// Limpiar contenido actual
					contenedorTweets.removeAll();
					
					// Cargar todos los tweets
					if (tweets != null) {
						for (Tweet tweet : tweets) {
							if (tweet != null) {
								Listadetweetsyretweetsregistrado_item item = 
									new Listadetweetsyretweetsregistrado_item(this, tweet);
								contenedorTweets.add(item);
							}
						}
					}
				}
			});
			
			grupoHashtag.add(detallesExpandibles);
			this.getMainContainer().as(VerticalLayout.class).add(grupoHashtag);
			
		} catch (Exception e) {
			System.err.println("Error creando vista agrupada de hashtag: " + e.getMessage());
			// Fallback: mostrar tweets individuales
			for (Tweet tweet : tweets) {
				if (tweet != null) {
					Listadetweetsyretweetsregistrado_item item = 
						new Listadetweetsyretweetsregistrado_item(this, tweet);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					this._item.add(item);
				}
			}
		}
	}
		private void inicializarTweetsRegistrado() {
		// Cargar tweets reales desde la base de datos específicamente para usuarios registrados
		try {
			System.out.println("=== Cargando tweets para usuario registrado ===");
			
			// Verificar el estado del usuario antes de cargar tweets
			mds2.MainView.verificarEstadoUsuario("inicializarTweetsRegistrado - inicio");
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Cargar tweets reales de la base de datos
			Tweet[] tweets = bd.cargarTweets();
			
			if (tweets != null && tweets.length > 0) {
				System.out.println("Cargados " + tweets.length + " tweets desde la BD para usuario registrado");
				
				// Crear items específicos para usuarios registrados con datos reales
				for (Tweet tweet : tweets) {
					if (tweet != null) {
						System.out.println("Creando item para tweet: " + tweet.getId_tweet());
						Listadetweetsyretweetsregistrado_item item = 
							new Listadetweetsyretweetsregistrado_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						_item.add(item);
					}
				}
				System.out.println("Items de tweets creados: " + _item.size());			} else {
				System.out.println("No se encontraron tweets en la base de datos");
			}		} catch (Exception e) {
			System.err.println("Error cargando tweets para usuario registrado: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("=== Fin carga tweets para usuario registrado ===");
	}
	
	// Método para cargar tweets específicos de un usuario (para "Mis tweets") 
	// usando los métodos ORM definidos en BDPrincipal
	public void cargarTweetsDeUsuario(basededatos.Usuario_Registrado usuario) {
		if (usuario == null) {
			System.err.println("No se puede cargar tweets: usuario es null");
			return;
		}
		
		try {
			System.out.println("=== Cargando tweets específicos del usuario: " + usuario.getNickname() + " ===");
			
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Usar el método ORM definido para cargar solo los tweets de este usuario específico
			Tweet[] tweetsUsuario = bd.cargarTweetsPorUsuario(usuario.getId_usuario());
			
			if (tweetsUsuario != null && tweetsUsuario.length > 0) {
				System.out.println("Cargados " + tweetsUsuario.length + " tweets del usuario: " + usuario.getNickname());
				
				// Crear items específicos para los tweets del usuario
				for (Tweet tweet : tweetsUsuario) {
					if (tweet != null) {
						System.out.println("Creando item para tweet del usuario: " + tweet.getId_tweet() + " - " + tweet.getContenidoTweet());
						Listadetweetsyretweetsregistrado_item item = 
							new Listadetweetsyretweetsregistrado_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						this._item.add(item);
					}
				}
				System.out.println("Items de tweets del usuario creados: " + this._item.size());
			} else {
				System.out.println("El usuario " + usuario.getNickname() + " no tiene tweets publicados");
				// Opcional: agregar un mensaje indicativo
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets del usuario: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("=== Fin carga tweets del usuario ===");
	}
	
	// Método para cargar tweets que le gustan a un usuario específico
	public void cargarTweetsQueGustanAlUsuario(basededatos.Usuario_Registrado usuario) {
		if (usuario == null) {
			System.err.println("No se puede cargar tweets gustados: usuario es null");
			return;
		}
		
		try {
			System.out.println("=== Cargando tweets que le gustan al usuario: " + usuario.getNickname() + " ===");
			
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Usar el método ORM para cargar tweets que le gustan al usuario
			Tweet[] tweetsGustados = bd.cargarTweetsQueGustan(usuario.getId_usuario());
			
			if (tweetsGustados != null && tweetsGustados.length > 0) {
				System.out.println("Cargados " + tweetsGustados.length + " tweets que le gustan al usuario: " + usuario.getNickname());
				
				// Crear items específicos para los tweets gustados
				for (Tweet tweet : tweetsGustados) {
					if (tweet != null) {
						Listadetweetsyretweetsregistrado_item item = 
							new Listadetweetsyretweetsregistrado_item(this, tweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						this._item.add(item);
					}
				}
			} else {
				System.out.println("No hay tweets que le gusten al usuario: " + usuario.getNickname());
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets que gustan al usuario: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("=== Fin carga tweets gustados para usuario: " + usuario.getNickname() + " ===");
	}
	
	// Método para cargar retweets de un usuario específico
	public void cargarRetweetsDelUsuario(basededatos.Usuario_Registrado usuario) {
		if (usuario == null) {
			System.err.println("No se puede cargar retweets: usuario es null");
			return;
		}
		
		try {
			System.out.println("=== Cargando retweets del usuario: " + usuario.getNickname() + " ===");
			
			// Limpiar la lista actual
			this.getMainContainer().as(VerticalLayout.class).removeAll();
			this._item.clear();
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Usar el método ORM para cargar retweets del usuario
			Tweet[] retweets = bd.cargarRetweets(usuario.getId_usuario());
			
			if (retweets != null && retweets.length > 0) {
				System.out.println("Cargados " + retweets.length + " retweets del usuario: " + usuario.getNickname());
				
				// Crear items específicos para los retweets
				for (Tweet retweet : retweets) {
					if (retweet != null) {
						Listadetweetsyretweetsregistrado_item item = 
							new Listadetweetsyretweetsregistrado_item(this, retweet);
						this.getMainContainer().as(VerticalLayout.class).add(item);
						this._item.add(item);
					}
				}
			} else {
				System.out.println("No hay retweets del usuario: " + usuario.getNickname());
			}
		} catch (Exception e) {
			System.err.println("Error cargando retweets del usuario: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("=== Fin carga retweets para usuario: " + usuario.getNickname() + " ===");
	}
	
	
}