package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaEditarcuenta;

public class Editarcuenta extends VistaEditarcuenta {
	// private event _eliminarcuenta;
	// private event _errordeedicin;
	public Verpropioperfil _verpropioperfil;

	public Editarcuenta(Verpropioperfil _verpropioperfil) {
		super();
		this._verpropioperfil = _verpropioperfil;

		this.getCancelarButton()
				.addClickListener(event -> Cancelar());
	}

	public void Eliminarcuenta() {

	}

	public void Errordeedicin() {
		throw new UnsupportedOperationException();
	}

	public void Comprobarnoduplicadodearrobaynick() {
		throw new UnsupportedOperationException();
	}

	public void Cancelar() {
		Pantalla.MainView.removeAll();
		Pantalla.MainView.add(Pantalla.Anterior);
	}
}