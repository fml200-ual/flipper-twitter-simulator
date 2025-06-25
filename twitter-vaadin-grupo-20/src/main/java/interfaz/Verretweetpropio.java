package interfaz;

import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Verretweetpropio extends TweetRetweetpropio {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;
	public basededatos.Tweet r;

	public Verretweetpropio(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado,
			basededatos.Tweet r) {
		super(r);
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.r = r;

		configurarEventos();
		rellenarDatosTweetRetweet();
	}

	private void configurarEventos() {

		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT02UsuarioRegistrado(Pantalla.MainView, null));
		});
		this.getIconoRetweet().addClickListener(event -> {
			this.Darretweet();
		});
		this.getIconoComentarios().addClickListener(event -> {
			this.Escribircomentario();
		});
	}

	private void rellenarDatosTweetRetweet() {
		if (r != null) {
			try {
				// TWEET EXTERIOR (RETWEET): Datos del usuario que hizo el retweet
				if (r.getPublicado_por() != null) {
					this.getArrobaUsuario().setText("@" + r.getPublicado_por().getNickname());
					this.getNombreUsuario().setText(r.getPublicado_por().getNickname());
				}

				// TWEET EXTERIOR: Fecha del retweet
				if (r.getFechaPublicacion() != null) {
					java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd MMM yyyy");
					this.getFechaPublicacion().setText(sdf.format(r.getFechaPublicacion()));
				}

				// TWEET EXTERIOR: Contenido del retweet
				// Para tweets que son retweets, mostrar el contenido del retweet si existe
				if (r.getContenidoTweet() != null && !r.getContenidoTweet().trim().isEmpty()) {
					this.getTextoPublicacion().setText(r.getContenidoTweet());
				} else {
					this.getTextoPublicacion().setText("Retweeteó:");
				}

				// TWEET INTERIOR (CITADO): Datos del tweet original
				if (r.getTweet_retweeteado() != null) {
					Tweet tweetOriginal = r.getTweet_retweeteado();

					// Tweet citado: Contenido del tweet original
					if (tweetOriginal.getContenidoTweet() != null) {
						this.getTextoPublicacionCitada().setText(tweetOriginal.getContenidoTweet());
					}

					// Tweet citado: Usuario original
					if (tweetOriginal.getPublicado_por() != null) {
						this.getArrobaUsuarioCitado().setText("@" + tweetOriginal.getPublicado_por().getNickname());
						this.getNombreUsuarioCitado().setText(tweetOriginal.getPublicado_por().getNickname());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error rellenando datos del tweet retweet: " + e.getMessage());
			}
		}
	}
}