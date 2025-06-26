package interfaz;

import vistas.VistaListafijadetweetsadministrador;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import mds2.MainView.Usuario;

import java.util.Vector;

public class Listafijadetweetsadministrador extends VistaListafijadetweetsadministrador {
	public ACT03Administrador _aCT03Administrador;
	public Verlistaampliadadetweetsadministrador _verlistaampliadadetweetsadministrador;
	public Vector<Listadetweetsyretweetsadministrador_item> _tweets = new Vector<Listadetweetsyretweetsadministrador_item>();

	public Listafijadetweetsadministrador(ACT03Administrador _aCT03Administrador) {
		super();
		this._aCT03Administrador = _aCT03Administrador;

		// Inicializar la lista de tweets
		cargarTweetsAdministrador();
	}

	public void cargarTweetsAdministrador() {
		// Cargar tweets reales de la base de datos
		VerticalLayout container = this.getTweetsListContainer().as(VerticalLayout.class);

		// Limpiar contenedor por si acaso
		container.removeAll();
		_tweets.clear();

		try {
			// Cargar tweets reales de la base de datos
			basededatos.Tweet[] tweets = Usuario.iAdministrador.cargarTweets();
			Listadetweetsyretweetsadministrador lista = new Listadetweetsyretweetsadministrador(
					_verlistaampliadadetweetsadministrador);
			if (tweets != null && tweets.length > 0) {
				for (int i = 0; i < Math.min(tweets.length, 5); i++) {
					Listadetweetsyretweetsadministrador_item tweetItem = new Listadetweetsyretweetsadministrador_item(
							lista, tweets[i]);
					_tweets.add(tweetItem);
					container.add(tweetItem);
				}
			} else {
				System.out.println("No se encontraron tweets en la base de datos para administrador");
			}
		} catch (Exception e) {
			System.err.println("Error cargando tweets para administrador: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void Verlistaampliadadetweetsadministrador() {
		_verlistaampliadadetweetsadministrador = new Verlistaampliadadetweetsadministrador(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaampliadadetweetsadministrador);
	}
}