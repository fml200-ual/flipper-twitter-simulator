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
		// Crear una lista simulada de tweets para el administrador
		VerticalLayout container = this.getTweetsListContainer().as(VerticalLayout.class);

		// Limpiar contenedor por si acaso
		container.removeAll();

		// Añadir tweets y retweets de ejemplo alternando tipos
		for (int i = 0; i < 5; i++) {
			// Alternar entre tweets (false) y retweets (true)
			Listadetweetsyretweetsadministrador_item tweetItem = new Listadetweetsyretweetsadministrador_item(null);
			_tweets.add(tweetItem);
			container.add(tweetItem);
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
		Listadetweetsyretweetsadministrador_item nuevoTweet = new Listadetweetsyretweetsadministrador_item(null);
		_tweets.add(nuevoTweet);
		VerticalLayout container = this.getTweetsListContainer().as(VerticalLayout.class);
		container.add(nuevoTweet);
	}

	/**
	 * Añade un nuevo retweet a la lista
	 */
	public void añadirRetweet() {
		Listadetweetsyretweetsadministrador_item nuevoRetweet = new Listadetweetsyretweetsadministrador_item(null);
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