package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Tweet;
import basededatos.Usuario_Registrado;
import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsregistrado_item extends Listadetweetsyretweets_item {
	public Vertweetregistrado _vertweetregistrado;
	public Verretweetregistrado _verretweetregistrado;
	public Vertweetpropio _vertweetpropio;
	public Verretweetpropio _verretweetpropio;
	public basededatos.Tweet _tweet;

	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);

		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// Luego hay que diferenciar entre tweet y retweet. Tambien si es propio o no
			// Llamar a la vista de ver tweet registrado por defecto
			Vertweetregistrado();
		});
	}

	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets,
			Tweet tweet) {
		super(_listadetweetsyretweets, tweet);
		this._tweet = tweet;
		Usuario_Registrado usuario_Registrado = mds2.MainView.obtenerUsuarioActual();

		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// Luego hay que diferenciar entre tweet y retweet. Tambien si es propio o no
			if (tweet.getTweet_retweeteado() != null) {
				// Es un retweet
				if (usuario_Registrado.getId_usuario() == tweet.getPublicado_por().getId_usuario()) {
					Verretweetpropio();
				} else {
					Verretweetregistrado();
				}
			} else {
				// Es un tweet
				if (usuario_Registrado.getId_usuario() == tweet.getPublicado_por().getId_usuario()) {
					Vertweetpropio();
				} else {
					Vertweetregistrado();
				}
			}
		});

	}

	public void Vertweetregistrado() {
		_vertweetregistrado = new Vertweetregistrado(_tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetregistrado);
	}

	public void Verretweetregistrado() {
		_verretweetregistrado = new Verretweetregistrado(this, _tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetregistrado);
	}

	public void Vertweetpropio() {
		_vertweetpropio = new Vertweetpropio(_tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetpropio);
	}

	public void Verretweetpropio() {
		_verretweetpropio = new Verretweetpropio(this, _tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetpropio);
	}
}