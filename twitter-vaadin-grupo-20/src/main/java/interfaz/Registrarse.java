package interfaz;

import vistas.VistaRegistrarse;

public class Registrarse extends VistaRegistrarse {
	// private event _mensajedeerrorregistro;
	public ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado;
	public Iniciarsesin _iniciarsesin;
	public Introducircdigodeverificacin _introducircdigodeverificacin;
	public ACT05Google _aCT05Google;
	public IniciarsesinconGoogle _iniciarsesinconGoogle;

	public Registrarse(ACT01UsuarioNoRegistrado _aCT01UsuarioNoRegistrado) {
		super();
		this._aCT01UsuarioNoRegistrado = _aCT01UsuarioNoRegistrado;
	}

	public Registrarse(Iniciarsesin _iniciarsesin) {
		super();
		this._iniciarsesin = _iniciarsesin;
	}

	public void Mensajedeerrorregistro() {
		throw new UnsupportedOperationException();
	}

	public void Introducircdigodeverificacin() {
		throw new UnsupportedOperationException();
	}

	public void Comprobarnoduplicadodedatos() {
		throw new UnsupportedOperationException();
	}

	public void IniciarsesinconGoogle() {
		throw new UnsupportedOperationException();
	}
}