package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import mds2.MainView.Pantalla;
import vistas.VistaVerlistaseguidoresnoregistrado;

public class Verlistaseguidoresnoregistrado extends VistaVerlistaseguidoresnoregistrado {
	public Verperfilnoregistrado _verperfilnoregistrado;
	public Listadeusuarios _listadeusuarios;

	public Verlistaseguidoresnoregistrado(Verperfilnoregistrado verperfilnoregistrado) {
		super();
		this._verperfilnoregistrado = verperfilnoregistrado;

		// Obtener el usuario del perfil
		basededatos.Usuario_Registrado usuario = null;
		if (_verperfilnoregistrado != null && _verperfilnoregistrado.u != null) {
			usuario = _verperfilnoregistrado.u;
		}

		this.getNoFollowersMessage().setVisible(false);
		
		// Establecer el nombre de usuario en la vista
		if (usuario != null) {
			this.getUsername().setText(usuario.getNickname());
			System.out.println("Cargando seguidores para usuario: " + usuario.getNickname());
			
			// Usar la implementación simplificada
			Listadeusuarios(usuario);
		} else {
			this.getNoFollowersMessage().setVisible(true);
			System.err.println("Usuario no válido para cargar seguidores");
		}

		this.getBackButton().addClickListener(event -> {
			Pantalla.MainView.removeAll();
			Pantalla.MainView.add(_verperfilnoregistrado);
		});
	}

	public void Listadeusuarios(basededatos.Usuario_Registrado usuario) {
		// Usar el constructor específico que maneja seguidores automáticamente (igual que registrados)
		_listadeusuarios = new Listadeusuarios(this, usuario);

		this.getFollowersListContainer().as(VerticalLayout.class).add(_listadeusuarios);
	}
}