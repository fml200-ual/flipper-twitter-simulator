package interfaz;

import vistas.VistaVerlistadeseguidosregistrado;

public class Verlistadeseguidosregistrado extends VistaVerlistadeseguidosregistrado {
	public Verperfilregistrado _verperfilregistrado;
	public Verpropioperfil _verpropioperfil;
	public Listadeusuarios _listadeusuarios;

	public Verlistadeseguidosregistrado(Verperfilregistrado verperfilregistrado) {
		this._verperfilregistrado = verperfilregistrado;
	}

	public Verlistadeseguidosregistrado(Verpropioperfil verpropioperfil) {
		this._verpropioperfil = verpropioperfil;
	}

	public void Listadeusuarios() {
		throw new UnsupportedOperationException();
	}
}