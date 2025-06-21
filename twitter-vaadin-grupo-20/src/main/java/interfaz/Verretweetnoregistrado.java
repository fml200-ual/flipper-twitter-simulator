package interfaz;

import mds2.MainView.Pantalla;

public class Verretweetnoregistrado extends TweetRetweetnoregistrado {
	public Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado;

	public Verretweetnoregistrado(Listadetweetsyretweetsnoregistrado_item _listadetweetsyretweetsnoregistrado) {
		super();
		this._listadetweetsyretweetsnoregistrado = _listadetweetsyretweetsnoregistrado;
		this.getBotonEliminarTweet().setVisible(false);

		this.Listadecomentariosnoregistrado();

		this.getBotonVolver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT01UsuarioNoRegistrado(Pantalla.MainView));
		});
	}
}