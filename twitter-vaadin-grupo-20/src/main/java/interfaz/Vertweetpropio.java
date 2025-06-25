package interfaz;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import mds2.MainView.Pantalla;

public class Vertweetpropio extends TweetRetweetpropio {
	private basededatos.Tweet tweet;

	public Vertweetpropio(basededatos.Tweet tweet) {
		super(tweet); // Pasar el tweet al constructor padre
		this.tweet = tweet;

		this.getContenedorPublicacionCitada().setVisible(false);
		this.getBotonEliminarTweet().setVisible(false);

		// Cargar datos del tweet
		cargarDatosTweet();

		// Configurar lista de comentarios para usuarios registrados
		this.Listadecomentariosregistrado();

		// Configurar navegación y botones de interacción
		configurarNavegacion();
		configurarBotonesInteraccion();
		configurarRetweets();
		configurarDocumentosMultimedia();
	}

	private void cargarDatosTweet() {
		if (tweet == null)
			return;

		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// Contenido del tweet
			this.getTextoPublicacion().setText(tweet.getContenidoTweet() != null ? tweet.getContenidoTweet() : "");

			// Datos del usuario
			if (tweet.getPublicado_por() != null) {
				this.getArrobaUsuario().setText("@" + tweet.getPublicado_por().getNickname());
				this.getNombreUsuario().setText(tweet.getPublicado_por().getNickname());
			}

			// Fecha de publicación
			if (tweet.getFechaPublicacion() != null) {
				this.getFechaPublicacion().setText(tweet.getFechaPublicacion().toString());
			}

			// Contadores
			int likesCount = bd.contarLikesTweet(tweet.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(tweet.getORMID());
			int comentariosCount = bd.contarComentariosTweet(tweet.getORMID());

			this.getNumMegusta().setText(String.valueOf(likesCount));
			this.getNumeroRetweets().setText(String.valueOf(retweetsCount));
			this.getNumeroRetweets1().setText(String.valueOf(comentariosCount));

		} catch (Exception e) {
			System.err.println("Error cargando datos del tweet: " + e.getMessage());
			// Valores por defecto en caso de error
			this.getTextoPublicacion().setText("Error cargando tweet");
			this.getArrobaUsuario().setText("@usuario");
			this.getFechaPublicacion().setText("--");
			this.getNumMegusta().setText("0");
			this.getNumeroRetweets().setText("0");
			this.getNumeroRetweets1().setText("0");
		}
	}

	private void configurarDocumentosMultimedia() {
		// Configurar documentos multimedia como en Ver_tweet_comun
		try {
			String tipoDocumento = null;
			basededatos.Documento doc = tweet.getDocumento();
			if (doc != null) {
				tipoDocumento = doc.getTipo();
			}

			if (tipoDocumento != null) {
				if (tipoDocumento.equals("IMAGEN")) {
					Image imgDocumento = new Image(tweet.getDocumento().getImagenVideoURL(), "Imagen del tweet");
					imgDocumento.setMaxWidth("400px");
					imgDocumento.setMaxHeight("200px");
					// Agregar al contenedor de contenido si existe
					this.getContenidoTweet().add(imgDocumento);
				} else if (tipoDocumento.equals("VIDEO")) {
					IFrame videoFrame = new IFrame(tweet.getDocumento().getImagenVideoURL());
					videoFrame.setMaxWidth("400px");
					videoFrame.setMaxHeight("200px");
					// Agregar al contenedor de contenido si existe
					this.getContenidoTweet().add(videoFrame);
				}
			}
		} catch (Exception e) {
			System.err.println("Error configurando documentos multimedia: " + e.getMessage());
		}
	}

	private void configurarRetweets() {
		// Si es un retweet con cita, mostrar información básica del tweet original
		if (tweet.getTweet_retweeteado() != null) {
			// Mostrar contenedor de publicación citada
			this.getContenedorPublicacionCitada().setVisible(true);
		}
	}

