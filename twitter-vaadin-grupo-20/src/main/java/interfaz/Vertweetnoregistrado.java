package interfaz;

import mds2.MainView.Pantalla;

public class Vertweetnoregistrado extends TweetRetweetnoregistrado {
	public Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado;

	public Vertweetnoregistrado(Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado) {
		super();
		this._listadetweetsyretweetsnoregistrado = _listadetweetsyretweetsnoregistrado;

		this.getBotonEliminarTweet().setVisible(false);
		this.getContenedorPublicacionCitada().setVisible(false);

		this.Listadecomentariosnoregistrado();

		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});
	}
}