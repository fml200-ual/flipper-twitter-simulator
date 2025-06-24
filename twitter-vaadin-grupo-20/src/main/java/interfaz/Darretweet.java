package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class Darretweet extends Escribirtweetretweet {
	public TweetRetweetajeno _tweetRetweetajeno;
	public TweetRetweetpropio _tweetRetweetpropio;

	public Darretweet(TweetRetweetajeno _tweetRetweetajeno) {
		super();
		this._tweetRetweetajeno = _tweetRetweetajeno;

		// METODOLOGÍA ACTIVIDAD 12: Configurar funcionalidad de retweet
		configurarEventosRetweet();

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			// Puedes ser tweet o retweet
			Pantalla.MainView.add((Vertweetregistrado) _tweetRetweetajeno);
		});
	}

	public Darretweet(TweetRetweetpropio _tweetRetweetpropio) {
		super();
		this._tweetRetweetpropio = _tweetRetweetpropio;

		// METODOLOGÍA ACTIVIDAD 12: Configurar funcionalidad de retweet
		configurarEventosRetweet();

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			// Puedes ser tweet o retweet
			Pantalla.MainView.add((Vertweetpropio) _tweetRetweetpropio);
		});
	}
	
	// METODOLOGÍA ACTIVIDAD 12: Implementación siguiendo diagramas de secuencia
	private void configurarEventosRetweet() {
		// Configurar botón de publicar retweet
		this.getPublishButton().addClickListener(event -> {
			publicarRetweet();
		});
	}
	
	/**
	 * Publicar retweet siguiendo metodología de diagramas de secuencia
	 */
	private void publicarRetweet() {
		try {
			System.out.println("Iniciando publicación de retweet...");
			
			// Verificar estado del usuario antes de la operación
			MainView.verificarEstadoUsuario("publicarRetweet - antes");
			
			// Obtener el usuario actual de forma segura
			MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
			
			if (MainView.Usuario.usuarioRegistrado == null) {
				System.err.println("Error: No se pudo obtener el usuario actual para retweet");
				return;
			}
			
			int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
			
			// Obtener el tweet que se va a retwetear
			basededatos.Tweet tweetOriginal = null;
			if (_tweetRetweetajeno instanceof Vertweetregistrado) {
				tweetOriginal = ((Vertweetregistrado) _tweetRetweetajeno).t;
			} else if (_tweetRetweetpropio instanceof Vertweetpropio) {
				// tweetOriginal = ((Vertweetpropio) _tweetRetweetpropio).t; // Cuando esté disponible
			}
			
			if (tweetOriginal == null) {
				System.err.println("Error: No se pudo obtener el tweet original para retweet");
				return;
			}
					// Obtener contenido del retweet del campo de texto
			String contenidoRetweet = this.getTweetTextArea().getValue();
			if (contenidoRetweet == null) {
				contenidoRetweet = ""; // Retweet sin comentario adicional
			}
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Publicar retweet usando método ORM
			basededatos.Usuario_Registrado usuarioActualizado = bd.publicarRetweet(
				idUsuarioActual,
				tweetOriginal.getId_tweet(),
				contenidoRetweet,
				null, // URL documento
				null, // tipo documento
				new java.util.Date(),
				new String[0], // hashtags
				new String[0]  // menciones
			);
			
			if (usuarioActualizado != null) {
				System.out.println("Retweet publicado exitosamente");
				
				// Actualizar usuario actual en memoria
				MainView.Usuario.usuarioRegistrado = usuarioActualizado;
				
				// Volver a la vista anterior
				Pantalla.MainView.removeAll();
				if (_tweetRetweetajeno != null) {
					Pantalla.MainView.add((Vertweetregistrado) _tweetRetweetajeno);
				} else if (_tweetRetweetpropio != null) {
					Pantalla.MainView.add((Vertweetpropio) _tweetRetweetpropio);
				}
				
				// Verificar estado del usuario después de la operación
				MainView.verificarEstadoUsuario("publicarRetweet - después");
			} else {
				System.err.println("Error al publicar retweet");
			}
			
		} catch (Exception e) {
			System.err.println("Error durante la publicación del retweet: " + e.getMessage());
			e.printStackTrace();
		}
	}
}