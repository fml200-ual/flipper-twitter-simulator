package interfaz;

import vistas.VistaEditarcuenta;

public class Editarcuenta extends VistaEditarcuenta {
	// private event _eliminarcuenta;
	// private event _errordeedicin;
	public Verpropioperfil _verpropioperfil;

	public Editarcuenta(Verpropioperfil _verpropioperfil) {
		super();
		this._verpropioperfil = _verpropioperfil;
	}

	public void Eliminarcuenta() {
		throw new UnsupportedOperationException();
	}

	public void Errordeedicin() {
		throw new UnsupportedOperationException();
	}

	public void Comprobarnoduplicadodearrobaynick() {
		throw new UnsupportedOperationException();
	}
}