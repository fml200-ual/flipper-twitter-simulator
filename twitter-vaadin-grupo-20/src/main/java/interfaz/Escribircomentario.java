package interfaz;

import mds2.MainView;
import mds2.MainView.Pantalla;

public class Escribircomentario extends Escribirgeneral {
	public TweetRetweetajeno _tweetRetweetajeno;
	public TweetRetweetpropio _tweetRetweetpropio;
	public Escribircomentario(TweetRetweetajeno _tweetRetweetajeno) {
		super();
		this._tweetRetweetajeno = _tweetRetweetajeno;

		// METODOLOGÍA ACTIVIDAD 12: Configurar funcionalidad de comentario
		configurarEventosComentario();
		
		// Asegurar que el textarea esté habilitado y configurado
		configurarTextArea();

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			// Puedes ser tweet o retweet
			Pantalla.MainView.add((Vertweetregistrado) _tweetRetweetajeno);
		});
	}	public Escribircomentario(TweetRetweetpropio _tweetRetweetpropio) {
		super();
		this._tweetRetweetpropio = _tweetRetweetpropio;

		// METODOLOGÍA ACTIVIDAD 12: Configurar funcionalidad de comentario
		configurarEventosComentario();
		
		// Asegurar que el textarea esté habilitado y configurado
		configurarTextArea();

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			// Puedes ser tweet o retweet
			Pantalla.MainView.add((Vertweetpropio) _tweetRetweetpropio);
		});
	}
	
	public Escribircomentario(TweetRetweetregistrado _tweetRetweetregistrado) {
		super();
		// Para usuarios registrados genéricos, tratamos como ajeno
		if (_tweetRetweetregistrado instanceof TweetRetweetajeno) {
			this._tweetRetweetajeno = (TweetRetweetajeno) _tweetRetweetregistrado;
		} else if (_tweetRetweetregistrado instanceof TweetRetweetpropio) {
			this._tweetRetweetpropio = (TweetRetweetpropio) _tweetRetweetregistrado;
		} else {
			// Crear un TweetRetweetajeno temporal para casos genéricos
			this._tweetRetweetajeno = new TweetRetweetajeno(_tweetRetweetregistrado.getTweet());
		}
		// METODOLOGÍA ACTIVIDAD 12: Configurar funcionalidad de comentario
		configurarEventosComentario();
		
		// Asegurar que el textarea esté habilitado y configurado
		configurarTextArea();

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			if (_tweetRetweetpropio != null) {
				Pantalla.MainView.add((Vertweetpropio) _tweetRetweetpropio);
			} else {
				Pantalla.MainView.add((Vertweetregistrado) _tweetRetweetajeno);
			}
		});
	}
	
	// METODOLOGÍA ACTIVIDAD 12: Implementación siguiendo diagramas de secuencia
	private void configurarEventosComentario() {
		// Configurar botón de publicar comentario
		this.getPublishButton().addClickListener(event -> {
			publicarComentario();
		});
	}
	
	/**
	 * Publicar comentario siguiendo metodología de diagramas de secuencia
	 */
	private void publicarComentario() {
		try {
			System.out.println("Iniciando publicación de comentario...");
			
			// Verificar estado del usuario antes de la operación
			MainView.verificarEstadoUsuario("publicarComentario - antes");
			
			// Obtener el usuario actual de forma segura
			MainView.Usuario.usuarioRegistrado = MainView.obtenerUsuarioActual();
			
			if (MainView.Usuario.usuarioRegistrado == null) {
				System.err.println("Error: No se pudo obtener el usuario actual para comentario");
				return;
			}
			
			int idUsuarioActual = MainView.Usuario.usuarioRegistrado.getId_usuario();
					// Obtener el tweet en el que se va a comentar
			basededatos.Tweet tweetOriginal = null;
			if (_tweetRetweetajeno instanceof Vertweetregistrado) {
				tweetOriginal = ((Vertweetregistrado) _tweetRetweetajeno).getTweet();
			} else if (_tweetRetweetpropio instanceof Vertweetpropio) {
				tweetOriginal = ((Vertweetpropio) _tweetRetweetpropio).getTweet();
			}
			
			if (tweetOriginal == null) {
				System.err.println("Error: No se pudo obtener el tweet original para comentario");
				return;
			}
					// Obtener contenido del comentario del campo de texto
			String contenidoComentario = this.getTweetTextArea().getValue();
			if (contenidoComentario == null || contenidoComentario.trim().isEmpty()) {
				System.err.println("Error: El contenido del comentario no puede estar vacío");
				return;
			}
			
			// Crear instancia de la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Publicar comentario usando método ORM
			basededatos.Usuario_Registrado usuarioActualizado = bd.publicarComentario(
				idUsuarioActual,
				tweetOriginal.getId_tweet(),
				contenidoComentario,
				null, // URL documento
				new java.util.Date(),
				null  // tipo documento
			);
			
			if (usuarioActualizado != null) {
				System.out.println("Comentario publicado exitosamente");
				
				// Actualizar usuario actual en memoria
				MainView.Usuario.usuarioRegistrado = usuarioActualizado;
						// Volver a la vista anterior y actualizar los comentarios
				Pantalla.MainView.removeAll();
				if (_tweetRetweetajeno != null) {
					// Crear nueva instancia para que se recarguen los comentarios usando patrón directo
					Vertweetregistrado nuevaVista = new Vertweetregistrado(tweetOriginal);
					Pantalla.MainView.add(nuevaVista);
				} else if (_tweetRetweetpropio != null) {
					// Crear nueva instancia para recargar comentarios
					Vertweetpropio nuevaVista = new Vertweetpropio(tweetOriginal);
					Pantalla.MainView.add(nuevaVista);
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
	}
		/**
	 * Configurar el textarea para asegurar que sea editable
	 */
	private void configurarTextArea() {
		// Usar UI.getCurrent().access() para asegurar que se ejecute en el hilo de la UI
		com.vaadin.flow.component.UI.getCurrent().access(() -> {
			try {
				// Pequeño delay para asegurar que el componente esté completamente inicializado
				Thread.sleep(100);
				
				// Asegurar que el textarea esté habilitado y configurado correctamente
				if (this.getTweetTextArea() != null) {
					this.getTweetTextArea().setEnabled(true);
					this.getTweetTextArea().setReadOnly(false);
					this.getTweetTextArea().setPlaceholder("Escribe tu comentario...");
					this.getTweetTextArea().setMaxLength(280);
					this.getTweetTextArea().setValueChangeMode(com.vaadin.flow.data.value.ValueChangeMode.EAGER);
					
					// Asegurar que el componente sea visible
					this.getTweetTextArea().setVisible(true);
					
					// Limpiar cualquier valor previo
					this.getTweetTextArea().clear();
					
					// Configurar focus después de un pequeño delay
					com.vaadin.flow.component.UI.getCurrent().access(() -> {
						this.getTweetTextArea().focus();
					});
					
					System.out.println("TextArea para comentario configurado: enabled=" + this.getTweetTextArea().isEnabled() + 
									   ", readOnly=" + this.getTweetTextArea().isReadOnly() + 
									   ", visible=" + this.getTweetTextArea().isVisible());
				} else {
					System.err.println("Error: getTweetTextArea() devolvió null en Escribircomentario");
				}
			} catch (Exception e) {
				System.err.println("Error configurando textarea en comentario: " + e.getMessage());
				e.printStackTrace();
			}
		});
	}
}