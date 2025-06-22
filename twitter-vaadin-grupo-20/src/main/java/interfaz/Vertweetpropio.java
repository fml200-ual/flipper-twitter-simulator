package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetpropio extends TweetRetweetpropio {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;

	public Vertweetpropio(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado) {
		super();
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;
		this.getContenedorPublicacionCitada().setVisible(false);
		this.getBotonEliminarTweet().setVisible(false);

		this.Listadecomentariosregistrado();

		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT02UsuarioRegistrado(Pantalla.MainView));
		});
		this.getIconoRetweet().addClickListener(event -> {
			this.Darretweet();
		});
		this.getIconoComentarios().addClickListener(event -> {
			this.Escribircomentario();
		});
	}
}