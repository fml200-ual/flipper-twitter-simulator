package interfaz;

import vistas.VistaPerspectivabloqueado;
import mds2.MainView.Pantalla;

public class Perspectivabloqueado extends VistaPerspectivabloqueado {
	public Listafijadeusuariosregistrado _listafijadeusuariosregistrado;
	public Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado;
	public basededatos.Usuario_Registrado usuarioBloqueador; // El usuario que nos bloqueó

	public Perspectivabloqueado(Listafijadeusuariosregistrado _listafijadeusuariosregistrado) {
		super();
		this._listafijadeusuariosregistrado = _listafijadeusuariosregistrado;
		configurarNavegacion();
	}

	public Perspectivabloqueado(Verlistaampliadadeusuariosregistrado _verlistaampliadadeusuariosregistrado) {
		super();
		this._verlistaampliadadeusuariosregistrado = _verlistaampliadadeusuariosregistrado;
		configurarNavegacion();
	}
	
	// Constructor con usuario bloqueador
	public Perspectivabloqueado(basededatos.Usuario_Registrado usuarioBloqueador) {
		super();
		this.usuarioBloqueador = usuarioBloqueador;
		configurarNavegacion();
		
		// Configurar datos del usuario que nos bloqueó si está disponible
		if (usuarioBloqueador != null) {
			this.getUsernameText().setText(usuarioBloqueador.getNickname());
			this.getHandleText().setText("@" + usuarioBloqueador.getNickname());
		}
	}
	
	private void configurarNavegacion() {
		// Configurar navegación hacia atrás (similar a como se hace en otros componentes)
		// Aquí podríamos agregar un botón de "Volver" si fuera necesario
		// Por ahora la navegación se maneja desde donde se llama esta vista
	}
	
	/**
	 * Método para volver a la vista anterior
	 */
	public void volverAtras() {
		if (Pantalla.Anterior != null) {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(Pantalla.Anterior);
		}
	}

}