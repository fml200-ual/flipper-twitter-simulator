package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Tweet;
import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsnoregistrado_item extends Listadetweetsyretweets_item {
	public Verretweetnoregistrado _verretweetnoregistrado;
	public Vertweetnoregistrado _vertweetnoregistrado;

	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets, Tweet tweet) {
		super(_listadetweetsyretweets, tweet);

		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// Luego hay que diferenciar entre tweet y retweet. Tambien si es propio o no
			if (tweet.getTweet_retweeteado() != null) {
				// Es un retweet
				Verretweetnoregistrado(tweet);
			} else {
				// Es un tweet
				Vertweetnoregistrado(tweet);
			}
		});
	}

	public void Verretweetnoregistrado(Tweet tweet) {
		_verretweetnoregistrado = new Verretweetnoregistrado(this, tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetnoregistrado);
	}

	public void Vertweetnoregistrado(Tweet tweet) {
		_vertweetnoregistrado = new Vertweetnoregistrado(this, tweet);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetnoregistrado);
	}
}