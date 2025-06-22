package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
		for (int i = 0; i < 5; i++) {
			_listadenotificaciones.getMainContainer().as(VerticalLayout.class)
					.add(new Listadenotificaciones_item(_listadenotificaciones));
		}
		this.getNotificationListMenciones().add(_listadenotificaciones);
	}
}