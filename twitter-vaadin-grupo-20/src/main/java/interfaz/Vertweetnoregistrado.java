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
			
			// Rellenar contadores (solo visuales para no registrado)
			this.getNumMegusta().setText("" + t.recibe_me_gusta.size());
			this.getNumeroRetweets().setText("" + t.retweets.size());
			this.getNumeroRetweets1().setText("" + t.tiene.size()); // comentarios
		}
	}
}