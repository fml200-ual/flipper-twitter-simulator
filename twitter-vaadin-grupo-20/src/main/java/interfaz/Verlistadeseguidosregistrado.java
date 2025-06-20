package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistadeseguidosregistrado;

public class Verlistadeseguidosregistrado extends VistaVerlistadeseguidosregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;
	public Verlistadeseguidosregistrado(Verperfilregistrado verperfilregistrado) {
		this._verperfilregistrado = verperfilregistrado;
		setupBackButton();
	}

	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;
		setupBackButton();
	}

	public void Listadeusuarios() {
		throw new UnsupportedOperationException();
	}

	private void setupBackButton() {
		this.getBackButton().addClickListener(event -> goBack());
	}

	private void goBack() {
		// Volver al perfil propio del usuario registrado
		if (_verpropioperfil != null) {
			Pantalla.Anterior = Pantalla.MainView.getComponentAt(0);
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verpropioperfil);
		}
	}
}