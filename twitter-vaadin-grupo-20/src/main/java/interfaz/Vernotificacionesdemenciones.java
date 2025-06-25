package interfaz;

import vistas.VistaVernotificacionesdemenciones;

public class Vernotificacionesdemenciones extends VistaVernotificacionesdemenciones {
	public Vernotificaciones _vernotificaciones;
	public Listadenotificaciones _listadenotificaciones;

	public Vernotificacionesdemenciones(Vernotificaciones _vernotificaciones) {
		super();
		this._vernotificaciones = _vernotificaciones;

		Listadenotificaciones();
	}
	public void Listadenotificaciones() {
		_listadenotificaciones = new Listadenotificaciones(this);
		// Solo crear el contenedor, las notificaciones reales se cargarán desde la BD
		this.getNotificationListMenciones().add(_listadenotificaciones);
	}
}