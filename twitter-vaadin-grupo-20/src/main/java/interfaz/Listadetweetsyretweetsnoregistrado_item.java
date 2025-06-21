package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsnoregistrado_item extends Listadetweetsyretweets_item {
	public Verretweetnoregistrado _verretweetnoregistrado;
	public Vertweetnoregistrado _vertweetnoregistrado;

	public Listadetweetsyretweetsnoregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);

		// Luego hay que diferenciar si es un tweet o retweet
		this.getMainContainer().as(VerticalLayout.class)
				.addClickListener(event -> {
					// Por ahora solo se implementa para retweets
					// Luego se implementará para tweets
					Verretweetnoregistrado();
				});
	}

	public void Verretweetnoregistrado() {
		_verretweetnoregistrado = new Verretweetnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetnoregistrado);
	}

	public void Vertweetnoregistrado() {
		_vertweetnoregistrado = new Vertweetnoregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetnoregistrado);
	}
}