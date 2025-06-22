package interfaz;

import mds2.MainView.Pantalla;
import vistas.VistaVernotificaciones;

public class Vernotificaciones extends VistaVernotificaciones {
	public ACT02UsuarioRegistrado _aCT02UsuarioRegistrado;
	public Vernotificacionesseguimiento _vernotificacionesseguimiento;
	public Vernotificacionesdemenciones _vernotificacionesdemenciones;
	public Vernotificacionesderetweets _vernotificacionesderetweets;

	public Vernotificaciones(ACT02UsuarioRegistrado _aCT02UsuarioRegistrado) {
		super();
		this._aCT02UsuarioRegistrado = _aCT02UsuarioRegistrado;

		this.getBoton_seguimiento().addClickListener(event -> Vernotificacionesseguimiento());
		this.getBoton_menciones().addClickListener(event -> Vernotificacionesdemenciones());
		this.getBoton_retweets().addClickListener(event -> Vernotificacionesderetweets());
		this.getBoton_volver().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_aCT02UsuarioRegistrado);
		});
	}

	public void Vernotificacionesseguimiento() {
		_vernotificacionesseguimiento = new Vernotificacionesseguimiento(this);
		this.getNotificationList().removeAll();
		this.getNotificationList().add(_vernotificacionesseguimiento);
	}

	public void Vernotificacionesdemenciones() {
		_vernotificacionesdemenciones = new Vernotificacionesdemenciones(this);
		this.getNotificationList().removeAll();
		this.getNotificationList().add(_vernotificacionesdemenciones);
	}

	public void Vernotificacionesderetweets() {
		_vernotificacionesderetweets = new Vernotificacionesderetweets(this);
		this.getNotificationList().removeAll();
		this.getNotificationList().add(_vernotificacionesderetweets);
	}
}