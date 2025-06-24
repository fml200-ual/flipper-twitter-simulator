package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import mds2.MainView;
import basededatos.Tweet;

public class Listadetweetsyretweetsregistrado_item extends Listadetweetsyretweets_item {
	public Vertweetregistrado _vertweetregistrado;
	public Verretweetregistrado _verretweetregistrado;
	public Vertweetpropio _vertweetpropio;
	public Verretweetpropio _verretweetpropio;
	
	// Variables para controlar el estado de "me gusta"
	private boolean leGusta = false;
	private int contadorMeGusta = 0;	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet t) {
		super(_listadetweetsyretweets, t);
		
		// Poblar la interfaz con datos del tweet si están disponibles
		if (t != null) {
			System.out.println("Creando item para tweet ID: " + t.getId_tweet() + " - " + t.getContenidoTweet());
			actualizarDatosTweet();
			cargarEstadoMeGusta();
		} else {
			System.out.println("Creando item para tweet null");
			mostrarDatosPorDefecto();
		}
		// Configurar click listener para navegar según el tipo
		configurarEventos();
		// Configurar evento para el botón de "me gusta" (doble click)
		configurarEventoMeGusta();
		
		// Cargar contadores iniciales de todos los tipos
		cargarContadoresIniciales();
	}
	
	// Constructor de compatibilidad temporal
	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		this(_listadetweetsyretweets, null);
	}
	
	private void configurarEventos() {
		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// TODO: Determinar si el tweet es propio del usuario actual
			boolean esTweetPropio = false; // Por ahora asumimos que no es propio
			
			if (t != null && t.getTweet_retweeteado() != null) {
				// Es un retweet
				if (esTweetPropio) {
					Verretweetpropio();
				} else {
					Verretweetregistrado();
				}
			} else {
				// Es un tweet normal
				if (esTweetPropio) {
					Vertweetpropio();
				} else {
					Vertweetregistrado();
				}
			}
		});
	}	private void actualizarDatosTweet() {
		try {
			System.out.println("Actualizando datos del tweet ID: " + (t != null ? t.getId_tweet() : "null"));
			
			if (t != null) {
				// Contenido del tweet
				String contenido;
				if (t.getContenidoTweet() != null && !t.getContenidoTweet().trim().isEmpty()) {
					if (t.getTweet_retweeteado() != null) {
						contenido = "🔄 Retweeteado: " + t.getContenidoTweet();
					} else {
						contenido = t.getContenidoTweet();
					}
					System.out.println("Contenido del tweet: " + contenido);
				} else {
					contenido = "Tweet sin contenido";
				}
				
				// Información del usuario que publicó
				String usuario;
				String username;
				if (t.getPublicado_por() != null) {
					basededatos.Usuario_Registrado usuarioPublicador = t.getPublicado_por();
					System.out.println("Usuario que publicó: " + usuarioPublicador.getNickname());
					
					if (usuarioPublicador.getNickname() != null && !usuarioPublicador.getNickname().trim().isEmpty()) {
						usuario = usuarioPublicador.getNickname();
						username = "@" + usuarioPublicador.getNickname();
					} else {
						usuario = "Usuario";
						username = "@usuario";
					}
				} else {
					usuario = "Usuario";
					username = "@usuario";
				}
				
				// Fecha de publicación
				String fecha;
				if (t.getFechaPublicacion() != null) {
					fecha = formatearFecha(t.getFechaPublicacion());
					System.out.println("Fecha formateada: " + fecha);
				} else {
					fecha = "Fecha";
				}
				
				// Actualizar directamente usando los elementos
				try {
					this.getContentText().setText(contenido);
					this.getNickName().setText(usuario);
					this.getUsername().setText(username);
					this.getDateLabel().setText(fecha);
					System.out.println("Datos del tweet actualizados exitosamente");
				} catch (Exception e) {
					System.err.println("Error actualizando elementos UI: " + e.getMessage());
				}
			} else {
				System.out.println("Tweet es null, usando datos por defecto");
				this.getContentText().setText("Tweet sin contenido");
				this.getNickName().setText("Usuario");
				this.getUsername().setText("@usuario");
				this.getDateLabel().setText("Fecha");
			}
			
		} catch (Exception e) {
			System.err.println("Error actualizando datos del tweet: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Método de utilidad para formatear fechas
	private String formatearFecha(java.util.Date fecha) {
		try {
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
			return formatter.format(fecha);
		} catch (Exception e) {
			return "Fecha";
		}
	}
	
	private void mostrarDatosPorDefecto() {
		// Mostrar datos por defecto cuando no hay tweet
		// this.getContentText().setText("Contenido del tweet");
		// this.getNickName().setText("Usuario");
		// this.getUsername().setText("@usuario");
		// this.getDateLabel().setText("Ahora");
	}

	public void Vertweetregistrado() {
		_vertweetregistrado = new Vertweetregistrado(this, t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetregistrado);
	}	public void Verretweetregistrado() {
		// Pasar el tweet que es un retweet para mostrar información completa
		_verretweetregistrado = new Verretweetregistrado(this, t);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetregistrado);
	}

	public void Vertweetpropio() {
		// TODO: Pasar el tweet cuando se actualice el constructor
		_vertweetpropio = new Vertweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetpropio);
	}

	public void Verretweetpropio() {
		// TODO: Pasar el tweet cuando se actualice el constructor
		_verretweetpropio = new Verretweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetpropio);
	}	public void cargarEstadoMeGusta() {
		if (t != null) {
			try {
				// OPTIMIZACIÓN: Usar OptimizadorBD para reducir conexiones múltiples
				
				// Verificar estado del usuario antes de la operación
				MainView.verificarEstadoUsuario("cargarEstadoMeGusta - antes");
				
				// Obtener el usuario actual de forma segura
				MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
				
				if (MainView.Usuario.usuarioRegistrado == null) {
					System.err.println("Error: No se pudo obtener el usuario actual para me gusta");
					leGusta = false;
					contadorMeGusta = 0;
					return;
				}
				
				int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
				
				// OPTIMIZACIÓN: Usar instancia singleton para evitar múltiples conexiones
				basededatos.OptimizadorBD.ContadoresTweet contadores = 
					basededatos.OptimizadorBD.cargarContadoresTweet(t.getId_tweet(), idUsuarioActual);
				
				leGusta = contadores.leGustaUsuario;
				contadorMeGusta = contadores.meGusta;
				
				// Actualizar la UI
				actualizarUImeGusta();
				
				// Verificar estado del usuario después de la operación
				MainView.verificarEstadoUsuario("cargarEstadoMeGusta - después");
			} catch (Exception e) {
				System.err.println("Error cargando estado de me gusta: " + e.getMessage());
				leGusta = false;
				contadorMeGusta = 0;
			}
		}
	}private void configurarEventoMeGusta() {
		// Simplificar el evento de me gusta usando el click en todo el elemento
		// En lugar de buscar específicamente el heartIcon que puede no existir
		try {
			// Agregar un listener de doble click para "me gusta" 
			// (diferente del click simple que es para navegar)
			this.getElement().addEventListener("dblclick", e -> {
				// Doble click para dar/quitar me gusta
				toggleMeGusta();
			});
			
			System.out.println("Evento de me gusta configurado para tweet ID: " + (t != null ? t.getId_tweet() : "null"));
		} catch (Exception e) {
			System.err.println("Error configurando evento de me gusta: " + e.getMessage());
		}
	}	private void toggleMeGusta() {
		if (t != null) {
			try {
				System.out.println("Toggle me gusta activado para tweet ID: " + t.getId_tweet());
				
				// Obtener el usuario actual de forma segura
				MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
				
				if (MainView.Usuario.usuarioRegistrado == null) {
					System.err.println("Error: No se pudo obtener el usuario actual para me gusta");
					return;
				}
				
				int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
				
				// OPTIMIZACIÓN: Usar instancia singleton para evitar múltiples conexiones
				basededatos.BD_Tweet bdTweet = basededatos.OptimizadorBD.getBDTweetInstance();
				
				if (leGusta) {
					// Quitar "me gusta"
					System.out.println("Quitando me gusta del tweet " + t.getId_tweet());
					if (bdTweet.quitarMeGustaTweet(idUsuarioActual, t.getId_tweet())) {
						leGusta = false;
						contadorMeGusta--;
						actualizarUImeGusta();
						System.out.println("Me gusta quitado exitosamente");
					}
				} else {
					// Dar "me gusta"
					System.out.println("Dando me gusta al tweet " + t.getId_tweet());
					if (bdTweet.darMeGustaTweet(idUsuarioActual, t.getId_tweet())) {
						leGusta = true;
						contadorMeGusta++;
						actualizarUImeGusta();
						System.out.println("Me gusta dado exitosamente");
					}
				}
			} catch (Exception e) {
				System.err.println("Error al cambiar estado de me gusta: " + e.getMessage());
			}
		} else {
			System.err.println("No se puede dar me gusta: tweet es null");
		}
	}private void actualizarUImeGusta() {
		try {
			// Actualizar el contador de "me gusta" usando el elemento directamente
			this.getLikesCountLabel().setText(String.valueOf(contadorMeGusta));
			
			// Para el color del corazón, usar CSS classes en lugar de JavaScript
			try {
				// Aplicar CSS classes para cambiar el estilo del corazón
				if (leGusta) {
					this.addClassName("tweet-liked");
					this.removeClassName("tweet-not-liked");
				} else {
					this.addClassName("tweet-not-liked"); 
					this.removeClassName("tweet-liked");
				}
			} catch (Exception e) {
				System.err.println("Error aplicando clase CSS para me gusta: " + e.getMessage());
			}
			
		} catch (Exception e) {
			System.err.println("Error actualizando UI de me gusta: " + e.getMessage());
		}
	}
	
	// METODOLOGÍA ACTIVIDAD 12: Implementación de retweet directo
	/**
	 * Realizar retweet directamente desde el item siguiendo diagramas de secuencia
	 */
	public void realizarRetweet() {
		if (t != null) {
			try {
				System.out.println("Realizando retweet del tweet ID: " + t.getId_tweet());
				
				// Verificar estado del usuario antes de la operación
				MainView.verificarEstadoUsuario("realizarRetweet - antes");
				
				// Obtener el usuario actual de forma segura
				MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
				
				if (MainView.Usuario.usuarioRegistrado == null) {
					System.err.println("Error: No se pudo obtener el usuario actual para retweet");
					return;
				}
				
				int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
				
				// Crear instancia de la base de datos
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				
				// Realizar retweet usando método ORM
				basededatos.Usuario_Registrado usuarioActualizado = bd.darRetweet(
					idUsuarioActual, 
					t.getId_tweet(), 
					new java.util.Date()
				);
				
				if (usuarioActualizado != null) {
					System.out.println("Retweet realizado exitosamente");
					
					// Actualizar contadores y refrescar UI
					actualizarContadoresDelTweet();
					
					// Refrescar la lista de tweets
					if (_listadetweetsyretweets != null) {
						_listadetweetsyretweets.recargarTweets();
					}
					
					// Verificar estado del usuario después de la operación
					MainView.verificarEstadoUsuario("realizarRetweet - después");
				} else {
					System.err.println("Error al realizar retweet");
				}
				
			} catch (Exception e) {
				System.err.println("Error durante el retweet: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.err.println("No se puede hacer retweet: tweet es null");
		}
	}
	
	// METODOLOGÍA ACTIVIDAD 12: Implementación de comentario directo
	/**
	 * Publicar comentario directamente siguiendo diagramas de secuencia
	 */
	public void publicarComentario(String contenidoComentario) {
		if (t != null && contenidoComentario != null && !contenidoComentario.trim().isEmpty()) {
			try {
				System.out.println("Publicando comentario en tweet ID: " + t.getId_tweet());
				
				// Verificar estado del usuario antes de la operación
				MainView.verificarEstadoUsuario("publicarComentario - antes");
				
				// Obtener el usuario actual de forma segura
				MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
				
				if (MainView.Usuario.usuarioRegistrado == null) {
					System.err.println("Error: No se pudo obtener el usuario actual para comentario");
					return;
				}
				
				int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
				
				// Crear instancia de la base de datos
				basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
				
				// Publicar comentario usando método ORM
				basededatos.Usuario_Registrado usuarioActualizado = bd.publicarComentario(
					idUsuarioActual, 
					t.getId_tweet(), 
					contenidoComentario,
					null, // URL documento
					new java.util.Date(),
					null // tipo documento
				);
				
				if (usuarioActualizado != null) {
					System.out.println("Comentario publicado exitosamente");
					
					// Actualizar contadores y refrescar UI
					actualizarContadoresDelTweet();
					
					// Refrescar la lista de tweets
					if (_listadetweetsyretweets != null) {
						_listadetweetsyretweets.recargarTweets();
					}
					
					// Verificar estado del usuario después de la operación
					MainView.verificarEstadoUsuario("publicarComentario - después");
				} else {
					System.err.println("Error al publicar comentario");
				}
				
			} catch (Exception e) {
				System.err.println("Error durante la publicación del comentario: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.err.println("No se puede publicar comentario: tweet es null o contenido vacío");
		}
	}	/**
	 * Actualizar todos los contadores del tweet (me gusta, retweets, comentarios)
	 * OPTIMIZACIÓN: Usar métodos seguros de BD_Tweet para evitar LazyInitializationException
	 */
	public void actualizarContadoresDelTweet() {
		if (t != null) {
			try {
				// Usar métodos seguros de BD_Tweet para obtener contadores actualizados
				basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
				int numMeGusta = bdTweet.contarMeGustaTweet(t.getId_tweet());
				int numRetweets = bdTweet.contarRetweetsTweet(t.getId_tweet());
				int numComentarios = bdTweet.contarComentariosTweet(t.getId_tweet());
				
				// Actualizar variables locales
				contadorMeGusta = numMeGusta;
				
				// Actualizar la UI con los nuevos contadores
				this.getLikesCountLabel().setText(String.valueOf(numMeGusta));
				this.getXLabel().setText(String.valueOf(numRetweets));
				this.getZLabel().setText(String.valueOf(numComentarios));
				
				// Actualizar también el estado de "me gusta" si es necesario
				actualizarUImeGusta();
				
				System.out.println("Contadores actualizados para tweet " + t.getId_tweet() + 
					" - Likes: " + numMeGusta + ", Retweets: " + numRetweets + ", Comentarios: " + numComentarios);
				
			} catch (Exception e) {
				System.err.println("Error actualizando contadores del tweet: " + e.getMessage());
			}
		}
	}
		/**
	 * Cargar contadores iniciales de me gusta, retweets y comentarios
	 */
	private void cargarContadoresIniciales() {
		if (t != null) {
			try {
				// Cargar contadores usando métodos seguros de BD_Tweet
				basededatos.BD_Tweet bdTweet = new basededatos.BD_Tweet();
				int numMeGusta = bdTweet.contarMeGustaTweet(t.getId_tweet());
				int numRetweets = bdTweet.contarRetweetsTweet(t.getId_tweet());
				int numComentarios = bdTweet.contarComentariosTweet(t.getId_tweet());
				
				// Actualizar los contadores en la UI
				this.getLikesCountLabel().setText(String.valueOf(numMeGusta));
				this.getXLabel().setText(String.valueOf(numRetweets));
				this.getZLabel().setText(String.valueOf(numComentarios));
				
				System.out.println("Contadores iniciales cargados - Tweet ID: " + t.getId_tweet() + 
					" - Likes: " + numMeGusta + ", Retweets: " + numRetweets + ", Comentarios: " + numComentarios);
				
			} catch (Exception e) {
				System.err.println("Error cargando contadores iniciales: " + e.getMessage());
				// Valores por defecto en caso de error
				this.getLikesCountLabel().setText("0");
				this.getXLabel().setText("0");
				this.getZLabel().setText("0");
			}
		}
	}
}
