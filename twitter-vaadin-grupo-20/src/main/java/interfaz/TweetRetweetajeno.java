package interfaz;

import mds2.MainView.Pantalla;

public class TweetRetweetajeno extends TweetRetweetregistrado {
	// private event _darmegusta;
	// private event _eliminarmegusta;
	public Darretweet _darretweet;
	public Escribircomentario _escribircomentario;


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

	public void Darmegusta() {
		throw new UnsupportedOperationException();
	}

	public void Eliminarmegusta() {
		throw new UnsupportedOperationException();
	}
}