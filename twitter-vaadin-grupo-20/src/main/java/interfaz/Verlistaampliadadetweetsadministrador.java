package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.button.Button;
import mds2.MainView.Pantalla;
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
			// Restaurar la vista anterior (ACT03Administrador)
			if (Pantalla.Anterior instanceof ACT03Administrador) {
				ACT03Administrador admin = (ACT03Administrador) Pantalla.Anterior;
				// Asegurarse de que la lista de tweets se recargue correctamente
				admin._listafijadetweetsadministrador.recargarTweets();
				Pantalla.MainView.add(admin);
			} else {
				Pantalla.MainView.add(Pantalla.Anterior);
			}
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
		Vector<Listadetweetsyretweetsadministrador_item> _tweets = _listafijadetweetsadministrador._tweets;

		// Limpiar el contenedor antes de agregar nuevos tweets
		this.getTweetListContainer().removeAllChildren();

		// Crear y agregar cada tweet al contenedor
		for (int i = 0; i < _tweets.size(); i++) {
			// Usar el item existente de la lista fija que ya tiene la configuración
			// correcta
			Listadetweetsyretweetsadministrador_item tweetItem = _tweets.get(i);
			// Agregar el componente al contenedor de tweets
			this.getTweetListContainer().appendChild(tweetItem.getElement());
		}
	}
}