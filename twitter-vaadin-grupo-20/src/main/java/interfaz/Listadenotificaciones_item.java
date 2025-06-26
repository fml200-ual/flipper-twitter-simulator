package interfaz;

import vistas.VistaListadenotificaciones_item;

public class Listadenotificaciones_item extends VistaListadenotificaciones_item {
	// private event _eliminarnotificacin;
	// private event _mostrarmsnotificaciones;
	public Listadenotificaciones _listadenotificaciones;

	// Objeto que puede contener cualquier tipo de notificación
	basededatos.Usuario_Registrado u; // Puede ser PropiedadesMencion, PropiedadesSeguidos, PropiedadesBaneo, etc.

	// Constructor original (compatibilidad)
	public Listadenotificaciones_item(Listadenotificaciones _listadenotificaciones) {
		this._listadenotificaciones = _listadenotificaciones;
	}

	// Nuevo constructor que recibe la entidad de notificación
	public Listadenotificaciones_item(Listadenotificaciones _listadenotificaciones, basededatos.Usuario_Registrado u) {
		super();
		this._listadenotificaciones = _listadenotificaciones;
		this.u = u;

		this.getDescriptionLabel().setText("@" + this.u.getNickname() + " ha hecho retweet a uno de tus tweets");

		this.getSeenCheckbox().setVisible(false);
	}

	public void Eliminarnotificacin() {
		// TODO: A lo mejor elimnar metodo

	}

	public void Mostrarmsnotificaciones() {
		// TODO: Implementar mostrar más notificaciones
	}
}