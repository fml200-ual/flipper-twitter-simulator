package interfaz;

import java.util.Vector;

import vistas.VistaListadenotificaciones;

public class Listadenotificaciones extends VistaListadenotificaciones{
	public Vernotificacionesderetweets _vernotificacionesderetweets;
	public Vernotificacionesdemenciones _vernotificacionesdemenciones;
	public Vernotificacionesseguimiento _vernotificacionesseguimiento;
	public Vector<Listadenotificaciones_item> _item = new Vector<Listadenotificaciones_item>();

	public Listadenotificaciones(Vernotificacionesderetweets _vernotificacionesderetweets) {
		super();
		this._vernotificacionesderetweets = _vernotificacionesderetweets;
	}

	public Listadenotificaciones(Vernotificacionesdemenciones _vernotificacionesdemenciones) {
		super();
		this._vernotificacionesdemenciones = _vernotificacionesdemenciones;
	}

	public Listadenotificaciones(Vernotificacionesseguimiento _vernotificacionesseguimiento) {
		super();
		this._vernotificacionesseguimiento = _vernotificacionesseguimiento;
	}

}