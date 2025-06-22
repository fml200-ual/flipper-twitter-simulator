package interfaz;

import mds2.MainView.Pantalla;

public class Verretweetpropio extends TweetRetweetpropio {
	public Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado;

	public Verretweetpropio(Listadetweetsyretweetsregistrado_item _listadetweetsyretweetsregistrado) {
		super();
		this._listadetweetsyretweetsregistrado = _listadetweetsyretweetsregistrado;

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