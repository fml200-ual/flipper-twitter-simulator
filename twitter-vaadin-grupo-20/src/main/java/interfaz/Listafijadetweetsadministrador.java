package interfaz;

import vistas.VistaListafijadetweetsadministrador;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;

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
			basededatos.Tweet[] tweets = ((basededatos.BDPrincipal) mds2.MainView.Usuario.administradorInterfaz).cargarTweets();
					if (tweets != null && tweets.length > 0) {
				// Crear items con datos reales (máximo 10 tweets para la lista fija)
				for (int i = 0; i < Math.min(tweets.length, 10); i++) {
					Listadetweetsyretweetsadministrador_item tweetItem = 
						new Listadetweetsyretweetsadministrador_item((Listadetweetsyretweets)null, tweets[i]);
					_tweets.add(tweetItem);
					container.add(tweetItem);
				}
			} else {				// Fallback: crear algunos items vacíos si no hay datos
				for (int i = 0; i < 5; i++) {
					Listadetweetsyretweetsadministrador_item tweetItem = 
						new Listadetweetsyretweetsadministrador_item((Listadetweetsyretweets)null, null);
					_tweets.add(tweetItem);
					container.add(tweetItem);
				}
			}
		} catch (Exception e) {
			// En caso de error, crear items vacíos
			System.err.println("Error cargando tweets para administrador: " + e.getMessage());
			for (int i = 0; i < 5; i++) {
				Listadetweetsyretweetsadministrador_item tweetItem = 
					new Listadetweetsyretweetsadministrador_item((Listadetweetsyretweets)null, null);
				_tweets.add(tweetItem);
				container.add(tweetItem);
			}
		}
	}

	public void Verlistaampliadadetweetsadministrador() {
		_verlistaampliadadetweetsadministrador = new Verlistaampliadadetweetsadministrador(this);
		// Guardar referencia al administrador actual para la navegación de vuelta
		Pantalla.Anterior = this._aCT03Administrador;
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verlistaampliadadetweetsadministrador);
	}

	public Vector<Listadetweetsyretweetsadministrador_item> getTweets() {
		return _tweets;
	}
	/**
	 * Añade un nuevo tweet a la lista
	 */
	public void añadirTweet() {
		// Por defecto añadir como tweet (no retweet)
		Listadetweetsyretweetsadministrador_item nuevoTweet = new Listadetweetsyretweetsadministrador_item((Listadetweetsyretweets)null, null);
		_tweets.add(nuevoTweet);
		VerticalLayout container = this.getTweetsListContainer().as(VerticalLayout.class);
		container.add(nuevoTweet);
	}

	/**
	 * Añade un nuevo retweet a la lista
	 */
	public void añadirRetweet() {
		Listadetweetsyretweetsadministrador_item nuevoRetweet = new Listadetweetsyretweetsadministrador_item((Listadetweetsyretweets)null, null);
		_tweets.add(nuevoRetweet);
		VerticalLayout container = this.getTweetsListContainer().as(VerticalLayout.class);
		container.add(nuevoRetweet);
	}

	/**
	 * Limpia todos los tweets de la lista
	 */
	public void limpiarTweets() {
		_tweets.clear();
		VerticalLayout container = this.getTweetsListContainer().as(VerticalLayout.class);
		container.removeAll();
	}

	/**
	 * Recarga la lista de tweets
	 */
	public void recargarTweets() {
		limpiarTweets();
		cargarTweetsAdministrador();
	}
}