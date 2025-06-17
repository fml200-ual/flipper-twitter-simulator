package interfaz;

import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsadministrador_item extends Listadetweetsyretweets_item {

	public Vertweetadministrador _vertweetadministrador;
	public Verretweetadministrador _verretweetadministrador;

	// Variable para identificar si el item es un retweet
	private boolean esRetweet = false;

	public Listadetweetsyretweetsadministrador_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);
	}

	// Constructor que permite especificar si es retweet
	public Listadetweetsyretweetsadministrador_item(Listadetweetsyretweets _listadetweetsyretweets, boolean esRetweet) {
		super(_listadetweetsyretweets);
		this.esRetweet = esRetweet;
	}

	// Sobrescribir el método Vertweet de la clase padre
	@Override
	public void Vertweet() {
		if (esRetweet) {
			System.out.println("Verretweetadministrador");
			Verretweetadministrador();
		} else {
			System.out.println("Vertweetadministrador");
			Vertweetadministrador();
		}
	}

	// Método para configurar el tipo después de la creación
	public void setEsRetweet(boolean esRetweet) {
		this.esRetweet = esRetweet;
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