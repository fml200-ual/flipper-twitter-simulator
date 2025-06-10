package interfaz;

import vistas.VistaVerlistaseguidoresnoregistrado;

public class Verlistaseguidoresnoregistrado extends VistaVerlistaseguidoresnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;

	public Verlistaseguidoresnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		this._verperfilnoregistrado = verperfilnoregistrado;
	}

	public void Listadeusuarios() {
		throw new UnsupportedOperationException();
	}
}