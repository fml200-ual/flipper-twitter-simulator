package interfaz;

import mds2.MainView.Pantalla;

public class Verretweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;
	
	// Objeto ORMPersistable para el retweet que se muestra
	public basededatos.Tweet t;

	public Verretweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador, basededatos.Tweet t) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;
		this.t = t;

		// Rellenar datos del retweet
		rellenarDatosRetweet();

		volver();
		this.Listadecomentariosadministrador();

		this.getAvatarDivPrincipal().addClickListener(event -> {
			Verperfiladministrador();
		});
	}
	
	// Constructor de compatibilidad temporal
	public Verretweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador) {
		this(_listadetweetsyretweetsadministrador, null);
	}
	
	private void rellenarDatosRetweet() {
		if (t != null) {
			// Rellenar contenido del retweet
			if (t.getContenidoTweet() != null) {
				// this.getSpanTextoPublicacion().setText(t.getContenidoTweet());
			}
			
			// Rellenar datos del usuario que hizo el retweet
			if (t.getPublicado_por() != null) {
				// this.getSpanNombreUsuario().setText(t.getPublicado_por().getNickname());
				// this.getSpanNickUsuario().setText("@" + t.getPublicado_por().getNickname());
			}
					// Si hay un tweet original retweeteado
			if (t.getTweet_retweeteado() != null) {
				// Mostrar contenido del tweet original
				// this.getSpanTextoTweetOriginal().setText(t.getTweet_retweeteado().getContenidoTweet());
			}
			
			// Rellenar fecha
			if (t.getFechaPublicacion() != null) {
				// this.getSpanFechaPublicacion().setText(t.getFechaPublicacion().toString());
			}
		}
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}