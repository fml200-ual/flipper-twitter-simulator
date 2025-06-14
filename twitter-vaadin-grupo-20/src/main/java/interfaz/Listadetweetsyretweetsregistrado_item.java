package interfaz;

import mds2.MainView.Pantalla;

public class Listadetweetsyretweetsregistrado_item extends Listadetweetsyretweets_item {

	public Vertweetregistrado _vertweetregistrado;
	public Verretweetregistrado _verretweetregistrado;
	public Vertweetpropio _vertweetpropio;
	public Verretweetpropio _verretweetpropio;

	// Variable para identificar si el item es un retweet
	private boolean esRetweet = false;
	private boolean esPropio = false;

	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets) {
		super(_listadetweetsyretweets);
	}

	// Constructor que permite especificar si es retweet y si es propio
	public Listadetweetsyretweetsregistrado_item(Listadetweetsyretweets _listadetweetsyretweets,
			boolean esRetweet, boolean esPropio) {
		super(_listadetweetsyretweets);
		this.esRetweet = esRetweet;
		this.esPropio = esPropio;
	}

	// Sobrescribir el método Vertweet de la clase padre
	@Override
	public void Vertweet() {
		if (esPropio) {
			if (esRetweet) {
				Verretweetpropio();
			} else {
				Vertweetpropio();
			}
		} else {
			if (esRetweet) {
				Verretweetregistrado();
			} else {
				Vertweetregistrado();
			}
		}
	}

	// Métodos para configurar el tipo después de la creación
	public void setEsRetweet(boolean esRetweet) {
		this.esRetweet = esRetweet;
	}

	public void setEsPropio(boolean esPropio) {
		this.esPropio = esPropio;
	}

	public void Vertweetregistrado() {
		_vertweetregistrado = new Vertweetregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetregistrado);
	}

	public void Verretweetregistrado() {
		_verretweetregistrado = new Verretweetregistrado(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetregistrado);
	}

	public void Vertweetpropio() {
		_vertweetpropio = new Vertweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_vertweetpropio);
	}

	public void Verretweetpropio() {
		_verretweetpropio = new Verretweetpropio(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_verretweetpropio);
	}
}