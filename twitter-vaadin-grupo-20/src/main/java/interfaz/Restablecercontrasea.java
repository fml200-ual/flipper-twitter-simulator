package interfaz;

import vistas.VistaRestablecercontrasea;

public class Restablecercontrasea extends VistaRestablecercontrasea{
	// private event _mensajedeerrorrestablecimiento;
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;

	public Restablecercontrasea(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
	}

	public void Mensajedeerrorrestablecimiento() {
		throw new UnsupportedOperationException();
	}

	public void Validardatos() {
		throw new UnsupportedOperationException();
	}
}