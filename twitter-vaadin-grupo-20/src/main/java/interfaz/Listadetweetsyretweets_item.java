package interfaz;

import basededatos.Tweet;
import vistas.VistaListadetweetsyretweets_item;

public class Listadetweetsyretweets_item extends VistaListadetweetsyretweets_item {
	// private event _mostrarmstweets;
	public Listadetweetsyretweets _listadetweetsyretweets;

	public Listadetweetsyretweets_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet tweet) {
		super();
		this._listadetweetsyretweets = _listadetweetsyretweets;

		rellenarDatosTweet(tweet);
	}

	// TODO: COMPROBAR PARA BORRAR
	public Listadetweetsyretweets_item(Listadetweetsyretweets _listadetweetsyretweets2) {
		// TODO Auto-generated constructor stub
	}

	private void rellenarDatosTweet(Tweet tweet) {
		if (tweet == null)
			return;

		try {
			// Establecer el nickname del usuario
			if (tweet.getPublicado_por() != null) {
				this.getNickName().setText(tweet.getPublicado_por().getNickname());
				this.getUsername().setText("@" + tweet.getPublicado_por().getNickname());
			} else {
				this.getNickName().setText("Usuario desconocido");
				this.getUsername().setText("@desconocido");
			}

			// Establecer el contenido del tweet
			String contenido = "";
			if (tweet.getTweet_retweeteado() != null) {
				// Es un retweet - mostrar contenido del tweet original
				Tweet tweetOriginal = tweet.getTweet_retweeteado();
				contenido = tweetOriginal.getContenidoTweet() != null ? tweetOriginal.getContenidoTweet() : "";

				// Si el retweet tiene comentario adicional, agregarlo
				if (tweet.getContenidoTweet() != null && !tweet.getContenidoTweet().trim().isEmpty()) {
					contenido = tweet.getContenidoTweet() + " RT: " + contenido;
				} else {
					contenido = "RT: " + contenido;
				}
			} else {
				// Es un tweet original
				contenido = tweet.getContenidoTweet() != null ? tweet.getContenidoTweet() : "";
			}
			this.getContentText().setText(contenido);

			// Establecer la fecha de publicación
			if (tweet.getFechaPublicacion() != null) {
				// Formatear la fecha de manera más legible
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy");
				this.getDateLabel().setText(sdf.format(tweet.getFechaPublicacion()));
			} else {
				this.getDateLabel().setText("--");
			}

			// Obtener contadores desde la base de datos
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// Contar likes - usar el tweet original si es un retweet
			Tweet tweetParaContadores = tweet.getTweet_retweeteado() != null ? tweet.getTweet_retweeteado() : tweet;
			int likesCount = bd.contarLikesTweet(tweetParaContadores.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(tweetParaContadores.getORMID());
			int comentariosCount = bd.contarComentariosTweet(tweetParaContadores.getORMID());

			// Establecer los contadores
			this.getLikesCountLabel().setText(String.valueOf(likesCount));
			this.getXLabel().setText(String.valueOf(retweetsCount));
			this.getZLabel().setText(String.valueOf(comentariosCount));

		} catch (Exception e) {
			System.err.println("Error rellenando datos del tweet: " + e.getMessage());

			// Valores por defecto en caso de error
			this.getNickName().setText("Error");
			this.getUsername().setText("@error");
			this.getContentText().setText("Error cargando tweet");
			this.getDateLabel().setText("--");
			this.getLikesCountLabel().setText("0");
			this.getXLabel().setText("0");
			this.getZLabel().setText("0");
		}
	}

	public void Mostrarmstweets() {
		throw new UnsupportedOperationException();
	}
}