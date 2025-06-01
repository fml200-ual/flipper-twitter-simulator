package interfaz;

import vistas.VistaIntroducircdigodeverificacin;

public class Introducircdigodeverificacin extends VistaIntroducircdigodeverificacin{
	// private event _mensajedeerrordecdigo;
	// private event _reenviarcdigo;
	public Registrarse _registrarse;
	public ACT04SistemadeCorreo _aCT04SistemadeCorreo;

	public Introducircdigodeverificacin(Registrarse _registrarse) {
		super();
		this._registrarse = _registrarse;
	}

	public void Mensajedeerrordecdigo() {
		throw new UnsupportedOperationException();
	}

	public void Reenviarcdigo() {
		throw new UnsupportedOperationException();
	}
}