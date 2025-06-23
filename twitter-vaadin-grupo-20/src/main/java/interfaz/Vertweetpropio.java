package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetpropio extends TweetRetweetpropio {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;
	
	// Objeto ORMPersistable para el tweet que se muestra
	public basededatos.Tweet t;

	public Vertweetpropio(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado, basededatos.Tweet t) {
		super();
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.t = t;
		this.getContenedorPublicacionCitada().setVisible(false);
		this.getBotonEliminarTweet().setVisible(false);

		// Rellenar datos del tweet
		rellenarDatosTweet();

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
	public Vertweetpropio(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado) {
		this(_listadetweetsyretweetsregistrado, null);
	}
	
	private void rellenarDatosTweet() {
		if (t != null) {
			// Rellenar contenido del tweet
			if (t.getContenidoTweet() != null) {
				this.getTextoPublicacion().setText(t.getContenidoTweet());
			}
			
			// Rellenar datos del usuario
			if (t.getPublicado_por() != null) {
				// this.getNombreUsuario().setText(t.getPublicado_por().getNombre());
				this.getArrobaUsuario().setText("@" + t.getPublicado_por().getNickname());
			}
			
			// Rellenar fecha
			if (t.getFechaPublicacion() != null) {
				this.getFechaPublicacion().setText(t.getFechaPublicacion().toString());
			}
			
			// Rellenar contadores
			this.getNumMegusta().setText("" + t.recibe_me_gusta.size());
			this.getNumeroRetweets().setText("" + t.retweets.size());
			this.getNumeroRetweets1().setText("" + t.tiene.size()); // comentarios
		}
	}
}