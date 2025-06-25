package interfaz;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import mds2.MainView.Pantalla;

public class Vertweetregistrado extends TweetRetweetajeno {
	private basededatos.Tweet tweet;

	public Vertweetregistrado(basededatos.Tweet tweet) {
		super(tweet);
		this.tweet = tweet;

		// Configurar elementos específicos para usuarios registrados
		this.getBotonEliminarTweet().setVisible(false);
		this.getContenedorPublicacionCitada().setVisible(false);

		// Cargar datos del tweet
		cargarDatosTweet();

		// Configurar lista de comentarios para usuarios registrados
		this.Listadecomentariosregistrado();

		// Configurar navegación y botones de interacción
		configurarNavegacion();
		configurarBotonesInteraccion();
		configurarRetweets();
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
	}

	private void configurarBotonesInteraccion() {
		// Configurar botones de interacción para usuarios registrados
		this.getIconoMeGusta().addClickListener(event -> darMeGusta());
		this.getIconoRetweet().addClickListener(event -> darRetweet());
		this.getIconoComentarios().addClickListener(event -> escribirComentario());
	}

	private void darMeGusta() {
		try {
			// Simulación de funcionalidad de me gusta
			// En una implementación real, aquí se llamaría al método correspondiente de BD
			System.out.println("Me gusta dado al tweet: " + tweet.getORMID());
			Notification.show("Me gusta procesado");

			// Actualizar contador (simulado)
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			int nuevosLikes = bd.contarLikesTweet(tweet.getORMID());
			this.getNumMegusta().setText(String.valueOf(nuevosLikes));

		} catch (Exception e) {
			System.err.println("Error en me gusta: " + e.getMessage());
			Notification.show("Error al procesar me gusta");
		}
	}

	private void darRetweet() {
		try {
			// Mostrar diálogo simple para retweet
			Dialog dialog = new Dialog();
			dialog.add("¿Deseas hacer retweet de este tweet?");
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
			// Simulación de funcionalidad de comentario
			// En una implementación real, aquí se abriría un diálogo para escribir
			// comentario
			System.out.println("Escribir comentario para tweet: " + tweet.getORMID());
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

	// Métodos adicionales que pueden ser llamados desde subclases o interfaces
	public void Darretweet() {
		darRetweet();
	}

	public void Escribircomentario() {
		escribirComentario();
	}
}