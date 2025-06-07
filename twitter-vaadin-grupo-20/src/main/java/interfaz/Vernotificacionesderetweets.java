package interfaz;

import vistas.VistaVernotificacionesderetweets;

public class Vernotificacionesderetweets extends VistaVernotificacionesderetweets {
	public Vernotificaciones _vernotificaciones;
	public Listadenotificaciones _listadenotificaciones;

	public Vernotificacionesderetweets(Vernotificaciones _vernotificaciones) {
		super();
		this._vernotificaciones = _vernotificaciones;
	}

	public void Listadenotificaciones() {
		throw new UnsupportedOperationException();
	}
}