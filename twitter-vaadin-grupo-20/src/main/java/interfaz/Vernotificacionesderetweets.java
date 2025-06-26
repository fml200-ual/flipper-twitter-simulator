package interfaz;

import vistas.VistaVernotificacionesderetweets;

public class Vernotificacionesderetweets extends VistaVernotificacionesderetweets {
	public Vernotificaciones _vernotificaciones;
	public Listadenotificaciones _listadenotificaciones;

	public Vernotificacionesderetweets(Vernotificaciones _vernotificaciones) {
		super();
		this._vernotificaciones = _vernotificaciones;

		Listadenotificaciones();
	}

	public void Listadenotificaciones() {
		_listadenotificaciones = new Listadenotificaciones(this);
		// Solo crear el contenedor, las notificaciones reales se cargarán desde la BD
		this.getNotificationListRetweets().add(_listadenotificaciones);
	}
}