package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
		for (int i = 0; i < 5; i++) {
			_listadenotificaciones.getMainContainer().as(VerticalLayout.class)
					.add(new Listadenotificaciones_item(_listadenotificaciones));
		}
		this.getNotificationListRetweets().add(_listadenotificaciones);
	}
}