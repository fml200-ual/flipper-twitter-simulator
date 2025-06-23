package interfaz;

import mds2.MainView.Pantalla;

public class Verretweetregistrado extends TweetRetweetajeno {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;
	
	// Objeto ORMPersistable para el retweet que se muestra
	public basededatos.Retweet r;

	public Verretweetregistrado(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado, basededatos.Retweet r) {
		super();
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.r = r;

		// Rellenar datos del retweet
		rellenarDatosRetweet();

		this.Listadecomentariosregistrado();

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
	
	// Constructor de compatibilidad temporal
	public Verretweetregistrado(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado) {
		this(_listadetweetsyretweetsregistrado, null);
	}
	
	private void rellenarDatosRetweet() {
		if (r != null) {
			// Rellenar datos del tweet original
			if (r.getTweet() != null) {
				basededatos.Tweet tweetOriginal = r.getTweet();
				
				// Rellenar contenido del tweet original
				if (tweetOriginal.getContenidoTweet() != null) {
					this.getTextoPublicacion().setText(tweetOriginal.getContenidoTweet());
				}
				
				// Rellenar datos del usuario original
				if (tweetOriginal.getPublicado_por() != null) {
					// this.getNombreUsuario().setText(tweetOriginal.getPublicado_por().getNombre());
					this.getArrobaUsuario().setText("@" + tweetOriginal.getPublicado_por().getNickname());
				}
			}
			
			// Rellenar datos del usuario que hizo el retweet
			if (r.getUsuario_Registrado() != null) {
				// this.getNombreUsuarioRetweet().setText(r.getUsuario_Registrado().getNombre());
				// this.getArrobaUsuarioRetweet().setText("@" + r.getUsuario_Registrado().getNickname());
			}
			
			// Rellenar fecha del retweet
			if (r.getFechaPublicacion() != null) {
				this.getFechaPublicacion().setText(r.getFechaPublicacion().toString());
			}
		}
	}
}