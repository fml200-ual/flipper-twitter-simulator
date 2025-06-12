package interfaz;

import vistas.VistaListadeusuarios_item;
import mds2.MainView;
import mds2.MainView.Pantalla;

public class Listadeusuarios_item extends VistaListadeusuarios_item {
	// private event _mostrarmsusuarios;
	public Listadeusuarios _listadeusuarios;

	public Listadeusuarios_item(Listadeusuarios _listadeusuarios) {
		super();
		this._listadeusuarios = _listadeusuarios;

		// Añadir evento de clic para navegar al perfil del usuario
		this.getMainContainer().addClickListener(event -> {
			navegarAlPerfilDelUsuario();
		});
	}

	private void navegarAlPerfilDelUsuario() {
		// Determinar el tipo de perfil basado en el contexto del usuario
		if (Pantalla.usuario == 2) {
			// Crear y mostrar perfil para usuario registrado
			Verperfilregistrado perfilRegistrado = new Verperfilregistrado((Listafijadeusuariosregistrado) null);
			System.out.println("Mostrando perfil registrado");
			MainView.Pantalla.MainView.removeAll();
			MainView.Pantalla.MainView.add(perfilRegistrado);
		} else {
			// Crear y mostrar perfil para usuario no registrado
			Verperfilnoregistrado perfilNoRegistrado = new Verperfilnoregistrado(
					(Listafijadeusuariosnoregistrado) null);
			System.out.println("Mostrando perfil no registrado");
			MainView.Pantalla.MainView.removeAll();
			MainView.Pantalla.MainView.add(perfilNoRegistrado);
		}
	}

	public void Mostrarmsusuarios() {
		throw new UnsupportedOperationException();
	}
}