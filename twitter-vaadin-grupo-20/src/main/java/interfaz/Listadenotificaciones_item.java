package interfaz;

import vistas.VistaListadenotificaciones_item;

public class Listadenotificaciones_item extends VistaListadenotificaciones_item {
	// private event _eliminarnotificacin;
	// private event _mostrarmsnotificaciones;
	public Listadenotificaciones _listadenotificaciones;

	public Listadenotificaciones_item(Listadenotificaciones _listadenotificaciones) {
		super();
		this._listadenotificaciones = _listadenotificaciones;

		this.getSeenCheckbox().addClickListener(event -> {
			Eliminarnotificacin();
		});
	}

	public void Eliminarnotificacin() {
		// TODO
	}

	public void Mostrarmsnotificaciones() {
		// TODO
	}
}