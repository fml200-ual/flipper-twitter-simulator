package interfaz;

public class Listafijadeusuariosregistrado extends Listafijadeusuarios {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Verperfilregistrado _verperfilregistrado;
	public Perspectivabloqueado _perspectivabloqueado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;

	public Listafijadeusuariosregistrado(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
	}

	public void Verperfilregistrado() {
		throw new UnsupportedOperationException();
	}

	public void Perspectivabloqueado() {
		throw new UnsupportedOperationException();
	}

	public void Verlistaampliadadeusuariosregistrado() {
		throw new UnsupportedOperationException();
	}
}