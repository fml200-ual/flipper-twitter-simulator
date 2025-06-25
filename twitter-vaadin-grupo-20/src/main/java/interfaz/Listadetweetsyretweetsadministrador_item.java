package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsadministrador_item extends Listadetweetsyretweets_item {
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;
	public basededatos.Tweet _tweet;

	public Listadetweetsyretweetsadministrador_item(Listadetweetsyretweets _listadetweetsyretweets,
			basededatos.Tweet tweet) {
		super(_listadetweetsyretweets);

		this._tweet = tweet;

		// Rellenar los datos del tweet en el item
		rellenarDatos(tweet);

		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			if (tweet.getTweet_retweeteado() != null) {
				// Es un retweet
				Verretweetadministrador(tweet);
			} else {
				// Es un tweet normal
				Vertweetadministrador(tweet);
			}
		});
	}

	private void rellenarDatos(basededatos.Tweet tweet) {
		if (tweet == null)
			return;

		try {
			// Obtener datos del usuario que publicó
			basededatos.Usuario_Registrado usuario = tweet.getPublicado_por();
			if (usuario != null) {
				// Establecer nickname del usuario (Usuario_Registrado extiende
				// Usuario_Autentificado)
				this.getNickName().setText("@" + usuario.getNickname());
				this.getUsername().setText(usuario.getNickname());
			}

			// Establecer contenido del tweet
			String contenido = "";
			if (tweet.getTweet_retweeteado() != null) {
				// Es un retweet
				contenido = "RT: " + (tweet.getTweet_retweeteado().getContenidoTweet() != null
						? tweet.getTweet_retweeteado().getContenidoTweet()
						: "");
				// Si el retweet tiene comentario adicional
				if (tweet.getContenidoTweet() != null && !tweet.getContenidoTweet().trim().isEmpty()) {
					contenido = tweet.getContenidoTweet() + "\n\n" + contenido;
				}
			} else {
				// Es un tweet original
				contenido = tweet.getContenidoTweet() != null ? tweet.getContenidoTweet() : "";
			}
			this.getContentText().setText(contenido);

			// Establecer fecha de publicación
			if (tweet.getFechaPublicacion() != null) {
				this.getDateLabel().setText(tweet.getFechaPublicacion().toString());
			}

			// Contar likes (me gusta)
			int likesCount = tweet.recibe_me_gusta != null ? tweet.recibe_me_gusta.size() : 0;
			this.getLikesCountLabel().setText(String.valueOf(likesCount));

			// Contar retweets
			int retweetsCount = tweet.retweets != null ? tweet.retweets.size() : 0;
			this.getXLabel().setText(String.valueOf(retweetsCount));

			// Contar comentarios
			int commentsCount = tweet.tiene != null ? tweet.tiene.size() : 0;
			this.getZLabel().setText(String.valueOf(commentsCount));

		} catch (Exception e) {
			// En caso de error, mostrar información básica
			this.getContentText().setText("Error al cargar tweet");
			this.getNickName().setText("Usuario desconocido");
		}
	}

	public void Vertweetadministrador(Tweet tweet) {
		_vertweetadministrador = new Vertweetadministrador(this, tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetadministrador);
	}

	public void Verretweetadministrador(Tweet tweet) {
		_verretweetadministrador = new Verretweetadministrador(this, tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetadministrador);
	}
}