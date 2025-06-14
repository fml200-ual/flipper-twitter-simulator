package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaListadetweetsyretweets_item;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Listadetweetsyretweets_item extends VistaListadetweetsyretweets_item {
	// private event _mostrarmstweets;
	public Listadetweetsyretweets _listadetweetsyretweets;

	public Listadetweetsyretweets_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super();
		this._listadetweetsyretweets = _listadetweetsyretweets;

		this.getMainContainer().as(VerticalLayout.class)
				.addClickListener(event -> {
					Vertweet();
				});
	}

	public void Mostrarmstweets() {
		throw new UnsupportedOperationException();
	}

	public void Vertweet() {
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(new Vertweetregistrado(null));
	}
}