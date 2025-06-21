package interfaz;

import mds2.MainView.Pantalla;

public class Escribirtweet extends Escribirtweetretweet {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;

	public Escribirtweet(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		this.getCloseButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT02UsuarioRegistrado);
		});
	}

}