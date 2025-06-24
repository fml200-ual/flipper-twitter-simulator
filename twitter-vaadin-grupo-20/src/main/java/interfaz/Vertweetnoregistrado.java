package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetnoregistrado extends TweetRetweetnoregistrado {
	public Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado;
	
	// Objeto ORMPersistable para el tweet que se muestra
	public basededatos.Tweet t;

	public Vertweetnoregistrado(Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado, basededatos.Tweet t) {
		super();
		this._listadetweetsyretweetsnoregistrado = _listadetweetsyretweetsnoregistrado;
		this.t = t;

		this.getBotonEliminarTweet().setVisible(false);
		this.getContenedorPublicacionCitada().setVisible(false);

		// Rellenar datos del tweet
		rellenarDatosTweet();

		this.Listadecomentariosnoregistrado();

		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});
	}
	
	// Constructor de compatibilidad temporal
	public Vertweetnoregistrado(Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado) {
		this(_listadetweetsyretweetsnoregistrado, null);
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
					// Rellenar contadores usando BD para evitar LazyInitializationException
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();
			
			// Contar likes usando método BD
			int likesCount = bd.contarLikesTweet(t.getORMID());
			this.getNumMegusta().setText("" + likesCount);
			
			// Contar retweets usando método BD
			int retweetsCount = bd.contarRetweetsTweet(t.getORMID());
			this.getNumeroRetweets().setText("" + retweetsCount);
			
			// Contar comentarios usando método BD
			int comentariosCount = bd.contarComentariosTweet(t.getORMID());
			this.getNumeroRetweets1().setText("" + comentariosCount);
			
		} catch (Exception e) {
			System.err.println("Error obteniendo contadores del tweet: " + e.getMessage());
			this.getNumMegusta().setText("0");
			this.getNumeroRetweets().setText("0");
			this.getNumeroRetweets1().setText("0");
		}
		}
	}
}