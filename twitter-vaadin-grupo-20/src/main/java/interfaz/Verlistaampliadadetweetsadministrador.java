package interfaz;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.Tweet;
import mds2.MainView.Pantalla;
import mds2.MainView.Usuario;
import vistas.VistaVerlistaampliadadetweetsadministrador;

public class Verlistaampliadadetweetsadministrador extends VistaVerlistaampliadadetweetsadministrador {
	public Listafijadetweetsadministrador _listafijadetweetsadministrador;
	public Listadetweetsyretweetsadministrador _listadetweetsyretweetsadministrador;

	public Verlistaampliadadetweetsadministrador(Listafijadetweetsadministrador _listafijadetweetsadministrador) {
		this._listafijadetweetsadministrador = _listafijadetweetsadministrador;
		// Agregar el botón de volver
		addBackButton();
		// Inicializar la lista de tweets al crear la vista
		Listadetweetsyretweetsadministrador();
	}

	protected void addBackButton() {
		Button backButton = new Button("← Volver", event -> {
			// Limpiar la vista principal
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(new ACT03Administrador(Pantalla.MainView));
		});
		backButton.getStyle().set("background-color", "#00FFFF");
		backButton.getStyle().set("color", "black");
		backButton.getStyle().set("border", "none");
		backButton.getStyle().set("padding", "10px 20px");
		backButton.getStyle().set("border-radius", "20px");
		backButton.getStyle().set("font-weight", "bold");
		backButton.getStyle().set("cursor", "pointer");
		backButton.getStyle().set("font-size", "16px");

		if (this.getBackButtonContainer() != null) {
			this.getBackButtonContainer().add(backButton);
		}
	}

	public void Listadetweetsyretweetsadministrador() {
		// Obtener la lista de tweets desde la lista fija
		Tweet[] tweets = Usuario.iAdministrador.cargarTweets();
		_listadetweetsyretweetsadministrador = new Listadetweetsyretweetsadministrador(this);

		for (Tweet tweet : tweets) {
			Listadetweetsyretweetsadministrador_item tweetItem = new Listadetweetsyretweetsadministrador_item(
					_listadetweetsyretweetsadministrador, tweet);
			_listadetweetsyretweetsadministrador.getMainContainer().as(VerticalLayout.class).add(tweetItem);
		}

		this.getTweetListContainer().as(VerticalLayout.class)
				.add(_listadetweetsyretweetsadministrador);
	}
}