	private void configurarNavegacion() {
		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT02UsuarioRegistrado(Pantalla.MainView, null));
		});

		// Configurar click en avatar/nickname para ver perfil (como en Ver_tweet_comun)
		this.getArrobaUsuario().addClickListener(event -> {
			verPerfilUsuario();
		});
	}

	private void verPerfilUsuario() {
		try {
			if (tweet.getPublicado_por() != null) {
				// Navegar al perfil del usuario - usar la clase apropiada según el tipo de
				// usuario
				Verperfilregistrado verPerfil = new Verperfilregistrado(tweet.getPublicado_por());
				Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
				Pantalla.MainView.removeAll();
				Pantalla.MainView.add(verPerfil);
			}
		} catch (Exception e) {
			System.err.println("Error navegando al perfil: " + e.getMessage());
			Notification.show("Error al ver perfil de usuario");
		}
	}

	private void configurarBotonesInteraccion() {
		// Para tweets propios, el usuario no puede darse me gusta a sí mismo
		// pero sí puede hacer retweet y comentar

		// Habilitar retweet y comentarios
		this.getIconoRetweet().addClickListener(event -> darRetweet());
		this.getIconoComentarios().addClickListener(event -> escribirComentario());

		// Configurar botón de eliminar tweet
		this.getBotonEliminarTweet().addClickListener(event -> eliminarTweet());
	}

	private void darRetweet() {
		try {
			// Mostrar diálogo para retweet propio
			Dialog dialog = new Dialog();
			dialog.add("¿Deseas hacer retweet de tu propio tweet?");
			dialog.setWidth("300px");
			dialog.setHeight("150px");

			dialog.addOpenedChangeListener(event -> {
				if (!event.isOpened()) {
					// Actualizar contador después de cerrar el diálogo
					try {
						basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
						int nuevosRetweets = bd.contarRetweetsTweet(tweet.getORMID());
						this.getNumeroRetweets().setText(String.valueOf(nuevosRetweets));
					} catch (Exception e) {
						System.err.println("Error actualizando retweets: " + e.getMessage());
					}
				}
			});

			dialog.open();

		} catch (Exception e) {
			System.err.println("Error en retweet: " + e.getMessage());
			Notification.show("Error al procesar retweet");
		}
	}

	private void escribirComentario() {
		try {
			// Funcionalidad de comentario en tweet propio
			System.out.println("Escribir comentario en tweet propio: " + tweet.getORMID());
			Notification.show("Función de comentario activada");

			// Actualizar contador de comentarios
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			int nuevosComentarios = bd.contarComentariosTweet(tweet.getORMID());
			this.getNumeroRetweets1().setText(String.valueOf(nuevosComentarios));

		} catch (Exception e) {
			System.err.println("Error en comentario: " + e.getMessage());
			Notification.show("Error al procesar comentario");
		}
	}

	private void eliminarTweet() {
		try {
			// Mostrar diálogo de confirmación para eliminar
			Dialog dialog = new Dialog();
			dialog.add("¿Estás seguro de que deseas eliminar este tweet?");
			dialog.setWidth("350px");
			dialog.setHeight("150px");

			dialog.addOpenedChangeListener(event -> {
				if (!event.isOpened()) {
					// Aquí se implementaría la lógica de eliminación
					// Por ahora, solo mostramos confirmación
					try {
						basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
						bd.eliminarTweet(tweet.getORMID());

						Notification.show("Tweet eliminado");

						// Volver a la pantalla principal
						Pantalla.MainView.removeAll();
						Pantalla.MainView.add(new ACT02UsuarioRegistrado(Pantalla.MainView, null));

					} catch (Exception e) {
						System.err.println("Error eliminando tweet: " + e.getMessage());
						Notification.show("Error al eliminar tweet");
					}
				}
			});

			dialog.open();

		} catch (Exception e) {
			System.err.println("Error en eliminación: " + e.getMessage());
			Notification.show("Error al procesar eliminación");
		}
	}

	// Métodos adicionales que pueden ser llamados desde subclases o interfaces
	public void Darretweet() {
		darRetweet();
	}

	public void Escribircomentario() {
		escribirComentario();
	}
}