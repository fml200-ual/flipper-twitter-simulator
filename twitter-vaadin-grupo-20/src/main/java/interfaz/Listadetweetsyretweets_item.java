package interfaz;

import vistas.VistaListadetweetsyretweets_item;
public class Listadetweetsyretweets_item extends VistaListadetweetsyretweets_item {
	// private event _mostrarmstweets;
	public Listadetweetsyretweets _listadetweetsyretweets;
	
	public basededatos.Tweet t;

	public Listadetweetsyretweets_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super();
		this._listadetweetsyretweets = _listadetweetsyretweets;
	}
		// Constructor actualizado que acepta Tweet (para compatibilidad con clases hijas)
	public Listadetweetsyretweets_item(Listadetweetsyretweets _listadetweetsyretweets, basededatos.Tweet t) {
		super();
		this._listadetweetsyretweets = _listadetweetsyretweets;
		this.t = t;
		// La clase base no hace nada especial con el tweet, las subclases lo manejan
	}

	public void Mostrarmstweets() {
		throw new UnsupportedOperationException();
	}
}