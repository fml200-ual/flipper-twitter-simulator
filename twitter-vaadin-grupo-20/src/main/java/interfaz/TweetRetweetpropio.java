package interfaz;

import mds2.MainView.Pantalla;

public class TweetRetweetpropio extends TweetRetweetregistrado {
	public Darretweet _darretweet;
	public Escribircomentario _escribircomentario;

	public TweetRetweetpropio() {
		// Constructor logic if needed
	}

	public void Darretweet() {
		_darretweet = new Darretweet(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_darretweet);
	}

	public void Escribircomentario() {
		_escribircomentario = new Escribircomentario(this);
		Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(_escribircomentario);
	}
}