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
				
				// Configurar imagen de perfil del autor del tweet
				configurarImagenPerfilTweet(tweet.getPublicado_por());
			} else {
				this.getNickName().setText("Usuario desconocido");
				this.getUsername().setText("@desconocido");
				configurarImagenPerfilPorDefecto();
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

	private void configurarImagenPerfilTweet(basededatos.Usuario_Registrado usuario) {
		try {
			if (usuario != null && usuario.getFotoPerfilURL() != null && 
				!usuario.getFotoPerfilURL().trim().isEmpty() && 
				!usuario.getFotoPerfilURL().equals("default-profile.jpg")) {
				
				// Configurar como imagen de perfil real usando CSS background
				this.getAvatarIcon().getStyle()
					.set("background-image", "url('" + usuario.getFotoPerfilURL() + "')")
					.set("background-size", "cover")
					.set("background-position", "center")
					.set("background-repeat", "no-repeat")
					.set("border-radius", "50%")
					.set("border", "2px solid #00FFFF")
					.set("width", "32px")
					.set("height", "32px");
				
				// Ocultar completamente el icono de vaadin
				this.getAvatarIcon().removeAttribute("icon");
				this.getAvatarIcon().setProperty("innerHTML", "");
				this.getAvatarIcon().getStyle()
					.set("--vaadin-icon-width", "0px")
					.set("--vaadin-icon-height", "0px")
					.set("color", "transparent");
				
				System.out.println("Imagen de perfil configurada para tweet de: " + usuario.getNickname());
			} else {
				configurarImagenPerfilPorDefecto();
			}
		} catch (Exception e) {
			System.err.println("Error configurando imagen de perfil en tweet: " + e.getMessage());
			configurarImagenPerfilPorDefecto();
		}
	}

	private void configurarImagenPerfilPorDefecto() {
		// Usar icono por defecto
		this.getAvatarIcon().setAttribute("icon", "vaadin:user");
		this.getAvatarIcon().getStyle()
			.set("background-image", "none")
			.set("color", "#00FFFF")
			.set("border-radius", "50%")
			.set("border", "2px solid #00FFFF")
			.set("width", "32px")
			.set("height", "32px");
		this.getAvatarIcon().getStyle()
			.set("--vaadin-icon-width", "20px")
			.set("--vaadin-icon-height", "20px");
	}

	public void Mostrarmstweets() {
		throw new UnsupportedOperationException();
	}
}