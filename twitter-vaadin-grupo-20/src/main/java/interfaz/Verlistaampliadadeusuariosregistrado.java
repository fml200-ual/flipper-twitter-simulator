package interfaz;

public class Verlistaampliadadeusuariosregistrado extends Verlistaampliadadeusuarios {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Perspectivabloqueado _perspectivabloqueado;
	public Verperfilregistrado _verperfilregistrado;

	public Verlistaampliadadeusuariosregistrado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;
	}

	public void Perspectivabloqueado() {
		throw new UnsupportedOperationException();
	}

	public void Verperfilregistrado() {
		throw new UnsupportedOperationException();
	}
}