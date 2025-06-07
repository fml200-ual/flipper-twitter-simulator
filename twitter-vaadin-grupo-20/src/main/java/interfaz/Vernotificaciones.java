package interfaz;

import vistas.VistaVernotificaciones;

public class Vernotificaciones extends VistaVernotificaciones {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Vernotificacionesseguimiento _vernotificacionesseguimiento;
	public Vernotificacionesdemenciones _vernotificacionesdemenciones;
	public Vernotificacionesderetweets _vernotificacionesderetweets;

	public Vernotificaciones(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;
	}

	public void Vernotificacionesseguimiento() {
		throw new UnsupportedOperationException();
	}

	public void Vernotificacionesdemenciones() {
		throw new UnsupportedOperationException();
	}

	public void Vernotificacionesderetweets() {
		throw new UnsupportedOperationException();
	}
}