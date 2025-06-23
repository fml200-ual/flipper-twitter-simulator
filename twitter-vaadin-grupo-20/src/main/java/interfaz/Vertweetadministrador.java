package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;
	
	// Objeto ORMPersistable para el tweet que se muestra
	public basededatos.Tweet t;

	public Vertweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador, basededatos.Tweet t) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;
		this.t = t;

		this.getLayoutPublicacionCitada().setVisible(false);

		// Rellenar datos del tweet
		rellenarDatosTweet();

		// Añadir botón de regreso
		volver();
		this.Listadecomentariosadministrador();

		this.getAvatarDivPrincipal().addClickListener(event -> {
			Verperfiladministrador();
		});
	}
	
	// Constructor de compatibilidad temporal
	public Vertweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador) {
		this(_listadetweetsyretweetsadministrador, null);
	}
		private void rellenarDatosTweet() {
		if (t != null) {
			// Rellenar contenido del tweet
			if (t.getContenidoTweet() != null) {
				// this.getSpanTextoPublicacion().setText(t.getContenidoTweet());
			}
			
			// Rellenar datos del usuario
			if (t.getPublicado_por() != null) {
				// this.getSpanNombreUsuario().setText(t.getPublicado_por().getNombre());
				// this.getSpanNickUsuario().setText("@" + t.getPublicado_por().getNickname());
			}
			
			// Rellenar fecha
			if (t.getFechaPublicacion() != null) {
				// this.getSpanFechaPublicacion().setText(t.getFechaPublicacion().toString());
			}
			
			// Rellenar contadores
			// this.getSpanContadorMeGusta().setText("" + t.recibe_me_gusta.size());
			// this.getSpanContadorRetweet().setText("" + t.retweets.size());
			// this.getSpanContadorComentarios().setText("" + t.tiene.size());
		}
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}