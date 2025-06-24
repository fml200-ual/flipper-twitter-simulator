package interfaz;

import vistas.VistaVernotificacionesseguimiento;

public class Vernotificacionesseguimiento extends VistaVernotificacionesseguimiento {
	public Vernotificaciones _vernotificaciones;
	public Listadenotificaciones _listadenotificaciones;

	public Vernotificacionesseguimiento(Vernotificaciones _vernotificaciones) {
		super();
		this._vernotificaciones = _vernotificaciones;

		Listadenotificaciones();
	}
	public void Listadenotificaciones() {
		_listadenotificaciones = new Listadenotificaciones(this);
		// Solo crear el contenedor, las notificaciones reales se cargarán desde la BD
		this.getNotificationListSeguimiento().add(_listadenotificaciones);
	}
}