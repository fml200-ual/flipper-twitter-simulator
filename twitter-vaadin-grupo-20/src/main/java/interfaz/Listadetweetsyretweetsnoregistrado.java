package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import basededatos.Tweet;
import mds2.MainView;

public class Listadetweetsyretweetsnoregistrado extends Listadetweetsyretweets {

	public Verhashtagnoregistrado _verhashtagnoregistrado;

	public Listadetweetsyretweetsnoregistrado(Verhashtagnoregistrado _verhashtagnoregistrado) {
		super(); // No llamar al inicializar del padre
		this._verhashtagnoregistrado = _verhashtagnoregistrado;
		inicializarTweetsNoRegistrado();
	}
	
	private void inicializarTweetsNoRegistrado() {
		try {
			// Cargar tweets reales de la base de datos
			Tweet[] tweets = ((basededatos.BDPrincipal) MainView.Usuario.usuarioNoRegistradoInterfaz).cargarTweets();
			
			if (tweets != null && tweets.length > 0) {
				// Crear items específicos para usuarios no registrados con datos reales
				for (int i = 0; i < Math.min(tweets.length, 10); i++) { // Máximo 10 tweets
					Listadetweetsyretweetsnoregistrado_item item = 
						new Listadetweetsyretweetsnoregistrado_item(this, tweets[i]);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					_item.add(item);
				}			} else {
				System.out.println("No se encontraron tweets en la base de datos");
			}		} catch (Exception e) {
			System.err.println("Error cargando tweets para usuario no registrado: " + e.getMessage());
			e.printStackTrace();
		}
	}
		// Método para cargar tweets de un hashtag específico
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
			
			// Cargar tweets que contienen este hashtag
			if (hashtag.pertenece != null && hashtag.pertenece.size() > 0) {
				Tweet[] tweets = hashtag.pertenece.toArray();
				
				if (agrupar) {
					// Mostrar como grupo agrupado
					crearVistaAgrupadaHashtag(hashtag, tweets);
				} else {
					// Mostrar tweets individuales (comportamiento original)
					for (Tweet tweet : tweets) {
						if (tweet != null) {
							Listadetweetsyretweetsnoregistrado_item item = 
								new Listadetweetsyretweetsnoregistrado_item(this, tweet);
							this.getMainContainer().as(VerticalLayout.class).add(item);
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
	 * Crear una vista agrupada para un hashtag para usuarios no registrados
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
					Listadetweetsyretweetsnoregistrado_item item = 
						new Listadetweetsyretweetsnoregistrado_item(this, tweets[i]);
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
								Listadetweetsyretweetsnoregistrado_item item = 
									new Listadetweetsyretweetsnoregistrado_item(this, tweet);
								contenedorTweets.add(item);
							}
						}
					}
				}
			});
			
			grupoHashtag.add(detallesExpandibles);
			this.getMainContainer().as(VerticalLayout.class).add(grupoHashtag);
			
		} catch (Exception e) {
			System.err.println("Error creando vista agrupada de hashtag para no registrado: " + e.getMessage());
			// Fallback: mostrar tweets individuales
			for (Tweet tweet : tweets) {
				if (tweet != null) {
					Listadetweetsyretweetsnoregistrado_item item = 
						new Listadetweetsyretweetsnoregistrado_item(this, tweet);
					this.getMainContainer().as(VerticalLayout.class).add(item);
					this._item.add(item);
				}
			}
		}
	}
}