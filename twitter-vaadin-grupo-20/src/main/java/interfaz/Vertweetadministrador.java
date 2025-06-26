package interfaz;

import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Vertweetadministrador extends TweetRetwetadministrador {
	public Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador;
	public Verperfiladministrador _verperfiladministrador;
	public basededatos.Tweet _tweet;

	public Vertweetadministrador(Listadetweetsyretweetsadministrador_item _listadetweetsyretweetsadministrador,
			Tweet tweet) {
		super();
		this._listadetweetsyretweetsadministrador = _listadetweetsyretweetsadministrador;
		this._tweet = tweet;

		this.getLayoutPublicacionCitada().setVisible(false);

		// Añadir botón de regreso
		volver();
		this.Listadecomentariosadministrador(_tweet);
		cargarDatosTweet();

		this.getAvatarDivPrincipal().addClickListener(event -> {
			Verperfiladministrador();
		});

		this.getBotonEliminarTweet().addClickListener(event -> {
			this.Eliminarpublicacin(_tweet);
		});
	}

	private void cargarDatosTweet() {
		if (_tweet == null)
			return;
		try {
			basededatos.BDPrincipal bd = new basededatos.BDPrincipal();

			// Contenido del tweet
			this.getPTextoPublicacion().setText(_tweet.getContenidoTweet() != null ? _tweet.getContenidoTweet() : "");

			// Datos del usuario
			if (_tweet.getPublicado_por() != null) {
				this.getSpanHandleUsuario().setText("@" + _tweet.getPublicado_por().getNickname());
				this.getSpanNombreUsuario().setText(_tweet.getPublicado_por().getNickname());
			}

			// Fecha de publicación
			if (_tweet.getFechaPublicacion() != null) {
				this.getSpanFecha().setText(_tweet.getFechaPublicacion().toString());
			}

			// Contadores
			int likesCount = bd.contarLikesTweet(_tweet.getORMID());
			int retweetsCount = bd.contarRetweetsTweet(_tweet.getORMID());
			int comentariosCount = bd.contarComentariosTweet(_tweet.getORMID());

			this.getSpanContadorMeGusta().setText(String.valueOf(likesCount));
			this.getSpanContadorRetweet().setText(String.valueOf(retweetsCount));
			this.getSpanContadorComentarios().setText(String.valueOf(comentariosCount));

		} catch (Exception e) {
			System.err.println("Error cargando datos del tweet: " + e.getMessage());
			// Valores por defecto en caso de error
			this.getPTextoPublicacion().setText("Error cargando tweet");
			this.getSpanHandleUsuario().setText("@usuario");
			this.getSpanFecha().setText("--");
			this.getSpanContadorMeGusta().setText("0");
			this.getSpanContadorRetweet().setText("0");
			this.getSpanContadorComentarios().setText("0");
		}
	}

	public void Verperfiladministrador() {
		_verperfiladministrador = new Verperfiladministrador(this, _tweet.getPublicado_por());
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verperfiladministrador);
	}
}