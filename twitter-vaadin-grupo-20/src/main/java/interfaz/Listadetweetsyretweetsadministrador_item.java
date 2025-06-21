package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsadministrador_item extends Listadetweetsyretweets_item {
	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	public Listadetweetsyretweetsadministrador_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);

		this.getMainContainer().as(VerticalLayout.class).addClickListener(event -> {
			// Luego hay que diferenciar entre tweet y retweet
			// Llamar a la vista de ver tweet administrador por defecto
			Vertweetadministrador();
		});
	}

	public void Vertweetadministrador() {
		_vertweetadministrador = new Vertweetadministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetadministrador);
	}

	public void Verretweetadministrador() {
		_verretweetadministrador = new Verretweetadministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetadministrador);
	}
}